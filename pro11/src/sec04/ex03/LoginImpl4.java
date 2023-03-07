package sec04.ex03;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class LoginImpl4 implements HttpSessionListener {
	String user_id;
	String user_pw;
	static int total_user = 0;
	
    public LoginImpl4() {
        // TODO Auto-generated constructor stub
    }
    
    public LoginImpl4(String user_id, String user_pw) {
    	this.user_id = user_id;
    	this.user_pw = user_pw;
    }
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("세션 생성");
    	++total_user;
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("세션 소멸");
    	--total_user;
    }
	
}
