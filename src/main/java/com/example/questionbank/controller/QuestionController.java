package com.example.questionbank.controller;

import com.example.questionbank.dto.QuestionDTO;
import com.example.questionbank.dto.ResponseDTO;
import com.example.questionbank.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.questionbank.constant.Constants.*;

@RequestMapping(QUESTION_URL)
@RestController()
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("list")
    public ResponseEntity<ResponseDTO> listProcess(QuestionDTO questionDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        String questionType = questionDTO.getType();
        boolean saved = questionDTO.isSaved();

        if (questionType != null) {
            if (questionType.equals(QUESTION_TYPE_BARISTA2)) {
                // 바리스타2 기출 문제
                if (saved) {
                    responseDTO.setDataList(questionService.findAllByQuestionTypeAndSaved(questionType, saved));
                } else {
                    responseDTO.setDataList(questionService.findAllByQuestionType(questionType));
                }
            } else {
                responseDTO.setErrorMessage(NOT_IMPLEMENT_QUESTION_TYPE_ERROR);
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
            }
        } else {
            responseDTO.setErrorMessage(NOT_FOUND_QUESTION_TYPE_PARAMETER_ERROR);
            return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
        }

        // 응답
        ResponseEntity<ResponseDTO> response = new ResponseEntity<>(responseDTO, HttpStatus.OK);
        return response;
    }

    @GetMapping("barista2")
    public ResponseEntity<ResponseDTO> findByIdProcess(Long id) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(questionService.findById(id));

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<ResponseDTO> updateProcess(@PathVariable(name="id") Long id, @RequestBody QuestionDTO questionDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        boolean saved = questionDTO.isSaved();

        responseDTO.setData(questionService.updateQuestionSaved(id, saved));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
