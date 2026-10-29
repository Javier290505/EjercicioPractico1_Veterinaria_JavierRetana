/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.veterinaria.demo.service;

import com.veterinaria.demo.domain.Servicio;
import com.veterinaria.demo.repository.ServicioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public List<Servicio> obtenerServicios() {
        return servicioRepository.findAll();
    }

    @Override
    public Servicio buscarServicio(Integer id) {
        return servicioRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarServicio(Servicio servicio) {
        servicioRepository.save(servicio);
    }

    @Override
    public void eliminarServicio(Integer id) {
        servicioRepository.deleteById(id);
    }
}
