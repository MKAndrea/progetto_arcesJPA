package it.utente.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import it.utente.crud.Utente2Crud;
import it.utente.entity.Utente;

@Controller
public class UtenteController {
	   @Autowired
	   private Utente2Crud utentecrud;

	   
	   @GetMapping("/register")
	   public String showRegistrationForm(Model model) {
	      model.addAttribute("user", new Utente());
	      return "register";
	   }
	   

	   @PostMapping(value = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	    public ResponseEntity<String> registerUser(@RequestBody Utente user) {
	        try {
	            Utente registerUser = utentecrud.registerUser(user.getUsername(), user.getPassword());
	            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
	        } catch (IllegalArgumentException e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	        } catch (RuntimeException e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	   
}
