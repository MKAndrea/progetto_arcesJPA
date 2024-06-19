package it.utente.JPAController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.utente.crud.Utente2Crud;
import it.utente.entity.Utente;
import it.utente.entity.Utente2;

@RestController
@RequestMapping("/api")
public class UtenteRestController {
	 @Autowired
	 private Utente2Crud utentecrud;
	

	 
	 @GetMapping(value="/AllUsers",produces="application/json")
	    public List<Utente2> getAllProducts() {
	        return utentecrud.getAllUsers();
	    }

	    @GetMapping("/findUsers/{id}")
	    public Utente2 getUtenteById(@PathVariable int id) {
	        return utentecrud.getUserById(id);
	    }

	    @PostMapping("/upsertUser")
	    public Utente2 upsertUser(@RequestBody Utente2 utente) {
	        return utentecrud.upsertUsers(utente);
	    }

	    @DeleteMapping("/DeleteUtente/{id}")
	    public void deleteUtente(@PathVariable int id) {
	    	utentecrud.deleteUsers(id);
	    }
}
