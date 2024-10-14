package io.github.bergdeveloper.todolist_api.controller;

import io.github.bergdeveloper.todolist_api.dto.UsuarioDTO;
import io.github.bergdeveloper.todolist_api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    private UsuarioDTO salvar(@RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.salvar(usuarioDTO);
    }

    @GetMapping("/listar-usuarios")
    private String listar_usuarios(){
        return "Permissão de administrador.";
    }
}