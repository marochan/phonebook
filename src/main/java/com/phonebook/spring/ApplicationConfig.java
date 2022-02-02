package com.phonebook.spring;

import com.phonebook.main.InMemoryRepository;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import java.util.*;

@Configuration
@ComponentScan(value = {"com.phonebook.spring", "com.phonebook.model"})
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    /**
     * Property placeholder configurer is needed to interpolate property values
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Map<String, Set<String>> defaultData() {
        Map<String, Set<String>> data = new LinkedHashMap<>();
        data.put("Alex", new HashSet<>(Arrays.asList("+79601232233")));
        data.put("Billy", new HashSet<>(Arrays.asList("+79213215566", "+79213215567", "+79213215568")));
        data.put("William", new HashSet<>(Arrays.asList("+77985543210")));
        return data;
    }

    @Bean(name = "repository")
    public InMemoryRepository inMemoryRepository(Map<String, Set<String>> defaultData) {
        return new InMemoryRepositoryIml(defaultData);
    }

}
