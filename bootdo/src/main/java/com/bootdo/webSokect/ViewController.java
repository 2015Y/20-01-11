package com.bootdo.webSokect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/home")
@SessionAttributes("uname")
public class ViewController {

    @RequestMapping("/list")
    public String cc(ModelMap model) {
        System.out.println("进入聊天首页......");
        return "webSokect/index";
    }

    @RequestMapping("/room")
    public String h(ModelMap model, String uname, String roomid) {
        model.put("uname", uname);
        model.put("roomid", roomid);
        System.out.println("进入聊天室......");
        return "webSokect/room";
    }
}

