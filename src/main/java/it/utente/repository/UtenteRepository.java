package it.utente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.utente.entity.Utente;
@Repository
public interface UtenteRepository extends JpaRepository<Utente,Integer>{
	
	 // Adjusted method name to follow Spring Data naming conventions
    List<Utente> findByNome(String nome);

    // Corrected native query syntax
    @Query(value = "SELECT * FROM users WHERE nome LIKE :nome", nativeQuery = true)
    List<Utente> FindByNomeLike(@Param("nome") String nome);
}
