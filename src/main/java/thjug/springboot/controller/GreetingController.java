package thjug.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(
            final @RequestParam(value="name", required=false, defaultValue="World") String name,
            final Model model) {

        model.addAttribute("name", name);
        return "greeting";
    }

}