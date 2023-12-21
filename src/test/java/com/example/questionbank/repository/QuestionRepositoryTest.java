package com.example.questionbank.repository;

import com.example.questionbank.dto.QuestionDTO;
import com.example.questionbank.entity.QuestionEntity;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@SpringBootTest
public class QuestionRepositoryTest {
    @Autowired
    private QuestionRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    @DisplayName("문제 생성 테스트")
    public void createQuestionTest() {
        // Given
        QuestionEntity question = QuestionEntity.builder()
                .type("barista2")
                .title("테스트 문제")
                .answer(1)
                .build();

        // When
        QuestionEntity result = repository.save(question);

        // Then
        Assertions.assertEquals(result.getTitle(), question.getTitle());
    }

    @Test
    @DisplayName("전체 문제 조회 테스트")
    @Transactional()
    public void findAllQuestionTest() {
        // Given

        // When
        List<QuestionEntity> results = repository.findAll();
        List<QuestionDTO> questions = results.stream().map(entity -> modelMapper.map(entity, QuestionDTO.class))
                .collect(Collectors.toList());

        // Then
        log.info(questions.toString());
    }
}
