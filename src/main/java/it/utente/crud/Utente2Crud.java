package it.utente.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import it.utente.entity.Role;
import it.utente.entity.Utente;
import it.utente.entity.Utente2;

import it.utente.repository.Utente2Repository;
import it.utente.repository.UtenteRepository;
import jakarta.transaction.Transactional;
import it.utente.repository.RoleRepository;
@Service
public class Utente2Crud {
	  @Autowired
	    private Utente2Repository repository;
	  @Autowired
	    private UtenteRepository utenterepository;
	  @Autowired
	    private RoleRepository rolerepository;
	  @Autowired
	    private BCryptPasswordEncoder passwordEncoder;

//	    public String register(@RequestBody Utente user) {
//	        user.setPassword(passwordEncoder.encode(user.getPassword()));
//	        repository.save(user);
//	        return "User registered successfully";
//	    }
//
//	    public String login() {
//	        return "Login successful";
//	    }
	    
	public List<Utente2> getAllUsers() {
        return repository.findAll();
    }

    public Utente2 getUserById(int id) {
        return repository.findById(id).orElse(null);
    }

//    public Utente saveUsers(Utente utente) {
//        return repository.save(utente);
//    }
    public Utente2 upsertUsers(Utente2 utente2) {
        Optional<Utente2> existingUsers = repository.findById(utente2.getId());

        if (existingUsers.isPresent()) {
            // Aggiorna il prodotto esistente
            Utente2 updateUtente = existingUsers.get();
            updateUtente.setNome(utente2.getNome());
            updateUtente.setCognome(utente2.getCognome());
            updateUtente.setUsername(utente2.getUsername());
            updateUtente.setCellulare(utente2.getCellulare());
            updateUtente.setIndirizzo(utente2.getIndirizzo());
            updateUtente.setEta(utente2.getEta());
            updateUtente.setPassword(utente2.getPassword());
            if (!utente2.getPassword().equals(updateUtente.getPassword())) {
                updateUtente.setPassword(passwordEncoder.encode(utente2.getPassword()));
            }
            return repository.save(updateUtente);
        } else {
            utente2.setPassword(passwordEncoder.encode(utente2.getPassword()));
            return repository.save(utente2);
        }
    }
    public void deleteUsers(int id) {
    	repository.deleteById(id);
    }
    @Transactional
    public Utente registerUser(String username, String password) throws RuntimeException {
        // Controlla se l'utente esiste già
        if (utenterepository.existsByUsername(username)) {
            throw new IllegalArgumentException("Username already exists");
        }
        // Controlla se il ruolo esiste
        Role role = rolerepository.findByName("ROLE_USER")
                                  .orElseThrow(() -> new RuntimeException("Default role not found"));
        // Crea un nuovo utente
        Utente user = new Utente();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password)); // Codifica la password
        user.addRole(role);


        // Salva l'utente nel database
        return utenterepository.save(user);
    }
}
