package com.example.meuble.Controller;
import com.example.meuble.Entities.Meuble;
import com.example.meuble.Services.MeubleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/meuble")
public class MeubleRestAPI {
    private String title = "Hello, i'm the meuble Micro Service";

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println(title);
        return title;
    }

    @Autowired
    private MeubleService meubleService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Meuble> createMeuble(@RequestBody Meuble meuble) {
        return new ResponseEntity<>(meubleService.addMeuble(meuble), HttpStatus.OK);
    }


    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Meuble> updateMeuble(@PathVariable(value = "id") int id,
                                               @RequestBody Meuble meuble) {
        return new ResponseEntity<>(meubleService.updateMeuble(id, meuble), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCMeuble(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(meubleService.deleteMeuble(id), HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Meuble>> showAllMeubles() {
        List<Meuble> meubles = meubleService.getAllMeubles();
        return new ResponseEntity<>(meubles, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Meuble> getMeuble(@PathVariable("id") int id) {
        Meuble meuble = meubleService.getMeubleById(id);
        if (meuble != null) {
            return new ResponseEntity<>(meuble, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
