package com.qfedu.lvyou.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qfedu.lvyou.dao.ICommentDao;
import com.qfedu.lvyou.model.Comment;

@Repository
public class CommentDao implements ICommentDao {

	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public List<Comment> getComments() {
		String hql = "from Comment c";
		return sessionFactory.getCurrentSession().createQuery(hql,Comment.class).getResultList();
	}

}
