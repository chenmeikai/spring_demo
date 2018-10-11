package com.kenhome.service.mapper.system;

import com.kenhome.common.entity.account.User;
import com.kenhome.common.entity.system.Acl;
import com.kenhome.service.base.BaseMapper;
import com.kenhome.service.mapper.account.provider.UserProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MemberMapper
 *
 * @author cmk
 * @version 1.0
 * @create 2018-10-11 15:07:25
 */
@Repository
public interface AclMapper extends BaseMapper<Acl> {


}
