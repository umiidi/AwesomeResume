package com.company.controller;

import com.company.entity.User;
import com.company.form.UserForm;
import com.company.service.DummyService;
import com.company.service.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/users-old")
    public String indexOld(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Integer nationalityId = null;
        if (request.getParameter("nid") != null && !request.getParameter("nid").trim().isEmpty()) {
            nationalityId = Integer.parseInt(request.getParameter("nid"));
        }
        List<User> users = userService.getAll(name, surname, nationalityId);
        request.setAttribute("users", users);
        return "users";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ModelAndView index(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname,
                              @RequestParam(value = "nid", required = false) Integer nationalityId) {
        List<User> users = userService.getAll(name, surname, nationalityId);
        ModelAndView mv = new ModelAndView("users");
        mv.addObject("users", users);
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/usersm")
    public ModelAndView indexNew(
            @Valid
            @ModelAttribute("user") UserForm u,
            BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView("users");
        if (bindingResult.hasErrors()) {
            return mv;
        }
        List<User> users = userService.getAll(u.getName(), u.getSurname(), u.getNationalityId());
        mv.addObject("users", users);
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String logout() {
        return "logout";
    }

    @Autowired
    DummyService dummyService;

    @RequestMapping(method = {RequestMethod.GET}, value = "/foo")
    public String foo() {
        System.out.println("foo controller");
        dummyService.foo();
//        dummyService.foo2();
        return "users";
    }

    @ModelAttribute("user")
    public UserForm getUserForm() {
        return new UserForm();
    }

}
