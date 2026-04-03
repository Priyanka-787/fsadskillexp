package com.ashish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student 
{
	    private int Sid = 101;
	    private String Sname = "Ashish";
	    private String Sgender = "Male";

	    @Autowired
	    private Certification certification;
	    
	    public void display() 
	    {
	        System.out.println("Student ID     : " + Sid);
	        System.out.println("Student Name   : " + Sname);
	        System.out.println("Gender         : " + Sgender);
	        System.out.println("Certification  : " + certification);

	    }

}
