package com.example.forum.services;

import com.example.forum.entites.SujetDeDiscussion;

import java.util.List;

public interface SujetDeDiscussionService {

    List<SujetDeDiscussion> getAllSujets();

    SujetDeDiscussion getSujetById(Long id);

    void saveSujet(SujetDeDiscussion sujet);

    boolean deleteSujet(Long id);
}

