package com.codigo.hibernate_persistencia.controller;

import com.codigo.hibernate_persistencia.dao.PersonaRepository;
import com.codigo.hibernate_persistencia.entity.PersonaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hibernate/v1")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    @PostMapping("/crear")
    public ResponseEntity<PersonaEntity> crearPersona(
                @RequestBody PersonaEntity persona){
        return ResponseEntity.ok(personaRepository.save(persona));
    }

    @GetMapping("/lista")
    public ResponseEntity<List<PersonaEntity>> listaPersona(){
        return ResponseEntity.ok(personaRepository.findAll());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<PersonaEntity> buscarPersona(@PathVariable("id") Long id){
        return ResponseEntity.ok(personaRepository.findById(id).get());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PersonaEntity> actualizar(@PathVariable("id") Long id,
                                                    @RequestBody  PersonaEntity persona){
        Optional<PersonaEntity> personaExistente = personaRepository.findById(id);
        if(personaExistente.isPresent()){
            PersonaEntity datosActualizar = personaExistente.get();
            datosActualizar.setId(10L);
            datosActualizar.setNombres(persona.getNombres());
            datosActualizar.setApellidos(persona.getApellidos());
            datosActualizar.setEmail(persona.getEmail());
            return ResponseEntity.ok(personaRepository.save(datosActualizar));
        }else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new PersonaEntity());
        }
    }

    @GetMapping("/buscarPersonaEstado/{estado}")
    public ResponseEntity<List<PersonaEntity>> buscarPersonaEstado(@PathVariable("estado") Integer estado){
        return ResponseEntity.ok(personaRepository.findByEstado(estado).get());
    }
}
