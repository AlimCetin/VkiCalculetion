package com.alicetin.vkicalculetion.bean;

import com.alicetin.vkicalculetion.business.services.IVkiServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// LOMBOK
@RequiredArgsConstructor

@Configuration
@Log4j2
public class BlogCommandLineRunner {

    // INJECTION
    // 1.YOL
    // private final IRegisterServices iRegisterServices;

    // FIRST
    public void blogCommandLineRunnerAfterBeanMethod(){
        log.info("blog CommandLineRunner After Bean Method başladı");
        System.out.println("blog CommandLineRunner After Bean Method başladı");
    }

    // Injection
    @Bean
    public CommandLineRunner blogCommandLineRunnerMethod(IVkiServices iVkiServices) { //
        // Lambda Expression
        return args -> {
            System.out.println("CommandLineRunner Çalıştı");
            log.info("CommandLineRunner Çalıştı");
            iVkiServices.vkiServiceSpeedData(5L);
        };
    }

    //LAST
    public void blogCommandLineRunnerBeforeBeanMethod(){
        log.info("blog CommandLineRunner Before Bean Method bitti");
        System.out.println("blog Command Line Runner Befdre Bean Method bitti");
    }

} //end class
