/**
 * 
 */
package com.taylor2512.demop.Controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taylor2512.demop.Services.PersonaService;
import com.taylor2512.demop.model.Persona;


/**
 * @author jt251
 *
 */
@RestController
@RequestMapping("api/Persona/")
public class PersonaController {
	@Autowired
	private PersonaService personaService=null ;

	@PatchMapping
	private ResponseEntity<Persona> guardar(@RequestBody Persona entidad) {
		Persona temporal = personaService.create(entidad);
		try {
			return ResponseEntity.created(new URI("/api/Persona" + temporal.getId())).body(temporal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

		}

	}

	@GetMapping
	private ResponseEntity<List<Persona>> GetAll() {
		List<Persona> temporal = personaService.GetAllPerson();

		return ResponseEntity.ok(temporal);

	}

	/*@GetMapping(name = "/{Id}")
	private ResponseEntity<Optional<Persona>> GetforID(Long Id) {
		Optional<Persona> temporal = personaService.FinId(Id);

		return ResponseEntity.ok(temporal);

	}*/

	@DeleteMapping
	private ResponseEntity<Persona> eliminar(@RequestBody Persona entidad) {
		personaService.Delette(entidad);
		try {
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

		}

	}

}
