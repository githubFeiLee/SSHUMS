package com.qingshixun.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.qingshixun.dao.impl.BaseDaoImpl;
import com.qingshixun.model.User;
import com.qingshixun.service.IUserService;

@Component
@Transactional
public class MyUserDetailService extends BaseDaoImpl<User> implements UserDetailsService {

	@Autowired
	private IUserService userService;
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// 鍙互杩斿洖User绫诲瀷涔嬪悗鍦ㄨ浆鎹㈡垚UserDetails绫诲瀷ps:瀹炰綋bean蹇呴』瀹炵幇UserDetails鎺ュ彛锛屽惁鍒欐棤娉曡浆鎹�
		UserDetails user = findByUsername(username);
		User user1 = userService.queryUserLogin(username);

		// 鐢ㄦ埛涓嶅瓨鍦�
        if (user1 == null) {
            throw new BadCredentialsException("鐢ㄦ埛鍚嶆垨瀵嗙爜涓嶆纭紒");
        }

        // 鐢ㄦ埛琚鐢�
        if (user1.getStatus().equals("绂佺敤")) {
            throw new BadCredentialsException("姝ょ敤鎴峰凡琚鐢紒");
        }

        return user = (UserDetails)user1;
	}
}
