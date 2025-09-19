package com.vivekt.kt.config;

import com.vivekt.kt.serice.DataProvider;
import com.vivekt.kt.serice.impl.DataProviderHardCodedImpl;
import com.vivekt.kt.serice.impl.DataProviderServiceBadImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DataProvider dataProvider(){
        //return new DataProviderServiceBadImpl();
        return new DataProviderHardCodedImpl();
    }
}
