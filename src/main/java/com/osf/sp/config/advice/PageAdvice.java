package com.osf.sp.config.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.osf.sp.vo.PageVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class PageAdvice {
	
	@Around("execution(* com.osf.sp.controller.*.*(..))")
	public Object pageJoin(ProceedingJoinPoint pjp) throws Throwable{
		Object[] args = pjp.getArgs();
		for(Object arg:args) {
			if(arg instanceof PageVO) {
				PageVO page = (PageVO)arg;
				if(page.getPageNum()==null) {
					page.setPageNum(1);
				}
				if(page.getPageSize()==null) {
					page.setPageSize(20);
				}
				log.info("page=>{}",page);
			}			
		}
		log.info("pjp=>{}",pjp);
		return pjp.proceed();
	}
}
