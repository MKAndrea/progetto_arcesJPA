package it.utente.entity;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetail implements UserDetails {
	private Utente utente;
	
	public MyUserDetail(Utente utente) {
        this.utente = utente;
    }
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		  SimpleGrantedAuthority authority = new SimpleGrantedAuthority(utente.getRole());
	        return Arrays.asList(authority);
	}

	 @Override
	    public String getPassword() {
	        return utente.getPassword();
	    }
	 
	    @Override
	    public String getUsername() {
	        return utente.getUsername();
	    }
	 
	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }
	 
	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }
	 
	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }
	 
	    @Override
	    public boolean isEnabled() {
	        return true;
	    }

}
