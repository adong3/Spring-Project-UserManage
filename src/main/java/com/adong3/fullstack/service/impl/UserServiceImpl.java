package com.adong3.fullstack.service.impl;

import com.adong3.fullstack.base.result.Results;
// import com.adong3.fullstack.dao.RoleUserDao;
import com.adong3.fullstack.dao.UserDao;
// import com.adong3.fullstack.dto.UserDto;
// import com.adong3.fullstack.model.SysRoleUser;
import com.adong3.fullstack.model.SysUser;
import com.adong3.fullstack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	// @Autowired
	// private RoleUserDao roleUserDao;

	@Override
	public SysUser getUser(String username) {
		return userDao.getUser(username);
	}

	@Override
	public Results<SysUser> getAllUsersByPage(Integer startPosition, Integer limit) {
		return Results.success(userDao.countAllUsers().intValue(), userDao.getAllUsersByPage(startPosition, limit));
	}

	@Override
	public SysUser getUserByPhone(String phone) {
		return userDao.getUserByPhone(phone);
	}

	@Override
	public SysUser getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	// @Override
	// public Results save(SysUser user, Integer roleId) {

	// if (roleId != null) {
	// userDao.save(user);
	// SysRoleUser sysRoleUser = new SysRoleUser();
	// sysRoleUser.setRoleId(roleId);
	// sysRoleUser.setUserId(user.getId().intValue());
	// roleUserDao.save(sysRoleUser);
	// return Results.success();
	// }
	// return Results.failure();
	// }

	@Override
	public SysUser getUserById(Long id) {
		return userDao.getById(id);
	}

	// @Override
	// public Results updateUser(UserDto userDto, Integer roleId) {
	// if (roleId != null) {
	// userDao.updateUser(userDto);
	// SysRoleUser sysRoleUser = new SysRoleUser();
	// sysRoleUser.setUserId(userDto.getId().intValue());
	// sysRoleUser.setRoleId(roleId);
	// if (roleUserDao.getSysRoleUserByUserId(userDto.getId().intValue()) != null) {
	// roleUserDao.updateSysRoleUser(sysRoleUser);
	// } else {
	// roleUserDao.save(sysRoleUser);
	// }
	// return Results.success();
	// } else {
	// return Results.failure();
	// }
	// }

	// public int deleteUser(Long id) {
	// roleUserDao.deleteRoleUserByUserId(id.intValue());
	// return userDao.deleteUser(id);
	// }

	@Override
	public Results<SysUser> getUserByFuzzyUserNamePage(String username, Integer startPosition, Integer limit) {
		return Results.success(userDao.getUserByFuzzyUserName(username).intValue(),
				userDao.getUserByFuzzyUserNamePage(username, startPosition, limit));
	}

	@Override
	public Results<SysUser> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Results save(SysUser user, Integer roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteUser(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
