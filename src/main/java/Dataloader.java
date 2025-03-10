package com.projecto.crud.micrud;

import com.projecto.crud.micrud.entity.Usuario;
import com.projecto.crud.micrud.Repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.stream.IntStream;

@Component
public class Dataloader implements CommandLineRunner { //Ejecuta el código después de que la aplicación arranque.

    private final UsuarioRepository usuarioRepository;

    public Dataloader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(String... args) {
        if (usuarioRepository.count() == 0) {
            IntStream.rangeClosed(1, 1000).forEach(i -> { //numeros de 1 a 1000
                Usuario usuario = new Usuario("Usuario" + i, "usuario" + i + "@example.com");
                usuarioRepository.save(usuario);
                System.out.println("Insertado: " + usuario.getNombre() + " - " + usuario.getEmail());
            });
            System.out.println("✅ 1000 usuarios insertados correctamente.");
        } else {
            System.out.println("⚠️ Ya existen usuarios en la base de datos.");
        }
    }
}
