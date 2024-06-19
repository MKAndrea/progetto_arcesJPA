package it.utente.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.utente.entity.Utente2;
import jakarta.transaction.Transactional;
@Repository
public interface Utente2Repository extends JpaRepository<Utente2,Integer>{
	
	@Query("SELECT u FROM Utente u WHERE u.username = :username")
    Utente2 getUserByUsername(@Param("username") String username);
	
	
	 
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users (idutente, nome, cognome, username, cellulare, indirizzo, eta, password) " +
                   "VALUES (:idutente, :nome, :cognome, :username, :cellulare, :indirizzo, :eta, :password) " +
                   "ON DUPLICATE KEY UPDATE nome = :nome, cognome = :cognome, username = :username, " +
                   "cellulare = :cellulare, indirizzo = :indirizzo, eta = :eta, password = :password, "
                   , nativeQuery = true)
    void upsertUser(@Param("idutente") int id, 
                    @Param("nome") String nome, 
                    @Param("cognome") String cognome,
                    @Param("username") String username, 
                    @Param("cellulare") String cellulare, 
                    @Param("indirizzo") String indirizzo, 
                    @Param("eta") int eta, 
                    @Param("password") String password
                   );
}
