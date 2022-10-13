package com.example.ordenadores;

import com.example.ordenadores.entity.Ordenador;
import com.example.ordenadores.repository.OrdenadorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrdenadoresApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(OrdenadoresApplication.class, args);
        context.getBean(OrdenadoresApplication.class);

        OrdenadorRepository repository = context.getBean(OrdenadorRepository.class);

        Ordenador ordenador1 = new Ordenador(null, "Dell", "Precision M4800", "negro", 1950.99, 2);
        Ordenador ordenador2 = new Ordenador(null, "Apple", "MacBook Air", "blanco", 6199.99, 12);
        Ordenador ordenador3 = new Ordenador(null, "Hp", "Pavilion Plus 14-eh0106la", "blanco", 3799.99, 3);

        repository.save(ordenador1);
        repository.save(ordenador2);
        repository.save(ordenador3);
    }

}
