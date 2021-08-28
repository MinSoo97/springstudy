package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // /hello에 들어가면 실행 시킨다
    public String hello(Model model) {  //모델을 만들어서 화면에 넘김
        model.addAttribute("data", "mingsoo!!"); //값 이름은 Name 내용은 hello! 로 보내줌
        return "hello"; //html 이랑 렌더링
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // 데이터를 그대로 보내는 방법
    public String helloString(@RequestParam("name") String name){
        return "hello"+name; //hello +요청한 문자 그대로 html태그 없이 문자 그대로
    }

    @GetMapping("hellp-api") //json 방식으로 반환한다.
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
