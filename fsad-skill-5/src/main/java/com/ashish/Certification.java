package com.ashish;

import org.springframework.stereotype.Component;

@Component
public class Certification
{

	private int Cid = 109;
    private String Cname = " FSAD - SPRING AUTOWIRING";
    private String CdateOfCompletion = " 19-FEB-2026";

    @Override
    public String toString() 
    {
        return "Certification Details [id=" + Cid +
               ", name=" + Cname +
               ", dateOfCompletion=" + CdateOfCompletion + "]";
        
    }
    
}
