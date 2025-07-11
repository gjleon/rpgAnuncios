package br.com.rpganuncios.controller;

import br.com.rpganuncios.dtos.request.TableAdRequest;
import br.com.rpganuncios.dtos.response.TableAdResponse;
import br.com.rpganuncios.service.TableAdService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("tableads")
public class TableAdController {

    private final TableAdService tableAdService;

    @PostMapping
    public ResponseEntity<TableAdResponse> create(@RequestBody TableAdRequest tableAdRequest){
        return ResponseEntity.ok().body(tableAdService.save(tableAdRequest));
    }
}
