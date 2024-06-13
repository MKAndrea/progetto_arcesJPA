package it.utente.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import it.utente.entity.Utente;

import it.utente.repository.UtenteRepository;
@Service
public class UtenteCrud {
	  @Autowired
	    private UtenteRepository repository;
	  @Autowired
	    private BCryptPasswordEncoder passwordEncoder;

	    public String register(@RequestBody Utente user) {
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        repository.save(user);
	        return "User registered successfully";
	    }

	    public String login() {
	        return "Login successful";
	    }
	    
	public List<Utente> getAllUsers() {
        return repository.findAll();
    }

    public Utente getUserById(int id) {
        return repository.findById(id).orElse(null);
    }

//    public Utente saveUsers(Utente utente) {
//        return repository.save(utente);
//    }
    public Utente upsertUsers(Utente utente) {
        Optional<Utente> existingUsers = repository.findById(utente.getId());

        if (existingUsers.isPresent()) {
            // Aggiorna il prodotto esistente
            Utente updateUtente = existingUsers.get();
            updateUtente.setNome(utente.getNome());
            updateUtente.setCognome(utente.getCognome());
            updateUtente.setUsername(utente.getUsername());
            updateUtente.setCellulare(utente.getCellulare());
            updateUtente.setIndirizzo(utente.getIndirizzo());
            updateUtente.setEta(utente.getEta());
            updateUtente.setPassword(utente.getPassword());
            return repository.save(updateUtente);
        } else {
            // Inserisce un nuovo prodotto
            return repository.save(utente);
        }
    }
    public void deleteUsers(int id) {
    	repository.deleteById(id);
    }
}
