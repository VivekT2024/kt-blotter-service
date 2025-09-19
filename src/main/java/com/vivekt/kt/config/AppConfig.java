package com.vivekt.kt.config;

import com.vivekt.kt.serice.DataProvider;
import com.vivekt.kt.serice.impl.DataProviderHardCodedImpl;
import com.vivekt.kt.serice.impl.DataProviderServiceBadImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Bean
    @Profile("hard")
    public DataProvider dataProviderHard(){

        return new DataProviderHardCodedImpl();
    }

    @Bean
    @Profile("bad")
    public DataProvider dataProviderBad(){
        return new DataProviderServiceBadImpl();

    }
}
