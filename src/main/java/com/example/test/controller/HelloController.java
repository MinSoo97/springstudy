package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") // /hello에 들어가면 실행 시킨다
    public String hello(Model model) {  //모델을 만들어서 화면에 넘김
        model.addAttribute("data", "mingsoo!!"); //값 이름은 Name 내용은 hello! 로 보내줌
        return "hello"; //html 이랑 렌더링
    }
}
