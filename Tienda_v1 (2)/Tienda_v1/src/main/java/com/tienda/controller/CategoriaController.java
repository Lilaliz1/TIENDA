/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lizeth
 */

   package com.tienda.controller;

import com.tienda.service.CategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class CategoriaController {
 


//@Controller
//@Slf4j //es un lonbook permite que cuando estemos registrando info permite darle seguimiento a los errores que se pueden dar
//@RequestMapping("/categoria")//conesto lo llamo en la web en el local host

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")//lista de las categorias
    public String inicio(Model model) {//se ejcuta cuando se llame a listado
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCategorias", categorias.size());
        return "/categoria/listado";//el url 
    }
}

