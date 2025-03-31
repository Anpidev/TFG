package com.tfg.tfg.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "parametros")
public class Parametro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "analitica_id", nullable = false)
    @JsonIgnore
    private Analitica analitica;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

   
    // Constructores
    public Parametro() {
    }
    
    

    public Parametro(int id) {
		super();
		this.id = id;
	}



	public Parametro(Analitica analitica, String nombre) {
        this.analitica = analitica;
        this.nombre = nombre;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public Analitica getAnalitica() {
        return analitica;
    }

    public void setAnalitica(Analitica analitica) {
        this.analitica = analitica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}