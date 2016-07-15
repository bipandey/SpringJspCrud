package controller;

import javax.validation.Valid;

import model.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDao;

@Controller
public class LoginController {
	@Autowired
	private UserDao dao;
	//@Autowired
	
	//private Login login;

	@RequestMapping(value = "/submitLogin", method = RequestMethod.POST)
	public ModelAndView validateLogin(@Valid @ModelAttribute("login") Login login,BindingResult result) {
		ModelAndView model;
		
		if (result.hasErrors()){
			model=new ModelAndView("view/login");
			model.addObject("msg", "Login Failed !! Login Again");
			return model;
		}

		if (dao.isValidUser(login)) {
		
			model = new ModelAndView("view/new");
			model.addObject("userRole", login.getUserRole());
			model.addObject("userId", login.getUserId());
			
			return model;
		}

		else {
			model = new ModelAndView("view/login");
			model.addObject("msg", "Loogin failed Login again");
			return model;
		}

	}

}
