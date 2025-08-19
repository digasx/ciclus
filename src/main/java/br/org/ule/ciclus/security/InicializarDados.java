/*package br.org.ule.ciclus.security;

import br.org.ule.ciclus.entity.Usuario;
import br.org.ule.ciclus.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

public class InicializarDados {

    @Bean
    CommandLineRunner initUsuarios(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (usuarioRepository.findByUsername("admin").isEmpty()) {
                Usuario admin = new Usuario();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("123456"));
                admin.setRole(Set.of("ROLE_ADMIN"));
                usuarioRepository.save(admin);
            }
        };
    }
}*/
