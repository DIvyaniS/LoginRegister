package com.hellokoding.auth.web;

import com.hellokoding.auth.model.SendMoney;
import com.hellokoding.auth.model.User;
import com.hellokoding.auth.model.UserCardInfo;
import com.hellokoding.auth.service.AddCardService;
import com.hellokoding.auth.service.AddMoneyService;
import com.hellokoding.auth.service.SecurityService;
import com.hellokoding.auth.service.SendMoneyService;

import com.hellokoding.auth.service.UserService;
import com.hellokoding.auth.validator.UserValidator;

import java.security.Principal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	
	@Autowired
    private UserService userService;
    
    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private SendMoneyService sendMoneyService;
    @Autowired
    private AddMoneyService addMoneyService;
    
    @Autowired
    private AddCardService addCardService;

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
    public String viewSendMoneyPage(@ModelAttribute("sendForm") SendMoney sendForm, Model model) {
        //userValidator.validate(userForm, bindingResult);

        /*if (bindingResult.hasErrors()) {
            return "registration";
        }*/

        //userService.save(userForm);
    	
    	sendMoneyService.save(sendForm);
        

        return "redirect:/welcome";
    }
    
    @RequestMapping(value="/addmoney", method = RequestMethod.GET)
    public String showAddMoneyPage(ModelMap model){
        return "addmoney";
    }

    @RequestMapping(value="/addMoney" ,method= RequestMethod.GET)
    public String showAddMoneyPage(ModelMap model, @RequestParam(name="amount") String amount, @RequestParam(name="card") String card){

        //boolean isValidUser = service.validateUser(name, password);

        //if (!isValidUser) {
        //    model.put("errorMessage", "Invalid Credentials");
          //  return "login";
        //}
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();              
    	String name = auth.getName();
    	User user =userService.findByUsername(name);
        addMoneyService.update(user.getUsername(),Long.parseLong(amount)+user.getBalance());
    	
    	
        return "redirect:/welcome";
    }
    @RequestMapping(value="/checkbal",method = RequestMethod.GET)
    public String viewCheckBalancePage(Model model)
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	User user = userService.findByUsername(auth.getName());
    	model.addAttribute("balance",user.getBalance().toString());
    	return "checkbal";
    	
    }
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String viewProfilePage(Model model) {
    	// User user = userService.findByUsername(principal.getName());
       // model.addAttribute("user", user);
    	//String out = "abcd";
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();              
    	String name = auth.getName();
    	User user =userService.findByUsername(name);
    	String out = user.getUsername();
    	model.addAttribute("out",user);
    	//model.addAttribute("bal",user.getBalance());
    	String arr[]=user.getRoles().toArray(new String[0]);
    	
    	model.addAttribute("role",Arrays.toString(arr));
        return "profile";
    }
    @RequestMapping(value = "/addcard",method= RequestMethod.GET)
    public String viewAddCardPage(Model model)
    {
    	return "addcard";
    }
    @RequestMapping(value = "/addcard",method= RequestMethod.POST)
    public String viewAddCardPage(ModelMap model, @RequestParam String bank, @RequestParam String card)
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	User user = userService.findByUsername(auth.getName());
    	UserCardInfo userCardInfo = new UserCardInfo();
    	userCardInfo.setBank_name(bank);
    	userCardInfo.setCardnumber(card);
    	userCardInfo.setUser(user);
    	addCardService.save(userCardInfo);
    	return "addcard";
    }
}
