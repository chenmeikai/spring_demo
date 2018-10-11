package com.kenhome.service.service.system.impl;

import com.kenhome.common.entity.system.Acl;
import com.kenhome.service.base.BaseMapper;
import com.kenhome.service.base.BaseServiceImpl;
import com.kenhome.service.mapper.system.AclMapper;
import com.kenhome.service.service.system.AclService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author cmk
 * @Description
 * @Date 2018\10\11 0018 15:14
 */
@Service
public class AclServiceImpl extends BaseServiceImpl<Acl> implements AclService {

    @Autowired
    private AclMapper aclMapper;

    @Override
    protected BaseMapper<Acl> getBaseMapper() {
        return aclMapper;
    }

}
