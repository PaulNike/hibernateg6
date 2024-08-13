package com.codigo.hibernate_persistencia.controller;

import com.codigo.hibernate_persistencia.aggregates.Constants;
import com.codigo.hibernate_persistencia.aggregates.UsuarioRequest;
import com.codigo.hibernate_persistencia.dao.UsuarioRepository;
import com.codigo.hibernate_persistencia.entity.PerfilEntity;
import com.codigo.hibernate_persistencia.entity.PersonaEntity;
import com.codigo.hibernate_persistencia.entity.UsuarioEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario/v1")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioRequest usuarioRequest){
        UsuarioEntity usuario = new UsuarioEntity();
        PerfilEntity perfil = new PerfilEntity();
        usuario.setUsername(usuarioRequest.getUsername());
        usuario.setPassword(usuarioRequest.getPassword());
        usuario.setCel(usuarioRequest.getCel());
        usuario.setEstado(Constants.ESTADO_ACTIVO);
        perfil.setBio(usuarioRequest.getBio());
        perfil.setIntereses(usuarioRequest.getIntereses());
        //Seteando al Usuario en Perfil
        perfil.setUsuario(usuario);
        //Seteando el Perfil al Usuario
        usuario.setPerfil(perfil);
        return new ResponseEntity<>(usuarioRepository.save(usuario)
                , HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UsuarioEntity>findUser(@PathVariable("id") Long id){
        return ResponseEntity.ok(usuarioRepository.findById(id).get());
    }

}
