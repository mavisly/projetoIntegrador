package com.generation.refugiomental.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.refugiomental.model.Usuario;
import com.generation.refugiomental.repository.UsuarioRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuariorepository;
	
	@Override
	public UserDetails loadUserByUsername (String UserName) throws  UsernameNotFoundException {
		
		Optional<Usuario> email = usuariorepository.findByEmail(UserName);
		
		if(email.isPresent()) 
			return new UserDetailsImpl(email.get());
		
		 throw new ResponseStatusException(HttpStatus.FORBIDDEN);	
	}
	
	
}
