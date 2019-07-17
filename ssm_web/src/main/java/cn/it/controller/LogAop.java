package cn.it.controller;


import cn.it.domain.SysLog;
import cn.it.service.ISysService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

@Component
@Aspect
public class LogAop {

    @Autowired
    private ISysService ss;

    @Autowired
    private HttpServletRequest request;

    private Date visitTime;
    private Class clz;
    private Method method;

    @Before("execution(* cn.it.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime=new Date();
        clz=jp.getTarget().getClass();

        String name = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        Class[] classes = new Class[args.length];
        if (args.length>0){
            for (int i = 0; i < args.length; i++) {
                classes[i]=args[i].getClass();
            }
        }
        method = clz.getMethod(name, classes);

    }

    @After("execution(* cn.it.controller.*.*(..))")
    public void doAfter(JoinPoint jp){
        long executionTime=new Date().getTime()-visitTime.getTime();
        String url="";
        if (clz!=null&&method!=null&&clz!=LogAop.class){
            RequestMapping clzAnnotation = (RequestMapping) clz.getAnnotation(RequestMapping.class);
            if (clzAnnotation!=null){
                String[] clzValue = clzAnnotation.value();
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                String[] metValue = methodAnnotation.value();
                url=clzValue[0]+metValue[0];

                String ip = request.getRemoteAddr();
                request.getSession().getServletContext().getAttribute("");
                User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

                SysLog sysLog = new SysLog();
                sysLog.setExecutionTime(executionTime);
                sysLog.setId(UUID.randomUUID().toString().replace("-",""));
                sysLog.setIp(ip);
                sysLog.setMethod("类名："+clz.getName()+"方法名："+method.getName());
                sysLog.setUsername(user.getUsername());
                sysLog.setVisitTime(visitTime);
                sysLog.setUrl(url);
                ss.saveSysLog(sysLog);
            }
        }
    }
}
