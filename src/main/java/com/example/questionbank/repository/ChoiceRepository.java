package com.example.questionbank.repository;

import com.example.questionbank.entity.ChoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoiceRepository extends JpaRepository<ChoiceEntity, Long> {
}
