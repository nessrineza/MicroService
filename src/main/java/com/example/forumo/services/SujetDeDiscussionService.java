package com.example.forumo.services;

import com.example.forumo.entites.SujetDeDiscussion;

import java.util.List;

public interface SujetDeDiscussionService {

    List<SujetDeDiscussion> getAllSujets();

    SujetDeDiscussion getSujetById(Long id);

    void saveSujet(SujetDeDiscussion sujet);

    void deleteSujet(Long id);
}

