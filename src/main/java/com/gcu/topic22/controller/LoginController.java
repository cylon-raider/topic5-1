package com.gcu.topic22.controller;

import com.gcu.topic22.business.OrdersBusinessServiceInterface;
import com.gcu.topic22.business.SecurityBusinessService;
import com.gcu.topic22.model.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private SecurityBusinessService security;

    @Autowired
    private OrdersBusinessServiceInterface service;

    @GetMapping("/")
    public ModelAndView display(Model model) {
        ModelAndView mv = new ModelAndView();
        LoginModel loginModel = new LoginModel();
        mv.addObject("title", "Login Form");
        mv.addObject("loginModel", loginModel);
        mv.setViewName("login");
        return mv;

    }
    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
        // Check for validation errors
        if(bindingResult.hasErrors())
        {
            model.addAttribute("title", "Login Form");
            return "login";
        }
        ModelAndView mv = new ModelAndView();
        service.test();
        security.authenticate(loginModel.getUsername(), loginModel.getPassword());
        model.addAttribute("title", "My Orders");
        model.addAttribute("orders", service.getOrders());

        return "orders";

    }

}
