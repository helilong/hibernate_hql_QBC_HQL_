package com.xiaohe.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.xiaohe.entity.Customer;
import com.xiaohe.utils.HibernateUtils;

public class Test_jiansuo {

	//检索策略的概念
	//1 立即查询，根据id查询 调用get方法 一调用
	//2
	@Test
	public void Test_js() {
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
			
			//1 cid = 1 客户
			//根据get方法之后 是否发送sql语句
			Customer custormer = session.get(Customer.class, 1);
			System.out.println(custormer.getCid());
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
