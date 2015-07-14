package com.tw.espresso.configuration;

import com.tw.espresso.dao.DbConnector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@ComponentScan("com.tw.espresso")
public class CoreContext {

    @Bean
    @Profile("default")
    public DataSourceTransactionManager dataSourceTransactionManager(){
        return new DataSourceTransactionManager(graphDbConnector());
    }

    @Bean
    @Profile("test")
    public DataSourceTransactionManager localDataSourceTransactionManager(){
        return new DataSourceTransactionManager(localGraphDbConnector());
    }


    @Profile("default")
    @Bean
    public DbConnector graphDbConnector(){
        return new DbConnector("com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost:3306/user_management", "root", "root");
    }

    @Profile("test")
    @Bean
    public DbConnector localGraphDbConnector(){
        return new DbConnector("com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost:3306/user_management_test", "root", "root");
    }
}
