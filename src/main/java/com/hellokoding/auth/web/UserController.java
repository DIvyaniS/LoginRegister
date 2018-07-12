package com.hellokoding.auth.web;

import com.hellokoding.auth.model.SendMoney;
import com.hellokoding.auth.model.User;
import com.hellokoding.auth.service.SecurityService;
import com.hellokoding.auth.service.SendMoneyService;
import com.hellokoding.auth.service.UserInfoService;
import com.hellokoding.auth.service.UserService;
import com.hellokoding.auth.validator.UserValidator;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	Principal principal;
	@Autowired
	private User user;
    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private SendMoneyService sendMoneyService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
    /*@RequestMapping(value = "/welcome", method = RequestMethod.POST)
    public String welcome(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model)
    {
    	
    }*/
    @RequestMapping(value = "/sendmoney", method = RequestMethod.GET)
    public String viewSendMoneyPage(Model model) {
    	model.addAttribute("sendForm", new SendMoney());
        
 
        
        return "sendmoney";
    }
 
  
    @RequestMapping(value = "/sendmoney", method = RequestMethod.POST)
    public String viewSendMoneyPage(@ModelAttribute("sendForm") SendMoney sendForm, BindingResult bindingResult, Model model) {
        //userValidator.validate(userForm, bindingResult);

        /*if (bindingResult.hasErrors()) {
            return "registration";
        }*/

        //userService.save(userForm);
    	sendMoneyService.save(sendForm);
        

        return "redirect:/welcome";
    }
    
    @RequestMapping(value = "/addmoney", method = RequestMethod.GET)
    public String viewAddMoneyPage(Model model) {
    	//model.addAttribute("balance");
        
 
        
        return "addmoney";
    }
 
  
    @RequestMapping(value = "/addmoney", method = RequestMethod.POST)
    public String viewAddMoneyPage(@RequestParam() String balance) {
        //userValidator.validate(userForm, bindingResult);

        /*if (bindingResult.hasErrors()) {
            return "registration";
        }*/

        //userService.save(userForm);
    	
    	userInfoService.updateBalance(principal.getName(),Long.parseLong(balance));
        

        return "redirect:/welcome";
    }
    @RequestMapping(value="/checkbal",method = RequestMethod.GET)
    public String viewCheckBalancePage(Model model)
    {
    	user = userService.findByUsername(principal.getName());
    	model.addAttribute("balance",user.getBalance().toString());
    	return "checkbal";
    	
    }
}
