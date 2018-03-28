package com.qfedu.lvyou.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.qfedu.lvyou.WoException;
import com.qfedu.lvyou.WoResultCode;
import com.qfedu.lvyou.model.PageBean;
import com.qfedu.lvyou.model.User;
import com.qfedu.lvyou.service.IFileService;
import com.qfedu.lvyou.service.IUserService;

@Controller
@RequestMapping("/sys/user")
public class UserController {

	private final static Logger LOG = LogManager.getLogger(UserController.class);

	@Resource // @Autowired
	private IUserService userService;

	@RequestMapping("/list")
	public ModelAndView getList() {
		ModelAndView mav = new ModelAndView();
		PageBean<User> users = userService.getUsersByLoginName("", 0L, 10L);
		mav.addObject("pgUsers", users);
		mav.setViewName("user/list");
		return mav;
	}

	@RequestMapping("/loadCreateForm")
	public String loadCreateForm() {
		return "user/createForm";
	}

	private final static String UPLOAD_DIR = "upload";
	
	@Resource // @Autowired
	private IFileService fileService;
	
	@ResponseBody
	@RequestMapping("/create")
	public Object createUser(User user, MultipartFile headImageFile, HttpServletRequest request) {
		try {
			if (headImageFile != null) {
				String path = fileService.uploadFile(headImageFile, request);
				user.setHeadImage(path);
			}
			userService.createUser(user);
			return WoResultCode.getSuccess();
		} catch (WoException e) {
			LOG.error(e.getMessage(), e);
			return e.getCode();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return WoResultCode.getUnknown().setMsg("创建用户失败！");
		}
	}

	@RequestMapping("/search")
	public ModelAndView searchUsers(String loginName, Long woPageStart, Long woPageSize) {
		ModelAndView mav = new ModelAndView();
		PageBean<User> users = userService.getUsersByLoginName(loginName, woPageStart, woPageSize);
		mav.addObject("pgUsers", users);
		mav.setViewName("user/search");
		return mav;
	}

	@RequestMapping("/loadUpdateForm")
	public ModelAndView loadUpdateForm(String userId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/updateForm");
		User user = userService.getUserById(userId);
		mav.addObject("user", user);
		return mav;
	}

	@ResponseBody
	@RequestMapping("/update")
	public Object updateUser(User user, MultipartFile headImageFile, String headImageClick, HttpServletRequest request) {
		try {
			if ("-1".equals(headImageClick)) {
				if (headImageFile == null) {
					user.setHeadImage(null);
				} else {
					String path = fileService.uploadFile(headImageFile, request);
					user.setHeadImage(path);
				}
			}
			userService.updateUser(user);
			return WoResultCode.getSuccess();
		} catch (WoException e) {
			LOG.error(e.getMessage(), e);
			return e.getCode();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return WoResultCode.getUnknown().setMsg("修改用户失败！");
		}
	}

	@ResponseBody
	@RequestMapping("/delete")
	public Object deleteUsers(String userIds) {
		String[] ids = userIds.split(",");
		try {
			userService.deleteUsers (ids);
			return WoResultCode.getSuccess();
		} catch (WoException e) {
			LOG.error(e.getMessage(), e);
			return e.getCode();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return WoResultCode.getUnknown().setMsg("删除用户失败！");
		}
	}
	
	@RequestMapping("/loadImportForm")
	public String loadImportForm() {
		return "user/importForm";
	}
	
	private final static WoResultCode IMPORT_FILE = new WoResultCode (5001, "您还没有选择上传的数据文件！");
	
	private final static WoResultCode IMPORT_DATA = new WoResultCode (5002, "您上传的数据文件中没有用户数据！");
	
	@ResponseBody
	@RequestMapping ("/import")
	public Object importUsers (MultipartFile importFile) {
		Workbook book = null;
		try {
			if (importFile == null) {
				throw new WoException (IMPORT_FILE);
			}
			String fileName = importFile.getOriginalFilename();
			if (fileName.endsWith(".xlsx")) {
				book = new XSSFWorkbook(importFile.getInputStream());
			} else {
				book = new HSSFWorkbook(importFile.getInputStream());
			}
			Sheet sheet = book.getSheetAt(0);
			if (sheet.getLastRowNum() < 1) {
				throw new WoException (IMPORT_DATA);
			}
			List<User> users = new ArrayList<User>();
			for (int i = 1; i <= sheet.getLastRowNum(); i ++) {
				Row r = sheet.getRow(i);
				User u = new User();
				u.setId(r.getCell(0).getStringCellValue());
				u.setLoginName(r.getCell(1).getStringCellValue());
				u.setCreateTime(r.getCell(2).getDateCellValue());
				u.setPassword("123456");
				users.add(u);
			}
			userService.importUsers (users);
			return WoResultCode.getSuccess();
		} catch (WoException e) {
			LOG.error(e.getMessage(), e);
			return e.getCode();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return WoResultCode.getUnknown().setMsg("导入用户数据失败！");
		}
	}
	
	
	@Resource
	@Qualifier("userExcelView")
	private View userExcelView;
	
	/**
	 * @return
	 */
	@RequestMapping("/export")
	public ModelAndView exportUsers () {
		ModelAndView mav = new ModelAndView();
		mav.setView(userExcelView);
		mav.addObject("users", userService.getUsers());
		return mav;
	}
}
