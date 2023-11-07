package com.alicetin.vkicalculetion.business.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Getter
//Getter oluşturuyoruz
@Setter
//Setter oluşturuyoruz.
 abstract public class BaseDto implements Serializable{

        // Serileştirme yapılıyor.
        public static final Long serialVersionUID=1L;

        // ID
        protected  Long id;

        // DATE
        @Builder.Default // Lombok Default
        protected Date systemDate=new Date(System.currentTimeMillis());
}
