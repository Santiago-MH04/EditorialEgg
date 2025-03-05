package com.egg.biblioteca.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PortalControlador {
    //Atributos de PortalControlador
    //Constructores de PortalControlador
    //Asignadores de atributos de PortalControlador (setters)
    //Lectores de atributos de PortalControlador (getters)
        //Métodos de PortalControlador
    @GetMapping
    public String inicio(){
        return "index.html";
    }
}
