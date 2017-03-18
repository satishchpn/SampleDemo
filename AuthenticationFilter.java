package com.websystique.springmvc.configuration;

import java.io.IOException;
import java.util.Calendar;
import java.util.Enumeration;

import javax.annotation.PostConstruct;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.ids.jpms.ws.imagineapp.common.util.APPContext;
//import com.ids.jpms.ws.imagineapp.logger.AppLogger;
import com.ids.jpms.ws.imagineapp.session.SessionManagerContext;
import com.ids.jpms.ws.imagineapp.session.UserSessionContext;

@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {
	private static Logger log = Logger.getLogger(AuthenticationFilter.class);
	private ServletContext context;
	private boolean isAppContextInitaialized=false;
	public void init(FilterConfig fConfig) throws ServletException {
		log.info("Authentication filter initialized");
		this.context = fConfig.getServletContext();
		APPContext.getServerContextMap().put("ContextRealPath",context.getRealPath(""));
		APPContext.getServerContextMap().put("ContextPath",context.getContextPath());

		this.context.log("AuthenticationFilter initialized");
	}
	private void initializeAppContext(HttpServletRequest request,HttpServletResponse response){
		String imageUrl="http://"+request.getServerName()+":"+request.getServerPort()+"//"+this.context.getContextPath().replace("/", "")+"//images//";


		APPContext.getServerContextMap().put("ImageUrl", imageUrl);
		APPContext.getServerContextMap().put("ServerIP", request.getServerName());
		APPContext.getServerContextMap().put("ServerPort",request.getServerPort()+"");
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		UserSessionContext usc=null;
		if(!isAppContextInitaialized){
			initializeAppContext(req, res);
			isAppContextInitaialized=true;
		}
		if(!(req.getRequestURL().toString().contains("login")||req.getRequestURL().toString().contains("languages"))){
			String tokenId=req.getHeader("TokenId");
			String userName=req.getHeader("UserName");
			usc=SessionManagerContext.getUserSession(tokenId);
			if(usc==null){
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("/api/imagineapp/authenticationError");
				requestDispatcher.forward(req, res);
				return;
			}
			else if (!usc.getUserName().equals(userName)) {
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("/api/imagineapp/authenticationError");
				requestDispatcher.forward(req, res);
				return;
			}
			else{
				usc.incrementHitCount();
				usc.setLastAccessDateTime(Calendar.getInstance().getTime());
				usc.setIpAddress(req.getRemoteAddr());
				chain.doFilter(request, response);
				return;
			}
		}
		chain.doFilter(req, res);
	}

	public void printAllHeaders(HttpServletRequest request){
		Enumeration<String> er=request.getHeaderNames();
		while(er.hasMoreElements()){
			String str=er.nextElement();
			log.info(str+"  :"+request.getHeader(str));
		}
	}

	@PostConstruct
	public void initPostConstruct(){
	}
	public void destroy() {
		//close any resources here
	}
}