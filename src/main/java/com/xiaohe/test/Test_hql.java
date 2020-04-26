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

	
	
	//hql查询
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
			Query query = session.createQuery("from Customer");
			//2.调用方法得到结果
			List<Customer> list = query.list();
			
			for(Customer customer : list) {
				System.out.println(customer.getCid()+":"+customer.getCustName());
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

	//判断和模糊查询
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
			
			//条件判断
			String p = "from Customer  c where c.cid=? and c.custName=?";
			//模糊查询
			String like = "from Customer  c where c.custName like ?";
			
			
			//1 创建query对象
			Query query = session.createQuery(like);
			
			//2.设置条件值      向？里面设置值
			//setParameter 方法两个参数
			//第一个参数：int类型是？位置，？位置从0开始
			//第二个参数：具体参数值
			
			//query.setParameter(0,1);
			//query.setParameter(1,"xiaohe");
			
			query.setParameter(0, "%h%");
			//3 调用方法得到结果
			List<Customer> list = query.list();
			
			
			for(Customer customer : list) {
				System.out.println(customer.getCid()+":"+customer.getCustName());
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
			
			//条件判断
			String p = "from Customer  c where c.cid=? and c.custName=?";
			//模糊查询
			String like = "from Customer  c where c.custName like ?";
			//排序查询(升序)
			String order = "for Customer order by cid asc";
			//排序查询(降序)
			String order1 = "for Customer order by cid desc";
			//1 创建query对象
			Query query = session.createQuery(order);
			
			//2.设置条件值      向？里面设置值
			//setParameter 方法两个参数
			//第一个参数：int类型是？位置，？位置从0开始
			//第二个参数：具体参数值
			
			//query.setParameter(0,1);
			//query.setParameter(1,"xiaohe");
			
			//query.setParameter(0, "%h%");
			//3 调用方法得到结果
			List<Customer> list = query.list();
			
			
			for(Customer customer : list) {
				System.out.println(customer.getCid()+":"+customer.getCustName());
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
	public void Test_limit() {
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
			
			//条件判断
			String p = "from Customer  c where c.cid=? and c.custName=?";
			//模糊查询
			String like = "from Customer  c where c.custName like ?";
			//排序查询(升序)
			String order = "for Customer order by cid asc";
			//排序查询(降序)
			String order1 = "for Customer order by cid desc";
			//分页 不能写limit 有封装对象
			//1 创建query对象(查全部))
			Query query = session.createQuery("form Customer");
			
			//2 设置分页数据
			//2.1设置开始位置
			query.setFirstResult(0);
			//2.2设置每页记录数
			query.setMaxResults(3);
			
			//3 调用方法得到结果
			List<Customer> list = query.list();
			
			
			for(Customer customer : list) {
				System.out.println(customer.getCid()+":"+customer.getCustName());
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
	 	
	//投影查询
	@Test
	public void Test_ty() {
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
			//1 创建query对象(查全部))
			Query query = session.createQuery("select custName from Customer");
			//2 调用方法得到结果
			List<Object> list = query.list();
			
			
			for(Object object : list) {
				System.out.println(object);
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

	//集合函数
	@Test
	public void Test_f() {
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
			//1 创建query对象(查全部))
			Query query = session.createQuery("select count(*) from Customer");
			//2 调用方法得到结果
			Object object= query.uniqueResult();
			
				System.out.println(object);
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
