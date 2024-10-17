package com.example.demo.service;

import com.example.demo.exception.usuario.InvalidUsuarioException;
import com.example.demo.exception.usuario.UsuarioNotFoundException;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Buscar todos os usuários
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Criar um novo usuário
    public Usuario createUsuario(Usuario usuario) {
        
        return usuarioRepository.save(usuario);
    }

    // Buscar por ID
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(UsuarioNotFoundException::new);
    }

    // Buscar por nome
    public Usuario getUsuarioByNomeUsuario(String nomeUsuario) {
        return usuarioRepository.findByNomeUsuario(nomeUsuario)
                .orElseThrow(UsuarioNotFoundException::new);
    }

    // Buscar por contato
    public Usuario getUsuarioByContato(String contato) {
        return usuarioRepository.findByContato(contato)
                .orElseThrow(UsuarioNotFoundException::new);
    }

    // Buscar por email
    public Usuario getUsuarioByEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(UsuarioNotFoundException::new);
    }

    // Atualizar usuário
    public Usuario updateUsuario(Long id, Usuario usuarioDetails) {
          validateUsuario(usuarioDetails);
          
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNomeUsuario(usuarioDetails.getNomeUsuario());
            usuario.setEmail(usuarioDetails.getEmail());
            usuario.setSenha(usuarioDetails.getSenha());
            usuario.setBio(usuarioDetails.getBio());
            usuario.setContato(usuarioDetails.getContato());
            usuario.setLocalizacao(usuarioDetails.getLocalizacao());
            usuario.setFotoPerfil(usuarioDetails.getFotoPerfil());
            return usuarioRepository.save(usuario);
        }).orElseThrow(() -> new UsuarioNotFoundException(
                "Não foi encontrado o usuário para as informações serem atualizadas."));
    }

    private void validateUsuario (Usuario usuario){
            if (usuario.getNomeUsuario() == null || usuario.getNomeUsuario().isEmpty() || usuario.getNomeUsuario().length() > 50) {
                throw new InvalidUsuarioException("O nome de usuário não pode ser nulo, vazio ou ter mais de 50 caracteres.");
            }
            if (usuario.getEmail() == null || usuario.getEmail().isEmpty() || usuario.getEmail().length() > 70) {
                throw new InvalidUsuarioException("O email não pode ser nulo, vazio ou ter mais de 70 caracteres.");
            }
            if (usuario.getSenha() == null || usuario.getSenha().isEmpty() || usuario.getSenha().length() < 6) {
                throw new InvalidUsuarioException("A senha não pode ser nula, vazia e deve ter pelo menos 6 caracteres.");
            }
            if (usuario.getContato() == null || usuario.getContato().isEmpty() || usuario.getContato().length() > 12) {
                throw new InvalidUsuarioException("O contato não pode ser nulo, vazio ou ter mais de 12 caracteres.");
            }
            if (usuario.getLocalizacao() == null || usuario.getLocalizacao().isEmpty() || usuario.getLocalizacao().length() > 80) {
                throw new InvalidUsuarioException("A localização não pode ser nula, vazia ou ter mais de 80 caracteres.");
            }
            if (usuario.getBio() != null && usuario.getBio().length() > 800) {
                throw new InvalidUsuarioException("A biografia não pode ter mais de 800 caracteres.");
            }
        }

    // Deletar usuário
    public void deleteUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new UsuarioNotFoundException("Não foi encontrado nenhum usuário com o id: " + id + " para ser deletado.");
        }
        usuarioRepository.deleteById(id);
    }
} 