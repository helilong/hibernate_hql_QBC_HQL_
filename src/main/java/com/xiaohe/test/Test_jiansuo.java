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

	//�������Եĸ���
	//1 ������ѯ������id��ѯ ����get���� һ����
	//2
	@Test
	public void Test_js() {
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
			
			//1 cid = 1 �ͻ�
			//����get����֮�� �Ƿ���sql���
			Customer custormer = session.get(Customer.class, 1);
			System.out.println(custormer.getCid());
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
