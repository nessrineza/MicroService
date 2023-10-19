package com.example.forumo.controller;

import com.example.forumo.entites.SujetDeDiscussion;
import com.example.forumo.services.SujetDeDiscussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sujets")
public class SujetDeDiscussionController {

    @Autowired
    private SujetDeDiscussionService sujetDeDiscussionService;

    @GetMapping("/")
    public List<SujetDeDiscussion> getAllSujets() {
        return sujetDeDiscussionService.getAllSujets();
    }

    @GetMapping("/{id}")
    public SujetDeDiscussion getSujet(@PathVariable Long id) {
        return sujetDeDiscussionService.getSujetById(id);
    }

    @PostMapping("/")
    public void addSujet(@RequestBody SujetDeDiscussion sujet) {
        sujetDeDiscussionService.saveSujet(sujet);
    }

    @DeleteMapping("/{id}")
    public void deleteSujet(@PathVariable Long id) {
        sujetDeDiscussionService.deleteSujet(id);
    }
}

