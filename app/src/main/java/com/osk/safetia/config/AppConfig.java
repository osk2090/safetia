package com.osk.safetia.config;

import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
@ComponentScan("com.osk.safetia")
@EnableWebMvc
@PropertySource("classpath:com/osk/safetia/config/jdbc.properties")
@EnableTransactionManagement
@MapperScan("com.osk.safetia.dao")
public class AppConfig {

    @Bean
    public DataSource dataSource(
            @Value("${jdbc.driver}") String jdbcDriver,
            @Value("${jdbc.url}") String jdbcUrl,
            @Value("${jdbc.username}") String jdbcUsername,
            @Value("${jdbc.password}") String jdbcPassword) {


        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(jdbcDriver);
        ds.setUrl(jdbcUrl);
        ds.setUsername(jdbcUsername);
        ds.setPassword(jdbcPassword);
        return ds;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(
            DataSource dataSource, // DB 커넥션풀
            ApplicationContext appCtx // Spring IoC 컨테이너
    ) throws Exception {
        LogFactory.useLog4J2Logging();

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        sqlSessionFactoryBean.setTypeAliasesPackage("com.osk.safetia.domain");
        sqlSessionFactoryBean.setMapperLocations(
                appCtx.getResources("classpath:com/osk/safetia/mapper/*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }

}







