/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.veterinaria.demo.controllers;

import com.veterinaria.demo.domain.Servicio;
import com.veterinaria.demo.service.ServicioService;
import com.veterinaria.demo.service.TipoServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private TipoServicioService tipoServicioService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("servicios", servicioService.obtenerServicios());
        return "servicios/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("servicio", new Servicio());
        model.addAttribute("tipos", tipoServicioService.obtenerTipos());
        return "servicios/formulario";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam Integer id, Model model) {

        Servicio servicio = servicioService.buscarServicio(id);

        model.addAttribute("servicio", servicio);
        model.addAttribute("tipos", tipoServicioService.obtenerTipos());

        return "servicios/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(Servicio servicio,
            RedirectAttributes redirectAttributes) {

        servicioService.guardarServicio(servicio);

        redirectAttributes.addFlashAttribute(
                "mensaje",
                "Servicio guardado correctamente"
        );

        return "redirect:/servicios";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer id,
            RedirectAttributes redirectAttributes) {

        servicioService.eliminarServicio(id);

        redirectAttributes.addFlashAttribute(
                "mensaje",
                "Servicio eliminado correctamente"
        );

        return "redirect:/servicios";
    }
}