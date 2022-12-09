package com.generation.lojagames.security;

import java.util.Optional;

import com.generation.lojagames.model.Usuario;
import com.generation.lojagames.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;





    @Override
    public UserDetails loadUserByUsername(String NomeUsuario) throws UsernameNotFoundException {



        Optional<Usuario> usuario = usuarioRepository.findByUsuario(NomeUsuario);


        if (usuario.isPresent())
            return new UserDetailsImpl(usuario.get());
        else
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);

    }
}