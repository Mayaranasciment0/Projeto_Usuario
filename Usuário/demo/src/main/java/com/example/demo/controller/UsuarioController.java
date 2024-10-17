package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Buscar por Id
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        return ResponseEntity.ok(usuario);
    }

    // Buscar por nome
    @GetMapping("/nome/{nomeUsuario}")
    public ResponseEntity<Usuario> getUsuarioByNome(@PathVariable String nomeUsuario) {
        Usuario usuario = usuarioService.getUsuarioByNomeUsuario(nomeUsuario);
        return ResponseEntity.ok(usuario);
    }

    // Buscar por contato
    @GetMapping("/contato/{contato}")
    public ResponseEntity<Usuario> getUsuarioByContato(@PathVariable String contato) {
        Usuario usuario = usuarioService.getUsuarioByContato(contato);
        return ResponseEntity.ok(usuario);
    }

    // Buscar por email
    @GetMapping("/email/{email}")
    public ResponseEntity<Usuario> getUsuarioByEmail(@PathVariable String email) {
        Usuario usuario = usuarioService.getUsuarioByEmail(email);
        return ResponseEntity.ok(usuario);
    }

    // Listar todos os usuários
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    // criar usuário
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario novoUsuario) {
        usuarioService.createUsuario(novoUsuario);
        return ResponseEntity.ok(novoUsuario);
    }

    // Editar usuário
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
        usuarioService.updateUsuario(id, usuarioDetails);
        return ResponseEntity.ok(usuarioDetails);
    }

    // deletar usuário
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
