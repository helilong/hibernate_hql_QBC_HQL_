package com.xiaohe.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.xiaohe.entity.Customer;
import com.xiaohe.utils.HibernateUtils;

public class Test_OBC {
	
	//��ѯȫ��
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
			
			//1 ��������
			Criteria criteria = session.createCriteria(Customer.class);
			//2���÷����õ��Ľ��
			List<Customer> list = criteria.list();
			
			for(Customer customer : list) {
				System.out.println(customer.getCustName());
			}
			
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
	
	
	//������ѯ
	@Test
	public void Test_if () {
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
			
			//1 ��������
			Criteria criteria = session.createCriteria(Customer.class);
			/*
			 * 2.ʹ��Criteria��������ķ�����������ֵ
			 * 	������add���� ��ʾ��������ֵ
			 * 	��add��������ʹ����
			 */
			criteria.add(Restrictions.eq("cid", 1));
			criteria.add(Restrictions.eq("custName", "xiaohe"));
			//3 ���÷����õ��Ľ��
			List<Customer> list = criteria.list();
			
			for(Customer customer : list) {
				System.out.println(customer.getCustName());
			}
			
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
	
	//ģ����ѯ
	
	@Test
	public void Test_like() {
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
			
			//1 ��������
			Criteria criteria = session.createCriteria(Customer.class);
			
			//2����ģ��ֵ
			criteria.add(Restrictions.ilike("custName", "%h%"));
			
			//3���÷����õ��Ľ��
			List<Customer> list = criteria.list();
			
			for(Customer customer : list) {
				System.out.println(customer.getCustName());
			}
			
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
	
	//�����ѯ
	@Test
	public void Test_order() {
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
			
			//1 ��������
			Criteria criteria = session.createCriteria(Customer.class);
			
			//2.���ö��Ǹ����Խ������� ��������
			//��
			criteria.addOrder(Order.asc("cid"));
			//��
			criteria.addOrder(Order.desc("cid"));
			//3���÷����õ��Ľ��
			List<Customer> list = criteria.list();
			
			for(Customer customer : list) {
				System.out.println(customer.getCustName());
			}
			
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
	
	//��ҳ��ѯ
	@Test
	public void Test_fy() {
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
			
			//1 ��������
			Criteria criteria = session.createCriteria(Customer.class);
			
			//2 ����
			criteria.setFirstResult(0);
			criteria.setMaxResults(3);
			
			//3���÷����õ��Ľ��
			List<Customer> list = criteria.list();
			
			for(Customer customer : list) {
				System.out.println(customer.getCustName());
			}
			
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

	//ͳ�Ʋ�ѯ
	@Test
	public void Test_tj() {
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
			
			//1 ��������
			Criteria criteria = session.createCriteria(Customer.class);
			
			//2. ���ò���
			criteria.setProjection(Projections.rowCount());
			
			//3.���÷����õ��Ľ��
			List<Customer> list = criteria.list();
			
			for(Customer customer : list) {
				System.out.println(customer.getCustName());
			}
			
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

	//���߲�ѯ
	@Test
	public void Test_lx() {
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
			
			//1 ��������
			//Criteria criteria = session.createCriteria(Customer.class);
			DetachedCriteria detachedCriteria =DetachedCriteria.forClass(Customer.class);
			
			
			//2����ִ��ʱ�����Ҫ��session
			Criteria criteria = detachedCriteria.getExecutableCriteria(session);
			
			List<Customer> list = criteria.list();
			//3���÷����õ��Ľ��
			//List<Customer> list = criteria.list();
			
			for(Customer customer : list) {
				System.out.println(customer.getCustName());
			}
			
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
