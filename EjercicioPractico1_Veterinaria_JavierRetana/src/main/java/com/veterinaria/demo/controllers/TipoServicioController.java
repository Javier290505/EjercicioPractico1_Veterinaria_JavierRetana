/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.veterinaria.demo.controllers;

import com.veterinaria.demo.domain.TipoServicio;
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
@RequestMapping("/tipos")
public class TipoServicioController {

    @Autowired
    private TipoServicioService tipoServicioService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("tipos", tipoServicioService.obtenerTipos());
        return "tipos/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("tipoServicio", new TipoServicio());
        return "tipos/formulario";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam Integer id, Model model) {
        TipoServicio tipoServicio = tipoServicioService.buscarTipo(id);
        model.addAttribute("tipoServicio", tipoServicio);
        return "tipos/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(TipoServicio tipoServicio,
            RedirectAttributes redirectAttributes) {

        tipoServicioService.guardarTipo(tipoServicio);

        redirectAttributes.addFlashAttribute(
                "mensaje",
                "Tipo de servicio guardado correctamente"
        );

        return "redirect:/tipos";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer id,
            RedirectAttributes redirectAttributes) {

        tipoServicioService.eliminarTipo(id);

        redirectAttributes.addFlashAttribute(
                "mensaje",
                "Tipo de servicio eliminado correctamente"
        );

        return "redirect:/tipos";
    }
}