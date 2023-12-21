package com.example.questionbank.repository;

import com.example.questionbank.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {
    List<QuestionEntity> findAllByType(String type);
    List<QuestionEntity> findAllByTypeAndSaved(String type, boolean saved);
}
