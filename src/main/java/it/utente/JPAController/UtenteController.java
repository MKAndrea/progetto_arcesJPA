package it.utente.JPAController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.utente.entity.Utente;
import it.utente.repository.UtenteRepository;
@RestController
@RequestMapping("/api")
public class UtenteController {
	 @Autowired
	 private UtenteRepository repository;
	 
	 @RequestMapping(value="/finduser",method=RequestMethod.GET,produces="application/json")
	 public ResponseEntity<List<Utente>> finduser() throws Exception {
		 List<Utente> userList = repository.findAll();
		  if(userList.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    } else {
		        return new ResponseEntity<>(userList, HttpStatus.OK);
		    }
	 }
	 @RequestMapping(value="/finduser/{id}",method=RequestMethod.GET,produces="application/json")
	 public ResponseEntity<Utente> finduserById(@PathVariable("id") Integer id) throws Exception {
	  Optional<Utente> res=repository.findById(id);
	  return res.map(utente -> new ResponseEntity<>(utente, HttpStatus.OK))
	            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	 }
}
