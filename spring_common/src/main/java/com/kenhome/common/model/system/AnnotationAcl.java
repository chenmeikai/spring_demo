package com.kenhome.common.model.system;

import com.kenhome.common.constant.system.SystemAclEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: cmk
 * @Description:
 * @Date: Created in 14:05 2018/10/11 0011
 * @Modified By:
 */
@Getter
@Setter
public class AnnotationAcl {

    private String name;

    private SystemAclEnum type;

    private String url;

    private Integer show;
}
