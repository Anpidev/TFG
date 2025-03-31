package com.tfg.tfg.dto;

import java.time.LocalDateTime;
import java.util.List;

public class AnaliticaDto {
    private int id;
    private String pacienteNombre;  
    private String medicoNombre;    
    private LocalDateTime fechaCreacion;
    private String estado;
    private String observaciones;
    private List<String> parametros; 

    public enum EstadoAnalitica {
        CREADA, EXTRAIDA, COMPLETADA, CANCELADA
    }

    // Constructores
    public AnaliticaDto() {
        this.fechaCreacion = LocalDateTime.now();
        this.estado = EstadoAnalitica.CREADA.name().toLowerCase();
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPacienteNombre() {
        return pacienteNombre;
    }

    public void setPacienteNombre(String pacienteNombre) {
        this.pacienteNombre = pacienteNombre;
    }

    public String getMedicoNombre() {
        return medicoNombre;
    }

    public void setMedicoNombre(String medicoNombre) {
        this.medicoNombre = medicoNombre;
    }

    
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<String> getParametros() {
        return parametros;
    }

    public void setParametros(List<String> parametros) {
        this.parametros = parametros;
    }
}