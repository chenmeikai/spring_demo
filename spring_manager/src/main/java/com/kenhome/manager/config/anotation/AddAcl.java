package com.kenhome.manager.config.anotation;

import com.kenhome.common.constant.system.SystemAclEnum;

import java.lang.annotation.*;

/**
 * @Author: cmk
 * @Description: 访问资源注解，用于扫描后记录到acl表
 * @Date: Created in 16:17 2018/10/10 0010
 * @Modified By:
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface AddAcl {

    //权限名
    String name();

    //类型
    SystemAclEnum type();

    //权限标识
    String permission();

    //是否显示在菜单栏，默认否0，显示1
    int show() default 0;
}
