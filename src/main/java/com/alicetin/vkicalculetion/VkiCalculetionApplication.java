package com.alicetin.vkicalculetion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// Auditing Aktif etmek

@SpringBootApplication
// Bir spring boot projesi olduğunu bildirir.
public class VkiCalculetionApplication {
// Burda spring projesini çalıştırır.

    public static void main(String[] args) {

        SpringApplication.run(VkiCalculetionApplication.class, args);
    }

}
