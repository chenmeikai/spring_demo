package com.kenhome.manager.listener;

import com.kenhome.common.constant.system.SystemModuleEnum;
import com.kenhome.common.entity.system.Acl;
import com.kenhome.manager.config.anotation.AddAcl;
import com.kenhome.service.service.system.AclService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;

/**
 * @Author: cmk
 * @Description: 添加权限记录
 * @Date: Created in 9:23 2018/10/11 0011
 * @Modified By:
 */

@Slf4j
@Component
public class AclListener implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private AclService aclService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

        //已有资源记录
        List<Acl> existAcls = aclService.findAll();
        Map<String, Acl> existMap = new HashMap<>();
        for (Acl acl : existAcls) {
            if (StringUtils.isNotEmpty(acl.getUrl())) {
                existMap.put(acl.getUrl(), acl);
            }
        }

        ApplicationContext applicationContext = applicationReadyEvent.getApplicationContext();

        RequestMappingHandlerMapping handlerMapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = handlerMapping.getHandlerMethods();
        Set<Map.Entry<RequestMappingInfo, HandlerMethod>> tempEntrySet = handlerMethods.entrySet();
        Iterator<Map.Entry<RequestMappingInfo, HandlerMethod>> tempIterator = tempEntrySet.iterator();

        List<Acl> acls = new ArrayList<Acl>();
        handlerMappingLoop:
        while (tempIterator.hasNext()) {
            Map.Entry<RequestMappingInfo, HandlerMethod> handlerMethodEntry = tempIterator.next();
            RequestMappingInfo mappingInfo = handlerMethodEntry.getKey();
            HandlerMethod handlerMethod = handlerMethodEntry.getValue();

            String url = null;
            Set<String> mappingPatterns = mappingInfo.getPatternsCondition().getPatterns();
            if (mappingPatterns != null && mappingPatterns.size() > 0) {
                url = mappingPatterns.iterator().next();
                if (StringUtils.isNotEmpty(url)) {
                    url = url.trim();
                } else {
                    continue handlerMappingLoop;
                }
            } else {
                continue handlerMappingLoop;
            }

            if (StringUtils.isEmpty(url)) {
                continue handlerMappingLoop;
            }

            Set<RequestMethod> requestMethods = mappingInfo.getMethodsCondition().getMethods();
            if (requestMethods == null || (requestMethods.size() > 0 && (!requestMethods.contains(RequestMethod.GET)))) {
                continue handlerMappingLoop;
            }

            AddAcl annotationAcl = handlerMethod.getMethodAnnotation(AddAcl.class);
            if (annotationAcl == null || StringUtils.isEmpty(annotationAcl.name()) || annotationAcl.type() == null || StringUtils.isEmpty(annotationAcl.permission())) {
                continue handlerMappingLoop;
            }

            Acl acl = new Acl();
            acl.setModule(SystemModuleEnum.MANAGER);
            acl.setName(annotationAcl.name());
            acl.setType(annotationAcl.type());
            acl.setPermission(annotationAcl.permission());
            acl.setIsShow(annotationAcl.show());
            acl.setUrl(url);
            acls.add(acl);
        }

        //添加新的记录
        for (Acl acl : acls) {
            Acl checkAcl =existMap.get(acl.getUrl());
            if(checkAcl ==null){
                aclService.save(acl);
            }
        }

    }
}
