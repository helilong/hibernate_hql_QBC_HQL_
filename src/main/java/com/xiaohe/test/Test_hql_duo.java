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
	
	
	//多表连接
	
	//内连接
	@Test
	public void Test_select() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			//得到sessionFactory
			sessionFactory = HibernateUtils.getSessionFactory();
			//得到session
			session = sessionFactory.openSession();
			//开启事务
			tx = session.beginTransaction();
			
			//1 创建query对象
			Query query = session.createQuery("from Customer c inner join c.setLinkMan");
			//Query query = session.createQuery("from Customer c inner join fetch c.setLinkMan");
			//2.调用方法得到结果
			List list = query.list();
			
			
			
			
			//提交事务
			tx.commit();
			
		}catch(Exception e) {
			tx.rollback();
		}finally {
			session.close();
			//sessionFactory不需要关闭
			sessionFactory.close();
		}
	}
	
	//左外连接
	@Test
	public void Test_left() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			//得到sessionFactory
			sessionFactory = HibernateUtils.getSessionFactory();
			//得到session
			session = sessionFactory.openSession();
			//开启事务
			tx = session.beginTransaction();
			
			//1 创建query对象
			Query query = session.createQuery("from Customer c left outer join c.setLinkMan");
			//Query query = session.createQuery("from Customer c inner join fetch c.setLinkMan");
			//2.调用方法得到结果
			List list = query.list();
			
			//提交事务
			tx.commit();
			
		}catch(Exception e) {
			tx.rollback();
		}finally {
			session.close();
			//sessionFactory不需要关闭
			sessionFactory.close();
		}
	}
	
	
	
	
}
