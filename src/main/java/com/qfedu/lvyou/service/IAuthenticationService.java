package com.qfedu.lvyou.service;

import java.util.Map;

public interface IAuthenticationService {
	
	/**
	 * @param user
	 * @param password
	 * @return
	 */
	public Map<String, Object> authenticate (String user, String password);
}
