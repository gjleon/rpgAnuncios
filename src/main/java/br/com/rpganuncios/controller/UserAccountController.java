package br.com.rpganuncios.controller;

import br.com.rpganuncios.dtos.request.UserAccountRequest;
import br.com.rpganuncios.dtos.response.UserAccountResponse;
import br.com.rpganuncios.service.UserAccountService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("users")
public class UserAccountController {

    private final UserAccountService userAccountService;

    @PostMapping
    public ResponseEntity<UserAccountResponse> create(@Valid @RequestBody UserAccountRequest userAccountRequest){
        UserAccountResponse userAccountResponse = userAccountService.save(userAccountRequest);
        return ResponseEntity.ok().body(userAccountResponse);
    }

    @GetMapping
    public ResponseEntity<List<UserAccountResponse>> findAllUsers(){
        List<UserAccountResponse> userAccountResponses = userAccountService.findAll();
        return ResponseEntity.ok().body(userAccountResponses);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserAccountResponse> findUserById(@PathVariable Long id){
        return ResponseEntity.ok().body(userAccountService.findById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<UserAccountResponse> updateUser(@RequestBody UserAccountRequest userAccountRequest, @PathVariable Long id){
        UserAccountResponse userAccountResponse = userAccountService.updateUser(userAccountRequest, id);
        return ResponseEntity.ok().body(userAccountResponse);
    }
}
