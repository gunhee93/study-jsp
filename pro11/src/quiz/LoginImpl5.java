package quiz;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class LoginImpl5 implements ServletContextAttributeListener {
	static int total_user;
    public LoginImpl5() {
        // TODO Auto-generated constructor stub
    }
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    	System.out.println("접속자 생성");
    	total_user++;
    }
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    	System.out.println("접속자 해제");
    	total_user--;
    }

	
}