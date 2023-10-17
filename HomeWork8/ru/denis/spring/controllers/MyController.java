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

    /*
    Когда я использовал анатации @RequestParam то у меня не получалось проверять корректно ли Integer age
    (Если ввести в запросе age = String то выдавало ошибку: The origin server did not find a current representation for the target resource or is not willing to disclose that one exists.
    Решил взять HttpServletRequest хоть и немного не рацианально брать очень большой обьект (много данных).
    И я конечно наверное костылем проверяю являеться ли строка числом
     */
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
