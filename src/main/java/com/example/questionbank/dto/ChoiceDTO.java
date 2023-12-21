package com.example.questionbank.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChoiceDTO {
    private Long id;
    private String content;
    private boolean hasTip;
    private String tip;
    private boolean capturedTip;
    private String tipUrl;
}
