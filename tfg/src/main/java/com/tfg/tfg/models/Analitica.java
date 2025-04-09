package com.tfg.tfg.models;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "medico_id", nullable = false)
	@JsonIgnore
	private Medico medico;

	@Column(name = "fecha_creacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDate fechaCreacion;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado", columnDefinition = "VARCHAR(10) DEFAULT 'CREADA'")
	private EstadoAnalitica estado;

	@Column(name = "observaciones", length = 1000)
	private String observaciones;

	@ElementCollection
	@CollectionTable(name = "analiticas_parametros", joinColumns = @JoinColumn(name = "analitica_id"))
	@Column(name = "parametro")
	@Enumerated(EnumType.STRING)
	private List<Parametros> parametros;

	public enum EstadoAnalitica {
		CREADA, EXTRAIDA, COMPLETADA, CANCELADA
	}

	// Constructores
	public Analitica() {
		this.fechaCreacion = LocalDate.now();
		this.estado = EstadoAnalitica.CREADA;
	}

	public Analitica(int id) {
		this();
		this.id = id;
	}

	public Analitica(int id, Paciente paciente, Medico medico, LocalDate fechaCreacion, EstadoAnalitica estado,
			String observaciones, List<Parametros> parametros) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.medico = medico;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.observaciones = observaciones;
		this.parametros = parametros;
	}

	// Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	

	public EstadoAnalitica getEstado() {
		return estado;
	}

	public void setEstado(EstadoAnalitica estado) {
		this.estado = estado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public List<Parametros> getParametros() {
		return parametros;
	}

	public void setParametros(List<Parametros> parametros) {
		this.parametros = parametros;
	}

}
