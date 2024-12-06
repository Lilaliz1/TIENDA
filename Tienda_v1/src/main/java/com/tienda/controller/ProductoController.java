/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Lizeth
 */
package com.tienda.controller;

import com.tienda.domain.Producto;
import com.tienda.service.CategoriaService;
import com.tienda.service.ProductoService;
import com.tienda.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


  

    @Controller
    @Slf4j //es un lonbook permite que cuando estemos registrando info permite darle seguimiento a los errores que se pueden dar
    @RequestMapping("/producto")//conesto lo llamo en la web en el local host
    public class ProductoController {

        @Autowired
        private ProductoService productoService;

        @Autowired
        private CategoriaService categoriaService;

        @GetMapping("/listado")//lista de las productos
        public String inicio(Model model) {//se ejcuta cuando se llame a listado
            var productos = productoService.getProductos(false);
            var categorias = categoriaService.getCategorias(false);

            model.addAttribute("productos", productos);
             model.addAttribute("categorias", categorias);
            model.addAttribute("totalProductos", productos.size());
            return "/producto/listado";//el url 
        }

        @GetMapping("/nuevo")
        public String productoNuevo(Producto producto) {
            return "/producto/modifica";
        }

        @Autowired
        private FirebaseStorageServiceImpl firebaseStorageService;

        @PostMapping("/guardar")
        public String productoGuardar(Producto producto,
                @RequestParam("imagenFile") MultipartFile imagenFile) {
            if (!imagenFile.isEmpty()) {
                productoService.save(producto);
                producto.setRutaImagen(
                        firebaseStorageService.cargaImagen(
                                imagenFile,
                                "producto",
                                producto.getIdProducto()));
            }
            productoService.save(producto);
            return "redirect:/producto/listado";
        }

        @GetMapping("/eliminar/{idProducto}")
        public String productoEliminar(Producto producto) {
            productoService.delete(producto);
            return "redirect:/producto/listado";
        }

        @GetMapping("/modificar/{idProducto}")
        public String productoModificar(Producto producto, Model model) {
             producto = productoService.getProducto(producto);
            var categorias = categoriaService.getCategorias(false);

            model.addAttribute("producto", producto);
             model.addAttribute("categorias", categorias);
            return "/producto/modifica";
        }
    }

