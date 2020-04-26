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
	
	//查询全部
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
			
			//1 创建对象
			Criteria criteria = session.createCriteria(Customer.class);
			//2调用方法得到的结果
			List<Customer> list = criteria.list();
			
			for(Customer customer : list) {
				System.out.println(customer.getCustName());
			}
			
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
	
	
	//条件查询
	@Test
	public void Test_if () {
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
			
			//1 创建对象
			Criteria criteria = session.createCriteria(Customer.class);
			/*
			 * 2.使用Criteria对象里面的方法设置条件值
			 * 	首先用add方法 表示设置条件值
			 * 	在add方法里面使用类
			 */
			criteria.add(Restrictions.eq("cid", 1));
			criteria.add(Restrictions.eq("custName", "xiaohe"));
			//3 调用方法得到的结果
			List<Customer> list = criteria.list();
			
			for(Customer customer : list) {
				System.out.println(customer.getCustName());
			}
			
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
	
	//模糊查询
	
	@Test
	public void Test_like() {
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
			
			//1 创建对象
			Criteria criteria = session.createCriteria(Customer.class);
			
			//2设置模糊值
			criteria.add(Restrictions.ilike("custName", "%h%"));
			
			//3调用方法得到的结果
			List<Customer> list = criteria.list();
			
			for(Customer customer : list) {
				System.out.println(customer.getCustName());
			}
			
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
	
	//排序查询
	@Test
	public void Test_order() {
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
			
			//1 创建对象
			Criteria criteria = session.createCriteria(Customer.class);
			
			//2.设置对那个属性进行排序 设置排序
			//升
			criteria.addOrder(Order.asc("cid"));
			//降
			criteria.addOrder(Order.desc("cid"));
			//3调用方法得到的结果
			List<Customer> list = criteria.list();
			
			for(Customer customer : list) {
				System.out.println(customer.getCustName());
			}
			
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
	
	//分页查询
	@Test
	public void Test_fy() {
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
			
			//1 创建对象
			Criteria criteria = session.createCriteria(Customer.class);
			
			//2 设置
			criteria.setFirstResult(0);
			criteria.setMaxResults(3);
			
			//3调用方法得到的结果
			List<Customer> list = criteria.list();
			
			for(Customer customer : list) {
				System.out.println(customer.getCustName());
			}
			
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

	//统计查询
	@Test
	public void Test_tj() {
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
			
			//1 创建对象
			Criteria criteria = session.createCriteria(Customer.class);
			
			//2. 设置操作
			criteria.setProjection(Projections.rowCount());
			
			//3.调用方法得到的结果
			List<Customer> list = criteria.list();
			
			for(Customer customer : list) {
				System.out.println(customer.getCustName());
			}
			
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

	//离线查询
	@Test
	public void Test_lx() {
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
			
			//1 创建对象
			//Criteria criteria = session.createCriteria(Customer.class);
			DetachedCriteria detachedCriteria =DetachedCriteria.forClass(Customer.class);
			
			
			//2最终执行时候才需要到session
			Criteria criteria = detachedCriteria.getExecutableCriteria(session);
			
			List<Customer> list = criteria.list();
			//3调用方法得到的结果
			//List<Customer> list = criteria.list();
			
			for(Customer customer : list) {
				System.out.println(customer.getCustName());
			}
			
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
