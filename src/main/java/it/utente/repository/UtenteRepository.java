package it.utente.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.utente.entity.Utente;
import jakarta.transaction.Transactional;
@Repository
public interface UtenteRepository extends JpaRepository<Utente,Integer>{
	@Modifying
    @Transactional
    @Query(value = "INSERT INTO users (idutente, nome, cognome, username,cellulare,indirizzo,eta,password) " +
                   "VALUES (:idutente, :nome, :cognome, :username,:cellulare,:indirizzo,:eta,:password) " +
                   "ON DUPLICATE KEY UPDATE nome = :nome, cognome = :username, cellulare = :cellulare,indirizzo = :cellulare,eta = :eta,"
                   + "password = :password,", nativeQuery = true)
    void upsertProduct(@Param("idutente") int id, 
                       @Param("nome") String nome, 
                       @Param("cognome") String cognome,
                       @Param("username") String username, 
                       @Param("cellulare") String cellulare, 
                       @Param("indirizzo") String indirizzo, 
                       @Param("eta") int eta, 
                       @Param("password") String password);
}
