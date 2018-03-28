package com.qfedu.lvyou.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qfedu.lvyou.dao.IMenuDao;
import com.qfedu.lvyou.model.Menu;

@Repository
public class MenuDao implements IMenuDao {

	@Resource // @Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Menu> getTopMenus() {
		String hql = "from Menu m where m.parent.id is null or m.parent.id = '' order by m.no";
		return sessionFactory.getCurrentSession().createQuery(hql, Menu.class).getResultList();
	}

	@Override
	public List<Menu> getSubMenusByParent(String parentId) {
		String hql = "from Menu m where m.parent.id= :parentId order by m.no";
		List<Menu> resultList = sessionFactory.getCurrentSession().createQuery(hql, Menu.class)
				.setParameter("parentId", parentId).getResultList();
		return resultList;
	}

	@Override
	public List<Menu> getAllMenus() {
		String hql = "from Menu m order by m.no";
		List<Menu> menus = sessionFactory.getCurrentSession().createQuery(hql, Menu.class).getResultList();
		return menus;
	}

	@Override
	public void createMenu(Menu menu) {
		sessionFactory.getCurrentSession().persist(menu);
	}

	@Override
	public Menu getMenuById(String menuId) {
		return sessionFactory.getCurrentSession().get(Menu.class, menuId);
	}

	@Override
	public List<Menu> getMenusByName(String name) {
		String hql = "from Menu m where m.name like :name order by m.no";
		return sessionFactory.getCurrentSession().createQuery(hql, Menu.class)
				.setParameter("name", "%" + name + "%")
				.getResultList();
	}

	@Override
	public void updateMenu(Menu menu) {
		sessionFactory.getCurrentSession().merge(menu);
	}

	@Override
	public void deleteMenu(Menu m) {
		sessionFactory.getCurrentSession().delete(m);
	}
}
