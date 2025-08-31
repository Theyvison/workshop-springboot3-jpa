package com.theyvison.course.resources;

import com.theyvison.course.entities.User;
import com.theyvison.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController // indica que essa classe e um controlador, um controlador e responsável por receber as requisições
@RequestMapping(value = "/users") // caminho do recurso
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping // indica que esse metodo responde a requisições do tipo GET
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {
        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder // cria o caminho do novo recurso inserido
                .fromCurrentRequest() // pega o caminho do recurso atual
                .path("/{id}") // adiciona o id do novo recurso
                .buildAndExpand(obj.getId()) // substitui o {id} pelo id do novo recurso
                .toUri(); // converte para URI
        return ResponseEntity.created(uri).body(obj);
    }
}
