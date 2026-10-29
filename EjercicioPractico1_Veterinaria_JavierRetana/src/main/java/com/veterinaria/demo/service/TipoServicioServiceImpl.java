/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.veterinaria.demo.service;

import com.veterinaria.demo.domain.TipoServicio;
import com.veterinaria.demo.repository.TipoServicioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoServicioServiceImpl implements TipoServicioService {

    @Autowired
    private TipoServicioRepository tipoServicioRepository;

    @Override
    public List<TipoServicio> obtenerTipos() {
        return tipoServicioRepository.findAll();
    }

    @Override
    public TipoServicio buscarTipo(Integer id) {
        return tipoServicioRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarTipo(TipoServicio tipoServicio) {
        tipoServicioRepository.save(tipoServicio);
    }

    @Override
    public void eliminarTipo(Integer id) {
        tipoServicioRepository.deleteById(id);
    }
}
