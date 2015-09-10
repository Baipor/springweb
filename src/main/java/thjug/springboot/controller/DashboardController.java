package thjug.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {

    @RequestMapping(value = "/auth/dashboard", method = RequestMethod.GET)
    public String dashboard(final Model model) {
        return "dashboard";
    }

}
