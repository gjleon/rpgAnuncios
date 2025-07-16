package br.com.rpganuncios.controller;

import br.com.rpganuncios.dtos.request.TableAdRequest;
import br.com.rpganuncios.dtos.response.TableAdResponse;
import br.com.rpganuncios.service.TableAdService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("tableads")
public class TableAdController {

    private final TableAdService tableAdService;

    @PostMapping
    public ResponseEntity<TableAdResponse> create(@RequestBody TableAdRequest tableAdRequest){
        return ResponseEntity.ok().body(tableAdService.save(tableAdRequest));
    }

    @GetMapping
    public ResponseEntity<List<TableAdResponse>> findAll(){
        List<TableAdResponse> tableAdResponses = tableAdService.findAll();
        return ResponseEntity.ok().body(tableAdResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TableAdResponse> findById(@PathVariable Long id){
        TableAdResponse tableAdResponse = tableAdService.findById(id);
        return ResponseEntity.ok().body(tableAdResponse);
    }

    @PostMapping("/{id}")
    public ResponseEntity<TableAdResponse> update(@PathVariable Long id, @RequestBody TableAdRequest tableAdRequest){
        TableAdResponse response = tableAdService.update(id, tableAdRequest);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        tableAdService.delete(id);
        return ResponseEntity.ok().build();
    }
}
