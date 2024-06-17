package it.utente.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.utente.entity.Utente;


public interface UtenteRepository extends JpaRepository<Utente,Integer>{
	 Optional<Utente> findByUsername(String username);
	    boolean existsByUsername(String username);
}
