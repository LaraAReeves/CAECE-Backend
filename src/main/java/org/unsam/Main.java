package org.unsam;

import org.unsam.menu.MenuPrueba;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        MenuPrueba menu = context.getBean(MenuPrueba.class);
        try {
            menu.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}