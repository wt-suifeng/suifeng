package com.qfedu.lvyou.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.qfedu.lvyou.dao.ICommentDao;
import com.qfedu.lvyou.model.Comment;
import com.qfedu.lvyou.service.ICommentService;

@Service
@Transactional
public class CommentService implements ICommentService {

	@Resource
	private ICommentDao commentDao;
	
	@Override
	public List<Comment> getComments() {
		return commentDao.getComments();
	}

}
