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
	
	//��ʾ���󵼺���ѯ
	@Test
	public void Test_Select() {
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
			
			//����cid Ϊ  1 �ͻ�  �ڲ�ѯ����ͻ��ж�����ϵ�� 
			Customer cusromer = session.get(Customer.class,1);
			Set<LinkMan> linkman = cusromer.getSetLinkMan();
			
			System.out.println(linkman.size());
			
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
