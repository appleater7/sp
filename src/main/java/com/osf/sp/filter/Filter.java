package com.osf.sp.filter;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.osf.sp.auth.MakeJWT;
import com.osf.sp.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Filter extends GenericFilterBean{
	
	@Resource
	private MakeJWT jwt;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		if (!req.getRequestURI().equals("/login")) {
			String uiId = req.getParameter("uiId");
			String tokken = req.getParameter("tokken");
			try {
				UserInfoVO ui = new UserInfoVO();
				ui.setUiId(uiId);
				jwt.checkJWT(tokken, ui);
			} catch(Exception e) {
				throw new ServletException("토큰키가 올바르지 않아!!");
			}
		}
		chain.doFilter(request, response);
	}	
}
