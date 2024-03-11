package es.sanchezcandon.gestionhotelSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"gestionhotel", "es.sanchezcandon.gestionhotelSpring"})
public class EjemploapirestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EjemploapirestApplication.class, args);
    }
}

