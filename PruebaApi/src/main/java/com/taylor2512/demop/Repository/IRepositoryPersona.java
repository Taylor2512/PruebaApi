/**
 * 
 */
package com.taylor2512.demop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taylor2512.demop.model.Persona;


/**
 * @author jt251
 *
 */
public interface IRepositoryPersona {
	public interface IPersonaRepository extends JpaRepository<Persona, Long> {
		
	}

}
