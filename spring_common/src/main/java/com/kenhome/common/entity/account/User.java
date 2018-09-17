package com.kenhome.common.entity.account;

import com.kenhome.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

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

    private String username;


}
