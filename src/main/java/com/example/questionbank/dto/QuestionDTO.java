package com.example.questionbank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class QuestionDTO {
    private Long id;
    private String type;
    private String title;
    private int answer;
    private boolean saved;
    private boolean hasPassage;
    private String passageUrl;
    private List<ChoiceDTO> choices = new ArrayList<>();
}
