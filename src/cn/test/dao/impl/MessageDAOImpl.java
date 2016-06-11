package cn.test.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import cn.test.dao.MessageDAO;
import cn.test.dao.ReplyDAO;
import cn.test.dao.impl.*;
import cn.test.model.Message;
import cn.test.model.Reply;
import cn.test.util.BaseDaoUtil;;

@Repository("messageDAOImpl")
public class MessageDAOImpl<T> implements MessageDAO<T> {
	@SuppressWarnings("unchecked")
	protected Class<T> entityClass = BaseDaoUtil.getClassGenricType(getClass());

	@Autowired
	public SessionFactory sessionFactory;

	//�õ����е�����
	@Override
	@SuppressWarnings("unchecked")
	public List<T> getAllMessages() {
		// TODO Auto-generated method stub

		return sessionFactory.getCurrentSession().createQuery("from Message").list();

	}
	
	//����һƪ����
	@Override
	public void addMessage(T t) {
		// TODO Auto-generated method stub

		sessionFactory.getCurrentSession().save(t);

	}

	/**
	 * ��ҳ��ѯ����
	 * @param currentPage ��ѯ��currentPageҳ�ļ�¼
	 * @param pageSize ÿҳ��Ҫ��ʾ�ļ�¼��
	 * @return ��ǰҳ�����м�¼
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> getPageByMessages(int currentPage, int pageSize) {
		// ������ѯ
		return sessionFactory.getCurrentSession().createQuery("from Message order by createdate desc")
				.setFirstResult((currentPage - 1) * pageSize)// ִ�з�ҳ
				.setMaxResults(pageSize).list();
	}
	
	//�õ���ҳ��
	public int getPageCount(int pageSize) {
		return sessionFactory.getCurrentSession().createQuery("from Message").list().size()/pageSize;
	}

	//����id��ȡ����
	@Override
	public T getById(String id) {
		System.out.println("232323"+entityClass);
		T t = null;
		Session session = sessionFactory.getCurrentSession();
		List list = session.createQuery("from Message where messageid = :ID").setParameter("ID", id).list();
		Iterator<T> iterator = list.iterator();
		while(iterator.hasNext())
			t = iterator.next();
		return t;

		// return (T)sessionFactory.getCurrentSession().get(entityClass, id);
	}

	@Override
	public void deleteById(T t) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(t);
	}

	
	
	@Override
	public List<T> getPageByMessagesByTitle(String keyword, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Message where title like :keyword order by createdate desc").setParameter("keyword",  "%"+keyword+"%")
				.setFirstResult((currentPage - 1) * pageSize)// ִ�з�ҳ
				.setMaxResults(pageSize).list();
	}

	@Override
	public int getPageCountByTitle(String keyword, int pageSize) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Message where title like :keyword order by createdate desc").setParameter("keyword", "%"+keyword+"%").list().size()/pageSize;
		
	}
}
