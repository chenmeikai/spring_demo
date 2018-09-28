package com.kenhome.server.service.user;

import com.kenhome.common.entity.account.User;
import com.kenhome.server.base.BaseService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author cmk
 * @Description
 * @Date 2018\9\18 0018 22:17
 */
public interface UserService extends BaseService<User> {

    List<User> getFriendsByUserId(String userId);

}
