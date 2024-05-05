package eus.birt.dam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eus.birt.dam.domain.Console;
import eus.birt.dam.repository.ConsoleRepository;

@CrossOrigin (origins= {"http://localhost:4200"})
@RestController
@RequestMapping ("api/console")
public class ConsoleController {

@Autowired
ConsoleRepository consoleRepository;
	
	@GetMapping({"/",""})
	public List <Console> index() {
	return consoleRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Console show(@PathVariable("id") Long id) {
		return consoleRepository.findById(id).orElse(null);
	}
	
	@PostMapping({"/",""})
	@ResponseStatus (HttpStatus.CREATED)
	public Console create(@RequestBody Console console) {
		return consoleRepository.save(console);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Console update(@RequestBody Console console, @PathVariable("id") Long id) {
		Console tempConsole = consoleRepository.findById(id).orElse(null);
		
		tempConsole.setName(console.getName());
		tempConsole.setModel(console.getModel());
		tempConsole.setNationality(console.getNationality());
		tempConsole.setCompany(console.getCompany());
		//Al ser un id diferente, el método save hace en realidad un update
		return consoleRepository.save(tempConsole);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		consoleRepository.deleteById(id);
	}
	
}
