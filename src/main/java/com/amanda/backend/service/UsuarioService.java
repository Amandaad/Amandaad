package com.amanda.backend.service;

import com.amanda.backend.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UsuarioService {

    private final List<Usuario> usuarios = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(1);

    public List<Usuario> listar() {
        return usuarios;
    }

    public Usuario buscarPorId(Long id) {
        return usuarios.stream()
                .filter(usuario -> usuario.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Usuario criar(Usuario usuario) {
        usuario.setId(sequence.getAndIncrement());
        usuarios.add(usuario);
        return usuario;
    }

    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
        Usuario usuario = buscarPorId(id);

        if (usuario == null) {
            return null;
        }

        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        return usuario;
    }

    public boolean remover(Long id) {
        return usuarios.removeIf(usuario -> usuario.getId().equals(id));
    }
}
