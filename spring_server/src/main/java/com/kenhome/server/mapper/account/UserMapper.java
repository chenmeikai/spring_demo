package com.kenhome.server.mapper.account;

import com.kenhome.common.entity.account.User;
import com.kenhome.server.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * MemberMapper
 *
 * @author cmk
 * @version 1.0
 * @create 2018-09-18 14:18:25
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from t_user where username = #{username}")
    User findByUsername(@Param("username") String username);


}
