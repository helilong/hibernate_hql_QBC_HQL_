package com.xiaohe.test;

import java.util.List;
import java.util.Set;

import org.apache.tomcat.util.digester.SetPropertiesRule;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.xiaohe.entity.Customer;
import com.xiaohe.entity.LinkMan;
import com.xiaohe.utils.HibernateUtils;

public class Test_hql {

	
	
	//hql��ѯ
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
			Query query = session.createQuery("from Customer");
			//2.���÷����õ����
			List<Customer> list = query.list();
			
			for(Customer customer : list) {
				System.out.println(customer.getCid()+":"+customer.getCustName());
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

	//�жϺ�ģ����ѯ
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
			
			//�����ж�
			String p = "from Customer  c where c.cid=? and c.custName=?";
			//ģ����ѯ
			String like = "from Customer  c where c.custName like ?";
			
			
			//1 ����query����
			Query query = session.createQuery(like);
			
			//2.��������ֵ      ����������ֵ
			//setParameter ������������
			//��һ��������int�����ǣ�λ�ã���λ�ô�0��ʼ
			//�ڶ����������������ֵ
			
			//query.setParameter(0,1);
			//query.setParameter(1,"xiaohe");
			
			query.setParameter(0, "%h%");
			//3 ���÷����õ����
			List<Customer> list = query.list();
			
			
			for(Customer customer : list) {
				System.out.println(customer.getCid()+":"+customer.getCustName());
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
			
			//�����ж�
			String p = "from Customer  c where c.cid=? and c.custName=?";
			//ģ����ѯ
			String like = "from Customer  c where c.custName like ?";
			//�����ѯ(����)
			String order = "for Customer order by cid asc";
			//�����ѯ(����)
			String order1 = "for Customer order by cid desc";
			//1 ����query����
			Query query = session.createQuery(order);
			
			//2.��������ֵ      ����������ֵ
			//setParameter ������������
			//��һ��������int�����ǣ�λ�ã���λ�ô�0��ʼ
			//�ڶ����������������ֵ
			
			//query.setParameter(0,1);
			//query.setParameter(1,"xiaohe");
			
			//query.setParameter(0, "%h%");
			//3 ���÷����õ����
			List<Customer> list = query.list();
			
			
			for(Customer customer : list) {
				System.out.println(customer.getCid()+":"+customer.getCustName());
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
	public void Test_limit() {
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
			
			//�����ж�
			String p = "from Customer  c where c.cid=? and c.custName=?";
			//ģ����ѯ
			String like = "from Customer  c where c.custName like ?";
			//�����ѯ(����)
			String order = "for Customer order by cid asc";
			//�����ѯ(����)
			String order1 = "for Customer order by cid desc";
			//��ҳ ����дlimit �з�װ����
			//1 ����query����(��ȫ��))
			Query query = session.createQuery("form Customer");
			
			//2 ���÷�ҳ����
			//2.1���ÿ�ʼλ��
			query.setFirstResult(0);
			//2.2����ÿҳ��¼��
			query.setMaxResults(3);
			
			//3 ���÷����õ����
			List<Customer> list = query.list();
			
			
			for(Customer customer : list) {
				System.out.println(customer.getCid()+":"+customer.getCustName());
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
	 	
	//ͶӰ��ѯ
	@Test
	public void Test_ty() {
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
			//1 ����query����(��ȫ��))
			Query query = session.createQuery("select custName from Customer");
			//2 ���÷����õ����
			List<Object> list = query.list();
			
			
			for(Object object : list) {
				System.out.println(object);
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

	//���Ϻ���
	@Test
	public void Test_f() {
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
			//1 ����query����(��ȫ��))
			Query query = session.createQuery("select count(*) from Customer");
			//2 ���÷����õ����
			Object object= query.uniqueResult();
			
				System.out.println(object);
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
