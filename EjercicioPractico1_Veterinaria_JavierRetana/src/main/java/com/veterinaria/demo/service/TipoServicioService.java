/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.veterinaria.demo.service;

import com.veterinaria.demo.domain.TipoServicio;
import java.util.List;

public interface TipoServicioService {

    public List<TipoServicio> obtenerTipos();

    public TipoServicio buscarTipo(Integer id);

    public void guardarTipo(TipoServicio tipoServicio);

    public void eliminarTipo(Integer id);
}