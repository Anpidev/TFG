package com.tfg.tfg.models;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "analiticas")
public class Analitica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    @JsonIgnore
    private Usuario paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    @JsonIgnore
    private Usuario medico;

    @Column(name = "fecha_creacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaCreacion;

    @Column(name = "estado", columnDefinition = "VARCHAR(10) DEFAULT 'creada'")
    private String estado;

    @Column(name = "observaciones", length = 1000)
    private String observaciones;

    @OneToMany(mappedBy = "analitica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Parametro> parametros;

    public enum EstadoAnalitica {
        CREADA, EXTRAIDA, COMPLETADA, CANCELADA
    }

    // Constructores
    public Analitica() {
        this.fechaCreacion = LocalDateTime.now();
        this.estado = EstadoAnalitica.CREADA.name().toLowerCase();
    }

    public Analitica(int id) {
        this();
        this.id = id;
        this.fechaCreacion = LocalDateTime.now();
        this.estado = EstadoAnalitica.CREADA.name().toLowerCase();
    }

    public Analitica(Usuario paciente, Usuario medico, String observaciones) {
        this();
        this.paciente = paciente;
        this.medico = medico;
        this.observaciones = observaciones;
        this.fechaCreacion = LocalDateTime.now();
        this.estado = EstadoAnalitica.CREADA.name().toLowerCase();
    }

    // Métodos para manejo de parámetros
    public void addParametro(Parametro parametro) {
        parametros.add(parametro);
        parametro.setAnalitica(this);
    }

    public void removeParametro(Parametro parametro) {
        parametros.remove(parametro);
        parametro.setAnalitica(null);
    }

   

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getPaciente() {
        return paciente;
    }

    public void setPaciente(Usuario paciente) {
        this.paciente = paciente;
    }

    public Usuario getMedico() {
        return medico;
    }

    public void setMedico(Usuario medico) {
        this.medico = medico;
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
       
        String upperEstado = estado.toUpperCase();
        
        try {
           
            EstadoAnalitica.valueOf(upperEstado);
           
            this.estado = estado.toLowerCase();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Estado no válido.");
               
        }
    }

    
    public void setEstado(EstadoAnalitica estado) {
        this.estado = estado.name().toLowerCase();
    }


    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<Parametro> getParametros() {
        return parametros;
    }

    public void setParametros(List<Parametro> parametros) {
        this.parametros = parametros;
    }
}