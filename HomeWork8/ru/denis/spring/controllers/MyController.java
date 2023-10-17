package ru.denis.spring.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class MyController {


    @GetMapping("diary/start")
    public String diaryPage( HttpServletRequest httpServletRequest,
                            Model model) {
        Integer age = null;
        String name =httpServletRequest.getParameter("name");
        String surname = httpServletRequest.getParameter("surname");
        try {

            age =  Integer.valueOf(httpServletRequest.getParameter("age"));
        }catch (NumberFormatException e){
            model.addAttribute("message","You have made an incorrect request, Age instanceof Integer");
            return "diary/hello";
        }

        if(name!=null&&surname!=null&&age!=null ) {

            model.addAttribute("message", "Hello I'm " +age+", My name is"+ name + " " + surname);
            return "diary/hello";
        }
        return "diary/help";
    }
    @GetMapping("/")
    public String home() {
        return "index";
    }

}
