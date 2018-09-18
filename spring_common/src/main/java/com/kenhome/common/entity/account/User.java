package com.kenhome.common.entity.account;

import com.alibaba.fastjson.annotation.JSONField;
import com.kenhome.common.constant.account.SexEnum;
import com.kenhome.common.entity.BaseEntity;
import com.kenhome.common.utils.code.CodeGenerator;
import com.kenhome.common.utils.code.EntityIdGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author cmk
 * @Description
 * @Date 2018\9\16 0016 17:58
 */

@Entity
@Table(name = "t_user")
@Getter
@Setter
@ToString
public class User extends BaseEntity {

    @Column(name = "user_no")
    private String userNo;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "signatrue")
    private String signatrue;

    @Column(name = "sex")
    private SexEnum sex;

    @Column(name = "birthday")
    @JSONField(format = "yyyy-MM-dd 00:00:00")
    private Date birthday;

    @Column(name = "phone")
    private String phone;

    @Column(name = "real_name")
    private String realName;

    @Column(name = "intro")
    private String intro;

    @Column(name = "head_portrait")
    private String headPortrait;

    @Column(name = "age")
    private Integer age;

    @Column(name = "constellation")
    private String constellation;

    @Column(name = "blood_type")
    private String bloodType;

    @Column(name = "school_tag")
    private String schoolTag;

    @Column(name = "vocation")
    private String vocation;

    @Column(name = "nation_id")
    private Integer nationId;

    @Column(name = "province_id")
    private Integer provinceId;

    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "friendship_policy_id")
    private Integer friendshipPolicyId;

    @Column(name = "user_state")
    private Integer userState;

    @Override
    public void init() {
        super.init();
        this.userNo= CodeGenerator.generateOrderNo();
    }
}
