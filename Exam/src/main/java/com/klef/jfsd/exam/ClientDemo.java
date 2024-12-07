package com.klef.jfsd.exam;

import java.util.Scanner;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		updateDepartment();
	}
	
	public static void updateDepartment() {
	    Configuration cfg=new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    
	    SessionFactory sf=cfg.buildSessionFactory();
	    Session session=sf.openSession();
	    
	    Transaction t=(Transaction) session.beginTransaction();
	    Department d = new Department();
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter faculty ID");
	    int did= sc.nextInt();
	    Department dep= session.find(Department.class, did);
	    
	    if(dep!=null) {
	      System.out.println("Enter Department name");
	      String dname=sc.next();
	      System.out.println("Enter Department location");
	      String dlocation=sc.next();
	      
	      dep.setName(dname);
	      dep.setLocation(dname);
	      
	      t.commit();
	      System.out.println("Department Updated Successfully");
	    }
	  }

}
