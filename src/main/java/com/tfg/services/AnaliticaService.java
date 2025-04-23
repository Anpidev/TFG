package com.tfg.tfg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tfg.tfg.models.Analitica;
import com.tfg.tfg.models.Medico;
import com.tfg.tfg.models.Paciente;
import com.tfg.tfg.repositories.AnaliticaRepository;
import com.tfg.tfg.repositories.MedicoRepository;
import com.tfg.tfg.repositories.PacienteRepository;

@Service
public class AnaliticaService {

	// Inyección de dependencias a traves de constructores

	private PacienteRepository pacienteRepository;
	private MedicoRepository medicoRepository;
	private AnaliticaRepository analiticaRepository;

	public AnaliticaService(AnaliticaRepository analiticaRepository, PacienteRepository pacienteRepository,
			MedicoRepository medicoRepository) {
		super();
		this.analiticaRepository = analiticaRepository;
		this.medicoRepository = medicoRepository;
		this.pacienteRepository = pacienteRepository;
	}

	// Metodos de analitica
	public <S extends Analitica> S saveAnalitica(S analitica) {
		return analiticaRepository.save(analitica);
	}

	public List<Analitica> findAllAnaliticas() {
		return analiticaRepository.findAllWithRelations();
	}

	public Optional<Analitica> findByIdAnalitica(Integer id) {
		return analiticaRepository.findById(id);
	}

	public void deleteByIdAnalitica(int id) {
		analiticaRepository.deleteById(id);
	}

	

	// Metodos de paciente

	public List<Paciente> findAllPacientes() {
		return pacienteRepository.findAll();
	}

	public <S extends Paciente> S savePaciente(S paciente) {
		return pacienteRepository.save(paciente);
	}

	public Optional<Paciente> findByIdPaciente(Integer id) {
		return pacienteRepository.findById(id);
	}

	public void deleteByIdPaciente(int id) {
		pacienteRepository.deleteById(id);
	}

	// Metodos de medico

	public List<Medico> findAllMedicos() {
		return medicoRepository.findAll();
	}

	public <S extends Medico> S saveMedico(S medico) {
		return medicoRepository.save(medico);
	}

	public Optional<Medico> findByIdMedico(Integer id) {
		return medicoRepository.findById(id);
	}

	public void deleteByMedico(int id) {
		medicoRepository.deleteById(id);
	}

}
