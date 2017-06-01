package com.santiblanc.app;


import com.santiblanc.app.converter.AutoConverter;
import com.santiblanc.app.converter.MarcaConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    @Bean(name = "autoConverter")
    public AutoConverter getAutoConverter(){
        return new AutoConverter();
    }

    @Bean(name = "marcaConverter")
    public MarcaConverter getMarcaConverter(){
        return new MarcaConverter();
    }
}
