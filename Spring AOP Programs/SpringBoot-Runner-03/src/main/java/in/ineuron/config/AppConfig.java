package in.ineuron.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.ineuron.methodref.SampleTest;

import org.springframework.boot.CommandLineRunner;
import java.util.Arrays;


@Configuration
public class AppConfig {

    @Bean
    public CommandLineRunner runA() {
    	//syntax=> className:methodName
        return SampleTest::test;
    }
}
