package com.adong3.fullstack.service;

import com.adong3.fullstack.base.result.Results;
// import com.adong3.fullstack.dto.UserDto;
import com.adong3.fullstack.model.SysUser;

public interface UserService {

    SysUser getUser(String username);

    Results<SysUser> getAllUsers();

    Results<SysUser> getAllUsersByPage(Integer startPosition, Integer limit);

    SysUser getUserByPhone(String phone);

    SysUser getUserByEmail(String email);

    Results save(SysUser user, Integer roleId);

    SysUser getUserById(Long id);

    // Results updateUser(UserDto userDto,Integer roleId);

    int deleteUser(Long id);

    Results<SysUser> getUserByFuzzyUserNamePage(String username, Integer startPosition, Integer limit);

}
