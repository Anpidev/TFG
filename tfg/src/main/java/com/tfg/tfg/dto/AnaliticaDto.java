package com.tfg.tfg.dto;

import java.time.LocalDate;
import java.util.List;

import com.tfg.tfg.models.Analitica.EstadoAnalitica;
import com.tfg.tfg.models.Parametros;

public class AnaliticaDto {
    private int id;
    private int pacienteId;
    private String pacienteNombre;
    private String pacienteApellido;
    private String pacienteDni;
    private int medicoId;
    private String medicoNombre;
    private String medicoApellido;
    private String medicoColegiado;
    private LocalDate fechaCreacion;
    private EstadoAnalitica estado;
    private String observaciones;
    private List<Parametros> parametros;

   

    // Constructor vacío
    public AnaliticaDto() {
    }
    
 

	//Contructor con todos los campos
    public AnaliticaDto(int id, int pacienteId, String pacienteNombre, String pacienteApellido, String pacienteDni,
			int medicoId, String medicoNombre, String medicoApellido,String medicoColegiado, LocalDate fechaCreacion, EstadoAnalitica estado,
			String observaciones, List<Parametros> parametros) {
		super();
		this.id = id;
		this.pacienteId = pacienteId;
		this.pacienteNombre = pacienteNombre;
		this.pacienteApellido = pacienteApellido;
		this.pacienteDni = pacienteDni;
		this.medicoId = medicoId;
		this.medicoNombre = medicoNombre;
		this.medicoApellido = medicoApellido;
		this.medicoColegiado=medicoColegiado;
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

    public String getPacienteNombre() {
        return pacienteNombre;
    }

    public void setPacienteNombre(String pacienteNombre) {
        this.pacienteNombre = pacienteNombre;
    }

    public String getPacienteApellido() {
        return pacienteApellido;
    }

    public void setPacienteApellido(String pacienteApellido) {
        this.pacienteApellido = pacienteApellido;
    }

    public String getPacienteDni() {
        return pacienteDni;
    }

    public void setPacienteDni(String pacienteDni) {
        this.pacienteDni = pacienteDni;
    }

    public String getMedicoNombre() {
        return medicoNombre;
    }

    public void setMedicoNombre(String medicoNombre) {
        this.medicoNombre = medicoNombre;
    }

    public String getMedicoApellido() {
        return medicoApellido;
    }

    public void setMedicoApellido(String medicoApellido) {
        this.medicoApellido = medicoApellido;
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

    
   


	public String getMedicoColegiado() {
		return medicoColegiado;
	}



	public void setMedicoColegiado(String medicoColegiado) {
		this.medicoColegiado = medicoColegiado;
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

	public int getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(int pacienteId) {
		this.pacienteId = pacienteId;
	}

	public int getMedicoId() {
		return medicoId;
	}

	public void setMedicoId(int medicoId) {
		this.medicoId = medicoId;
	}
    
}