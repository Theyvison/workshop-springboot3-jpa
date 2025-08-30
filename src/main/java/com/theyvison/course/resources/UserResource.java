package com.theyvison.course.resources;

import com.theyvison.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // indica que essa classe e um controlador, um controlador e responsável por receber as requisições
@RequestMapping(value = "/users") // caminho do recurso
public class UserResource {
    @GetMapping // indica que esse metodo responde a requisições do tipo GET
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Maria", "maria@gmail.com", "(99)99999-9999", "123456");
        return ResponseEntity.ok().body(u);
    }
}
