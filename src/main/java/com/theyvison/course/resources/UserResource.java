package com.theyvison.course.resources;

import com.theyvison.course.entities.User;
import com.theyvison.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
