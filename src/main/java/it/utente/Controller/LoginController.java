package it.utente.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.utente.entity.Utente2;

@Controller
public class LoginController {
	
	 @GetMapping("/login")
	   public String login() {
	      return "login";
	   }

}
