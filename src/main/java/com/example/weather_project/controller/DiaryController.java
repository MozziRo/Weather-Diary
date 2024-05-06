package com.example.weather_project.controller;

import com.example.weather_project.service.DiaryService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * client와 맞다아 있다
 * 요청을 보내는 역할
 * 저장을 할땐 post사용
 * 조회를 할땐 get 사용
 */
@RestController
public class DiaryController {
    //controller는 service로 데이터를 넘겨준다.
    private final DiaryService diaryService;
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    //client로 부터 값을 어떻게 받을 것인지 정의하는 작업이다.
    @PostMapping("/create/diary")
    void createDiary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestBody String text){
        diaryService.createDiary(date, text);
    }
}
