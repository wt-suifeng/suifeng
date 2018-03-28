package com.qfedu.lvyou.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qfedu.lvyou.model.Comment;
import com.qfedu.lvyou.service.ICommentService;

@Controller
@RequestMapping("/ly/comment")
public class CommentController {
	
	@Resource
	private ICommentService commentService;
	
	@RequestMapping("/list")
	public ModelAndView getList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("comment/list");
		List<Comment> comments = commentService.getComments();
		mav.addObject("comments", comments);
		return mav;
	}
}
