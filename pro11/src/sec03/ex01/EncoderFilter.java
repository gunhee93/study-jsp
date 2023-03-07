package sec03.ex01;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/*")
public class EncoderFilter implements Filter {
	ServletContext context;

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy 메서드 호출");
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("doFilter인코딩 필터 실행");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String context = ((HttpServletRequest)request).getContextPath();
		String pathInfo = ((HttpServletRequest)request).getRequestURI();
		String realPath = ((HttpServletRequest)request).getRealPath(pathInfo);
		
		String msg = "Context 정보 : " + context + "\nURI 정보 : " + pathInfo +
				"\n물리적 경로 : " + realPath;
		
		System.out.println(msg);
		
		long begin = System.currentTimeMillis();
		chain.doFilter(request, response);
		long end = System.currentTimeMillis();
		
		System.out.println("doFilter인코딩 필터 종료");
		System.out.println("작업 시간 : " + (end - begin) + "ms");
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("utf-8인코딩");
		context = fConfig.getServletContext();
	}

}
