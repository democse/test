package com.pravin;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
	
		
			ApplicationContext container = new FileSystemXmlApplicationContext("C:\\Users\\pravi\\eclipse-workspace\\Spring Boot mvc\\Spring_Core\\Spring.xml");
			
			/*College clg = (College) container.getBean("college");
			System.out.println(clg.Code);
			System.out.println(clg.CollegeName);
			//System.out.println(clg.getStudent1());
			System.out.println(clg.getStudent1().Studentid);
			System.out.println(clg.getStudent1().StudentName);*/
			
			Student std = (Student) container.getBean("student");
			System.out.println(std.Studentid);
			System.out.println(std.StudentName);
			
	}

}
