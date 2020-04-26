package com.xiaohe.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.xiaohe.entity.Customer;
import com.xiaohe.utils.HibernateUtils;

public class Test_hql_duo {
	
	
	//�������
	
	//������
	@Test
	public void Test_select() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			//�õ�sessionFactory
			sessionFactory = HibernateUtils.getSessionFactory();
			//�õ�session
			session = sessionFactory.openSession();
			//��������
			tx = session.beginTransaction();
			
			//1 ����query����
			Query query = session.createQuery("from Customer c inner join c.setLinkMan");
			//Query query = session.createQuery("from Customer c inner join fetch c.setLinkMan");
			//2.���÷����õ����
			List list = query.list();
			
			
			
			
			//�ύ����
			tx.commit();
			
		}catch(Exception e) {
			tx.rollback();
		}finally {
			session.close();
			//sessionFactory����Ҫ�ر�
			sessionFactory.close();
		}
	}
	
	//��������
	@Test
	public void Test_left() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			//�õ�sessionFactory
			sessionFactory = HibernateUtils.getSessionFactory();
			//�õ�session
			session = sessionFactory.openSession();
			//��������
			tx = session.beginTransaction();
			
			//1 ����query����
			Query query = session.createQuery("from Customer c left outer join c.setLinkMan");
			//Query query = session.createQuery("from Customer c inner join fetch c.setLinkMan");
			//2.���÷����õ����
			List list = query.list();
			
			//�ύ����
			tx.commit();
			
		}catch(Exception e) {
			tx.rollback();
		}finally {
			session.close();
			//sessionFactory����Ҫ�ر�
			sessionFactory.close();
		}
	}
	
	
	
	
}
