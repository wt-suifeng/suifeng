package com.qfedu.lvyou.service.impl;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.qfedu.lvyou.WoException;
import com.qfedu.lvyou.WoResultCode;
import com.qfedu.lvyou.service.IFileService;

@Service
public class FileService implements IFileService {

	private final static String DIR_UPLOAD = "upload/";
	
	private final static WoResultCode SAVE = new WoResultCode(3001, "保存文件到服务端失败！");
	
	@Override
	public String uploadFile(MultipartFile file, HttpServletRequest request) {
		// 获取服务器上传文件的目录全路径
		String path = request.getServletContext().getRealPath(DIR_UPLOAD);
		// 获取上传文件名称
		String fileName = file.getOriginalFilename();
		// 如果upload目录不存在，则创建
		File dirUpload = new File (path);
		if (!dirUpload.exists()) {
			dirUpload.mkdirs();
		}
		// 构造目标文件
		File targetFile = new File (path, fileName);
		// 保存文件到目标文件
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			throw new WoException (SAVE);
		}
		return DIR_UPLOAD + fileName;
	}

}
