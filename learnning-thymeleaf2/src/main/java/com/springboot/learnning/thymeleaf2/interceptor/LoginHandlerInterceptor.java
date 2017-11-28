package com.springboot.learnning.thymeleaf2.interceptor;

import com.springboot.learnning.thymeleaf2.domain.User;
import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自己定义拦截器 HandlerIntercptor 方法
 * 1、自己定义一个实现HandlerInterceptor的拦截器：LoginHandlerInterceptor
 * 2、自己定义一个继承WebMvcConfigurerAdapter的配置类：MyWebConfigAdapter，重写：addInterceptors 方法，方法中添加拦截路径和不拦截路径
 *   //addPathPatterns  添加拦截路径
 *   //excludePathPatterns  排除拦截路径
 *   //addPathPatterns("/**")对所有请求都拦截，但是排除了/toLogin和/login请求的拦截。
 *   registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/toLogin","/login");
 *
 *最后强调一点：只有经过DispatcherServlet 的请求，才会走拦截器链，
 * 我们自定义的Servlet 请求是不会被拦截的，
 * 比如我们自定义的Servlet地址 http://localhost:8080/xs/myservlet 是不会被拦截器拦截的
 * Created by CloudPure on 2017/11/28.
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
private static final Logger logger= Logger.getLogger("LoginHandlerInterceptor.class");
    /**
     *
     * @param request
     * @param response
     * @param handler
     * @return  返回true的时候，继续往下执行，返回false 停止执行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("***************preHandle 在请求处理之前进行调用（Controller方法调用之前*************");
        boolean bFlag=false;
        String ip = request.getRemoteAddr();
        long startTime = System.currentTimeMillis();
        request.setAttribute("requestStartTime", startTime);
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        logger.info("**********用户:"+ip+",访问目标:"+method.getDeclaringClass().getName() + "." + method.getName()+"***********");

        User user=(User) request.getSession().getAttribute("user");
        if(user==null){
            bFlag = false;
            response.sendRedirect("toLogin");
        }else{
            bFlag = true;
        }
        logger.info("*******拦截器中用户信息："+(user==null?"":user.toString())+";时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"******");
        return bFlag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("******>>>postHandle>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）******");

        HandlerMethod handlerMethod= (HandlerMethod) handler;
        Method method=handlerMethod.getMethod();
        long startTime= (long) request.getAttribute("requestStartTime");
        long endTime=System.currentTimeMillis();
        long executeTime = endTime - startTime;
        // 打印方法执行时间
        if (executeTime > 1000) {
            logger.info("********[" + method.getDeclaringClass().getName() + "." + method.getName() + "] 执行耗时 : "
                    + executeTime + "ms***********");
        } else {
           logger.info("*******[" + method.getDeclaringClass().getSimpleName() + "." + method.getName() + "] 执行耗时 : "
                    + executeTime + "ms*******");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("*********>>>afterCompletion>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）********");
    }
}
