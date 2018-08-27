package br.com.lista;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
public class Config {
    public static void main(String[] args) {
        SpringApplication.run(Config.class, args);
    }

    /*
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSouce = new DriverManagerDataSource();
        dataSouce.setDriverClassName("com.mysql.jdbc.Driver");
        dataSouce.setUrl("jdbc:mysql://localhost:3306/lista");
        dataSouce.setUsername("root");
        dataSouce.setPassword("root");
        return dataSouce;
    }
    */
}
