package com.qfedu.lvyou.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.qfedu.lvyou.WoException;
import com.qfedu.lvyou.WoResultCode;
import com.qfedu.lvyou.dao.IUserDao;
import com.qfedu.lvyou.model.Employee;
import com.qfedu.lvyou.model.Guest;
import com.qfedu.lvyou.model.Role;
import com.qfedu.lvyou.model.User;
import com.qfedu.lvyou.service.IAuthenticationService;

@Service
@Transactional
public class AuthenticationService implements IAuthenticationService {

	@Resource // @Autowired
	private IUserDao userDao;
	
	private final static WoResultCode FAIL = new WoResultCode (2000, "认证失败！");
	private final static WoResultCode FAIL2 = new WoResultCode (2001, "认证失败222！");
	
	@Override
	public Map<String, Object> authenticate(String loginName, String password) {
		User user = userDao.getUserByLoginName (loginName);
		if (user == null || !user.getPassword().equals(password)) {
			throw new WoException (FAIL);
		}
		Map<String, Object> data = new HashMap<>();
		data.put("user", user);
		if(user.isAdmin()) {
			data.put("role", Role.ADMIN);
			return data; 
		}
		Guest guest = user.getGuest();
		if(guest!=null) {
			data.put("guest", guest);
			data.put("role", Role.GUEST);
		}else {
			Employee employee = user.getEmployee();
			if(employee!=null) {
				data.put("employee", employee);
				data.put("role", Role.EMPLOYEE);
			}else {
				throw new WoException(FAIL2);
			}
		}
		return data;
		
	}

}
