package com.kenhome.manager.controller.account;

import com.alibaba.fastjson.JSON;
import com.kenhome.common.constant.system.SystemAclEnum;
import com.kenhome.common.entity.account.User;
import com.kenhome.common.model.universal.PageModel;
import com.kenhome.manager.config.anotation.Acl;
import com.kenhome.service.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author cmk
 * @Description
 * @Date 2018\9\16 0016 21:40
 */
@Controller
@RequestMapping("manager/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("list.json")
    @Acl(name = "会员列表",type =SystemAclEnum.MANAGER_ACCOUNT,permission = "manager:account:list",show=1)
    public String  list(){
        return null;
    }

    @GetMapping("view.json")
    @Acl(name = "会员详情",type =SystemAclEnum.MANAGER_ACCOUNT,permission = "manager:account:view")
    @ResponseBody
    public PageModel<User> test(PageModel<User> pageModel){
        PageModel<User> page = userService.findPage(pageModel);
        log.info("用户信息:{}", JSON.toJSONString(page));
        return page;
    }

    @GetMapping("save.json")
    @ResponseBody
    public String save(String username,String password,String phone){
        return  null;
    }

    @GetMapping("getFriends.json")
    @ResponseBody
    public List<User> getFriends(String userId){
        List<User> users = userService.getFriendsByUserId(userId);
        log.info("好友信息:{}", JSON.toJSONString(users));
        return users;
    }
}
