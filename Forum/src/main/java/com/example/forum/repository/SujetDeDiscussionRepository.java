package com.example.forum.repository;

import com.example.forum.entites.SujetDeDiscussion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SujetDeDiscussionRepository extends JpaRepository<SujetDeDiscussion, Long> {
}

