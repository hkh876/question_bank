package com.example.questionbank.service;

import com.example.questionbank.dto.QuestionDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class QuestionServiceTest {
    @Autowired
    private QuestionService service;

    @Test
    @DisplayName("문제 유형에 따른 조회 서비스 테스트")
    public void findAllByTypeServiceTest() {
        // Given
        String questionType = "barista2";

        // When
        List<QuestionDTO> results = service.findAllByQuestionType(questionType);
        QuestionDTO question = results.get(0);

        // Then
        Assertions.assertEquals(question.getType(), questionType);
    }
}
