package com.szxy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 字符编码过滤,处理乱码问题
 */
@WebFilter(urlPatterns="/*",initParams={
							@WebInitParam(name = "encoding", value = "utf-8"),
							@WebInitParam(name = "contentType", value = "text/html;charset=utf-8")})
public class EncodingFilter implements Filter{

	private String encoding;
	
	private String contentType;
	
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		
		//处理post请求乱码
		req.setCharacterEncoding(encoding);
		
		//设置文档类型
		resp.setContentType(contentType);
		
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
		contentType = config.getInitParameter("contentType");
	}

}
