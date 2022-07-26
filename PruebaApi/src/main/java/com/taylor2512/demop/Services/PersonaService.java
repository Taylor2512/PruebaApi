package com.taylor2512.demop.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taylor2512.demop.Repository.IRepositoryPersona.IPersonaRepository;
import com.taylor2512.demop.model.Persona;


@Service
public class PersonaService {
    @Autowired(required = false) //Specfied required=false explicitly
	private IPersonaRepository personaRepository=null;
	public Persona create(Persona entidad) {
		
		return personaRepository.save(entidad);
	}
	public List<Persona> GetAllPerson(){
		return personaRepository.findAll();		
	}
	public void Delette(Persona entidad) {
		
		 personaRepository.delete(entidad);
	}
	public Optional <Persona>FinId(Long Id) {
		
		return personaRepository.findById(Id);
	}

}
