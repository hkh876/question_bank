package com.example.questionbank.service;

import com.example.questionbank.dto.QuestionDTO;
import com.example.questionbank.entity.QuestionEntity;
import com.example.questionbank.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public QuestionService(QuestionRepository questionRepository, ModelMapper modelMapper) {
        this.questionRepository = questionRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional()
    public List<QuestionDTO> findAllByQuestionType(String questionType) {
        List<QuestionEntity> results = questionRepository.findAllByType(questionType);
        return results.stream().map(entity -> modelMapper.map(entity, QuestionDTO.class)).collect(Collectors.toList());
    }

    @Transactional()
    public List<QuestionDTO> findAllByQuestionTypeAndSaved(String questionType, boolean saved) {
        List<QuestionEntity> results = questionRepository.findAllByTypeAndSaved(questionType, saved);
        return results.stream().map(entity -> modelMapper.map(entity, QuestionDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    public QuestionDTO findById(Long id) {
        QuestionEntity result = questionRepository.findById(id).orElseThrow();
        return modelMapper.map(result, QuestionDTO.class);
    }

    public QuestionDTO updateQuestionSaved(Long id, boolean saved) {
        QuestionEntity findQuestion = questionRepository.findById(id).orElseThrow();
        findQuestion.update(saved);

        QuestionEntity updatedQuestion = questionRepository.save(findQuestion);
        return modelMapper.map(updatedQuestion, QuestionDTO.class);
    }
}
