package com.bootdo.webSokect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/webSocket")
@SessionAttributes("uname")
public class ViewController {

    @GetMapping("/index")
    public String cc() {
        System.out.println("进入聊天首页......");
        return "webSocket/index";
    }

    @GetMapping("/room")
    public String h() {
        System.out.println("进入聊天室......");
        return "webSocket/room";
    }
}

