package net.codejava.usuario;

import java.util.Arrays;
import java.util.Collection;

import net.codejava.usuario.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {

	private final User user;
	
	public MyUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
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

	public String getNome() {
		return this.user.getNome();
	}


	public String getCargo() {
		return this.user.getCargo();
	}

	public String getAreaAtuacao() {
		return this.user.getAreaAtuacao();
	}

	public String getCep() {
		return this.user.getCep();
	}

	public Long getTelefone() {
		return this.user.getTelefone();
	}

	public String getEstado() {
		return this.user.getEstado();
	}

	public long getUserId() {
		return this.user.getId();
	}

	public String getSubAreaAtuacao() { return this.user.getSubAreaAtuacao(); }

}
