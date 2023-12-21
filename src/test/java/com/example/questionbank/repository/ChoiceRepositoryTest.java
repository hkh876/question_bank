package com.example.questionbank.repository;

import com.example.questionbank.entity.ChoiceEntity;
import com.example.questionbank.entity.QuestionEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ChoiceRepositoryTest {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ChoiceRepository choiceRepository;

    @Test
    @DisplayName("보기 다수 생성 테스트")
    public void createChoiceTest() {
        // Given
        QuestionEntity question = questionRepository.findById(1L).orElseThrow();

        ArrayList<ChoiceEntity> choices = new ArrayList<>();
        for (int i=1; i<=4; i++) {
            ChoiceEntity choice = ChoiceEntity.builder()
                    .content("테스트 보기 " + i)
                    .question(question)
                    .build();
            choices.add(choice);
        }

        // When
        List<ChoiceEntity> results = choiceRepository.saveAll(choices);

        // Then
        Assertions.assertEquals(results.size(), choices.size());
    }
}
