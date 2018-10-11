package com.kenhome.common.entity.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kenhome.common.constant.account.SexEnum;
import com.kenhome.common.constant.system.SystemAclEnum;
import com.kenhome.common.constant.system.SystemModuleEnum;
import com.kenhome.common.entity.BaseEntity;
import com.kenhome.common.utils.code.CodeGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @Author cmk
 * @Description
 * @Date 2018\10\11 0016 14:21
 */

@Entity
@Table(name = "t_acl")
@Getter
@Setter
@ToString
public class Acl extends BaseEntity {

    @Column(name = "permission")
    private String permission;

    @Column(name = "module")
    private SystemModuleEnum module;

    @Column(name = "type")
    private SystemAclEnum type;

    @Column(name = "name")
    private String name;

    @Column(name = "is_show")
    private Integer isShow;

    @Column(name = "url")
    private String  url;

}
