/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba1.controller;
import com.prueba1.domain.Condominio;
//import com.prueba1.service.implement.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.prueba1.service.CondominioService;
@Controller
@Slf4j
@RequestMapping("/condominio") // Ruta del controlador



/**
 *
 * @author Lizeth
 */
public class CondominioController {
      @Autowired
    private CondominioService condominioService;

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var condominios = condominioService.getCondominios(false);
        model.addAttribute("condominio", condominios);
        model.addAttribute("totalCondominios", condominios.size());
        return "/condominio/listado";
    }

    @GetMapping("/nuevo")
    public String condominioNuevo(Condominio condominio) {
        return "/condominio/modificar";
    }

    @PostMapping("/guardar")
    public String condominioGuardar(Arbol condominio, @RequestParam("imagenFile") MultipartFile imagenFile) {
       
        condominioService.save(condominio);
        if (!imagenFile.isEmpty()) {
            // Una vez guardado y con el ID, proceder a cargar la imagen
            String rutaImagen = firebaseStorageService.cargaImagen(imagenFile, "condominio", condominio.getIdCondominio());
            condominio.setRutaImagen(rutaImagen);
            // Guardar nuevamente con la ruta de la imagen
            condominioService.save(condominio);
        }
        return "redirect:/condominio/listado";
    }

    @GetMapping("/eliminar/{idCondominio}")
    public String categoriaEliminar(@PathVariable Long idCondominio) {
        Arbol condominio = new Arbol();
        condominio.setIdCondominio(idCondominio);
        condominioService.delete(condominio);
        return "redirect:/condominio/listado";
    }

   
    }
}
