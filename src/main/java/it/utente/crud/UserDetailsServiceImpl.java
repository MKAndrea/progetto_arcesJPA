package it.utente.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import it.utente.entity.MyUserDetail;
import it.utente.entity.Utente;
import it.utente.repository.UtenteRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
	   @Autowired
	    private UtenteRepository utenteRepository;
	     
	    @Override
	    public UserDetails loadUserByUsername(String username)
	            throws UsernameNotFoundException {
	        Utente utente = utenteRepository.getUserByUsername(username);
	         
	        if (utente == null) {
	            throw new UsernameNotFoundException("Could not find user");
	        }
	         
	        return new MyUserDetail(utente);
	    }
}
