package it.utente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.utente.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	 // Adjusted method name to follow Spring Data naming conventions
    List<Product> findByNome_prodotto(String nome_prodotto);

    // Corrected native query syntax
    @Query(value = "SELECT * FROM prodotti WHERE nome_prodotto LIKE :np", nativeQuery = true)
    List<Product> FindByNome_prodotto(@Param("np") String nome_prodotto);
}
