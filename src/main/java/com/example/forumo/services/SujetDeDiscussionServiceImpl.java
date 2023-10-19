package com.example.forumo.services;

import com.example.forumo.entites.SujetDeDiscussion;
import com.example.forumo.repository.SujetDeDiscussionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SujetDeDiscussionServiceImpl implements SujetDeDiscussionService {

    @Autowired
    private SujetDeDiscussionRepository sujetDeDiscussionRepository;

    @Override
    public List<SujetDeDiscussion> getAllSujets() {
        return sujetDeDiscussionRepository.findAll();
    }

    @Override
    public SujetDeDiscussion getSujetById(Long id) {
        return sujetDeDiscussionRepository.findById(id).orElse(null);
    }

    @Override
    public void saveSujet(SujetDeDiscussion sujet) {
        sujetDeDiscussionRepository.save(sujet);
    }

    @Override
    public void deleteSujet(Long id) {
        sujetDeDiscussionRepository.deleteById(id);
    }
}

