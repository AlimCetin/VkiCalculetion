package com.alicetin.vkicalculetion.bean;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// @Configuration: Classın Bean nesnesi olması için kullanıyoruz.
@Configuration
public class ModelMapperBeanClass {

    //FIRST
    public void modelMapperBeforeBeanMethod(){
        System.out.println("Model mapper bean Before başladı");
    }

    // Model Mapper
    @Bean
    public ModelMapper modelMapperMethod(){
        return new ModelMapper();
    }


    //LAST
    public void modelMapperAfterBeanMethod(){
        System.out.println("Model mapper After bean bitti");
    }
}
