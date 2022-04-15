package com.sidd.proj.PersonAddress.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sidd.proj.PersonAddress.CustomErrorHandling.DataMatchedException;
import com.sidd.proj.PersonAddress.CustomErrorHandling.DataNotFoundException;
import com.sidd.proj.PersonAddress.CustomErrorHandling.NoRecordsAvaliable;
import com.sidd.proj.PersonAddress.Entity.Person;
import com.sidd.proj.PersonAddress.Service.PersonService;


@RestController
@RequestMapping("/api")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@PostMapping("/")
	public Person save(@RequestBody Person person) throws DataMatchedException {
		return personService.savePerson(person);
	}
	
	@GetMapping("/")
	public List<Person> getAll() throws NoRecordsAvaliable{
		return personService.getAll();
	}
	
	@GetMapping("/{id}")
	public Person get(@PathVariable("id") long id) throws DataNotFoundException {
		return personService.get(id);
	}
	
	@PutMapping("/{id}")
	public Person update(@RequestBody Person person, @PathVariable("id") long id) throws DataNotFoundException {
		return personService.update(person, id);
	}
	
	@DeleteMapping("/{id}")
	public Person delete(@PathVariable("id") long id) throws DataNotFoundException {
		return personService.delete(id);
	}
	
}
