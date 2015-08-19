package thjug.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(final Model model) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(
            final @RequestParam(value="username", required=false) String name,
            final @RequestParam(value="password", required=false) String password,
            final Model model) {

        model.addAttribute("result", name);
        return "loginresult";
    }

}
