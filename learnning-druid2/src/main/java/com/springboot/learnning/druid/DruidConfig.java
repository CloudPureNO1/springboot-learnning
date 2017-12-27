package com.springboot.learnning.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by CloudPure on 2017/12/27.
 */
@Configuration
public class DruidConfig {
    private static final Logger logger= Logger.getLogger(DruidConfig.class);


    //druid 账号和密码
    @Value("${com.druid.loginUsername}")
    private String loginUsername;
    @Value("${com.druid.loginPassword}")
    private String loginPassword;

    //druid Servlet 参数
    @Value("${com.druid.allow}")
    private String allow;
    @Value("${com.druid.deny}")
    private String deny;
    @Value("${com.druid.resetEnable}")
    private String resetEnable;

    //druid Filter 参数
    @Value("${com.druid.exclusions}")
    private String exclusions;
    @Value("${com.druid.profileEnable}")
    private String profileEnable;

    //durid dataSource
    // 数据源参数

    @Value("${spring.datasource.driver-classname}")
    private String driverClassname;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    //数据源其他参数
    @Value("${spring.datasource.filters}")
    private String filters;
    @Value("${spring.datasource.initialSize}")
    private int initialSize;
    @Value("${spring.datasource.maxActive}")
    private int maxActive;
    @Value("${spring.datasource.minIdle}")
    private int minIdle;
    @Value("${spring.datasource.maxWait}")
    private int maxWait;
    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int  minEvictableIdleTimeMillis;
    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;
    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;



    @Bean(name="druidServlet")
    public ServletRegistrationBean setServet(){
        //利用ServletRegistrationBean设置servlet
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean();
        //利用set函数设置servlet，StatViewServlet,是alibaba  druid 的状态servlet，也可以是自己定义的Servlet
        //也可以利用构造函数配置servlet
       // ServletRegistrationBean rg=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");

        //设置Servlet的初始参数
        //设置druid 账号和密码
        servletRegistrationBean.addInitParameter("loginUsername",loginUsername);
        servletRegistrationBean.addInitParameter("loginPassword",loginPassword);
        //设置白名单
        servletRegistrationBean.addInitParameter("allow",allow);
        //设置黑名单，如果在黑名单内，访问时，会提示；Sorry, you are not permitted to view this page.
        servletRegistrationBean.addInitParameter("deny",deny);
        //设置 能否重置数据
        servletRegistrationBean.addInitParameter("resetEnable",resetEnable);
        return servletRegistrationBean;
    }


    @Bean(name="druidFilter")
    public FilterRegistrationBean setFilter(){
        FilterRegistrationBean filterRegistrationBean =new FilterRegistrationBean();
        //通过 FilterRegistratrionBean  设置alibaba  druid filter  WebStatFilter
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");

        //设置参数
        //设置例外
        filterRegistrationBean.addInitParameter("exclustions",exclusions);
        //设置是否开启查询单个url的sql
        filterRegistrationBean.addInitParameter("profileEnable",profileEnable);
        return filterRegistrationBean;
    }

    @Bean(value="druidDataSource")
    public DataSource setDruidDataSource(){
       DruidDataSource dataSource=null;
        try {
            dataSource=new DruidDataSource();
            dataSource.setDriverClassName(driverClassname);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);

            dataSource.setFilters(filters);
            dataSource.setInitialSize(initialSize);
            dataSource.setMaxActive(maxActive);
            dataSource.setMinIdle(minIdle);
            dataSource.setMaxWait(maxWait);
            dataSource.setTimeBetweenConnectErrorMillis(timeBetweenEvictionRunsMillis);
            dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
            dataSource.setValidationQuery(validationQuery);
            dataSource.setTestWhileIdle(testWhileIdle);
            dataSource.setTestOnBorrow(testOnBorrow);
            dataSource.setTestOnReturn(testOnReturn);
        } catch (SQLException e) {
            logger.error("druid dataSource initialize failed"+e.getMessage(),e);
        }
        return dataSource;
    }
}
