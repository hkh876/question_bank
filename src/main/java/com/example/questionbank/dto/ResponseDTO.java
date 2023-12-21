package com.example.questionbank.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseDTO<T> {
    private List<T> dataList;
    private T data;
    private String errorMessage;
}
