package com.qfedu.lvyou.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
	
	/**
	 * @param file
	 * @param request
	 * @return 文件在web根路径下的相对路径
	 */
	public String uploadFile (MultipartFile file, HttpServletRequest request);
}
