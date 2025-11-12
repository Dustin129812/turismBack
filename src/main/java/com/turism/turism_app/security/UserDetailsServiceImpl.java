package com.turism.turism_app.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;

import org.springframework.stereotype.Service;

import com.turism.turism_app.models.entities.Users;
import com.turism.turism_app.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)throws UsernameNotFoundException{
        Users user=userRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        // Devolvemos el usuario con sus datos, Spring Security lo usará para validar
        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles("USER") // más adelante puedes agregar roles reales
                .build();
    }
}
