package com.xiaohe.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.xiaohe.entity.Customer;
import com.xiaohe.entity.LinkMan;
import com.xiaohe.utils.HibernateUtils;

public class Test_Object {
	
	//演示对象导航查询
	@Test
	public void Test_Select() {
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
			
			//根据cid 为  1 客户  在查询这个客户有多少联系人 
			Customer cusromer = session.get(Customer.class,1);
			Set<LinkMan> linkman = cusromer.getSetLinkMan();
			
			System.out.println(linkman.size());
			
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
