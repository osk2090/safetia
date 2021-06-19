package com.osk.safetia.config;

import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@ComponentScan("com.osk.safetia")
@EnableWebMvc
@PropertySource("classpath:com/osk/safetia/config/jdbc.properties")
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

        // Log4J2 기능 활성화시키기
        // => 로그 출력 형식은 .properties 파일이나 .xml 파일로 설정한다.
        LogFactory.useLog4J2Logging();

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        // mybatis 설정 파일을 XML 파일로 따로 두지 말고,
        // 다음과 같이 자바 코드로 설정하면 편하다.
        //
        sqlSessionFactoryBean.setTypeAliasesPackage("com.osk.safetia.domain");
        sqlSessionFactoryBean.setMapperLocations(
                appCtx.getResources("classpath:com/osk/safetia/mapper/*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }
}
