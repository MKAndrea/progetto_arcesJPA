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
	
	@Query("SELECT u FROM Utente u WHERE u.username = :username")
    Utente getUserByUsername(@Param("username") String username);
	 
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users (idutente, nome, cognome, username, cellulare, indirizzo, eta, password, role, enabled) " +
                   "VALUES (:idutente, :nome, :cognome, :username, :cellulare, :indirizzo, :eta, :password, :role, :enabled) " +
                   "ON DUPLICATE KEY UPDATE nome = :nome, cognome = :cognome, username = :username, " +
                   "cellulare = :cellulare, indirizzo = :indirizzo, eta = :eta, password = :password, " +
                   "role = :role, enabled = :enabled", nativeQuery = true)
    void upsertUser(@Param("idutente") int id, 
                    @Param("nome") String nome, 
                    @Param("cognome") String cognome,
                    @Param("username") String username, 
                    @Param("cellulare") String cellulare, 
                    @Param("indirizzo") String indirizzo, 
                    @Param("eta") int eta, 
                    @Param("password") String password,
                    @Param("role") String role,
                    @Param("enabled") boolean enabled);
}
