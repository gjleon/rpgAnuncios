package br.com.rpganuncios.controller;

import br.com.rpganuncios.dtos.request.UsuarioRequest;
import br.com.rpganuncios.dtos.response.UsuarioResponse;
import br.com.rpganuncios.entity.Usuario;
import br.com.rpganuncios.service.UsuarioService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponse> save(@Valid @RequestBody UsuarioRequest usuarioRequest){
        UsuarioResponse usuarioResponse = usuarioService.salvar(usuarioRequest);
        return ResponseEntity.ok().body(usuarioResponse);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> getAllUsers(){
        List<UsuarioResponse> usuarioResponses = usuarioService.findAll();
        return ResponseEntity.ok().body(usuarioResponses);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> findUserById(@PathVariable UUID id){
        return ResponseEntity.ok().body(usuarioService.findById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<UsuarioResponse> updateUser(@RequestBody UsuarioRequest usuarioRequest,@PathVariable UUID id){
        UsuarioResponse usuarioResponse = usuarioService.updateUser(usuarioRequest, id);
        return ResponseEntity.ok().body(usuarioResponse);
    }
}
