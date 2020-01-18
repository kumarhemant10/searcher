package com.hk.prj.vite.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class CustomUserDetails extends User implements UserDetails {

	public CustomUserDetails(User user, List<String> userRoles) {
		super(user);
		this.userRoles=userRoles;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3760979890884120309L;

	private List<String> userRoles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String roles=StringUtils.collectionToCommaDelimitedString(userRoles);   
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}

	@Override
	public boolean isAccountNonExpired() {
		return Boolean.TRUE;
	}

	@Override
	public boolean isAccountNonLocked() {
		return Boolean.TRUE;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return Boolean.TRUE;
	}

	@Override
	public boolean isEnabled() {
		return Boolean.TRUE;
	}

	@Override
	public String getUsername() {
		return super.getUserName();
	}

	
}
