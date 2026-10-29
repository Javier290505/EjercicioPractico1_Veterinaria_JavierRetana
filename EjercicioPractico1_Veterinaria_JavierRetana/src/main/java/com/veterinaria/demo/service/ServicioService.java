/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.veterinaria.service;

import com.veterinaria.domain.Servicio;
import java.util.List;

public interface ServicioService {

    public List<Servicio> obtenerServicios();

    public Servicio buscarServicio(Integer id);

    public void guardarServicio(Servicio servicio);

    public void eliminarServicio(Integer id);
}
