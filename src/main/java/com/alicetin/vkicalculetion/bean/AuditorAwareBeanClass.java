package com.alicetin.vkicalculetion.bean;


import com.alicetin.vkicalculetion.audit.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

// LOMBOK


// @Configuration: Classın Bean nesnesi olması için kullanıyoruz.
@Configuration
// Auditing Aktif etmek
//@EnableJpaAuditing(auditorAwareRef = "auditorAwareBeanMethod")
public class AuditorAwareBeanClass {

    //FIRST
    public void auditorAwareBeforeBeanMethod(){
        System.out.println("auditor Aware bean Before başladı");
    }

    // Auditor Aware Bean
    @Bean
    public AuditorAware<String> auditorAwareBeanMethod(){
        return new AuditorAwareImpl();
    }


    //LAST
    public void auditorAwareAfterBeanMethod(){
        System.out.println("auditor Aware After bean bitti");
    }
}
