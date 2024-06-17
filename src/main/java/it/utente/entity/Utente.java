package it.utente.entity;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
public class Utente {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)	
@Column(name="idutente")
private int id;
@Column(name="username")
private String username;
@Column(name="password")
private String password;


@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JoinTable(name = "user_roles", joinColumns = @jakarta.persistence.JoinColumn(name = "user_id"), inverseJoinColumns = @jakarta.persistence.JoinColumn (name = "role_id"))
private Set<Role> roles;

public Utente() {
	this.roles = new HashSet<>();
	}

public void addRole(Role role) {
    this.roles.add(role);
    role.getUtente().add(this);
 }

 public void removeRole(Role role) {
    this.roles.remove(role);
    role.getUtente().remove(this);
 }


  public Collection<? extends GrantedAuthority> getAuthorities() {
      Set<GrantedAuthority> authorities = new HashSet<>();
      for (Role role : roles) {
          authorities.add(new SimpleGrantedAuthority(role.getName()));
      }
      return authorities;
  }
  public boolean isAccountNonExpired() {
      return true;
   }

   public boolean isAccountNonLocked() {
      return true;
   }

   public boolean isCredentialsNonExpired() {
      return true;
   }

public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Set<Role> getRoles() {
	return roles;
}

public void setRoles(Set<Role> roles) {
	this.roles = roles;
}

public String getUsername() {
	return username;
}


}