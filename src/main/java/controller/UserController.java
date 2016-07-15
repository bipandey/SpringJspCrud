package controller;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import model.Login;
import model.UserDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDao;

@Controller
public class UserController {

	@Autowired
	private UserDao dao;
	//@Autowired
	//private Login login;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLogin() {

		ModelAndView model = new ModelAndView("view/login");
		return model;
	}


	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request ,@Valid @ModelAttribute("userDetail") UserDetail userDetail,BindingResult result) {
		ModelAndView model;
		if(result.hasErrors()){
			model=new ModelAndView("view/admin");
			model.addObject("msg", "Failed adding User.provide all required fields");
			return model;
		}
		if (dao.addUser(userDetail)) {
			String userRole=request.getParameter("userRole");
			model=new ModelAndView("view/viewUser");
			model.addObject("msg", "User Added Successfully");
			model.addObject("userDetail", dao.getUserDetail());
			model.addObject("userRole", userRole);
			return model;
	
		
		} else {

			model = new ModelAndView("view/admin");
			model.addObject("msg", "failed to add user");
			return model;
		}
	}
	
	@RequestMapping(value="/addUser",method=RequestMethod.GET)
	public ModelAndView addUser(HttpServletRequest request){
		ModelAndView model=new ModelAndView("view/admin");
		String userRole=request.getParameter("id");
		model.addObject("userRole", userRole);
		return model;
		
	}
	
	
	@RequestMapping(value="/viewUser" , method=RequestMethod.GET)
	public ModelAndView viewUser(HttpServletRequest request){
		//UserDetail userDetail=new UserDetail();
		ModelAndView model=new ModelAndView("view/viewUser");
		model.addObject("userDetail", dao.getUserDetail());
		//model.addObject("userName", dao.getUserDetail(userDetail));
		
		//Login login =new Login();
		
		model.addObject("userRole" ,request.getParameter("id"));
		return model;
	}
	
	@RequestMapping(value="/deleteUser",method=RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request){
		String userName=request.getParameter("id1");
		String userRole=request.getParameter("id2");
		dao.deleteUser(userName);
		ModelAndView model=new ModelAndView("view/viewUser");
		model.addObject("userName", userName);
		model.addObject("userRole", userRole);
		model.addObject("msg", "User Deleted with UserName:");
		//UserDetail userDetail=new UserDetail();
		model.addObject("userDetail", dao.getUserDetail());
		return model;
		
		}
	
	@RequestMapping(value="/editUser",method=RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request){
		ModelAndView model=new ModelAndView("view/editUser");
		String userName=request.getParameter("id1");
		String userRole=request.getParameter("id2");
		model.addObject("userName", userName);
		model.addObject("userRole", userRole);
		dao.getUserDetailForEdit(userName);
		model.addObject("userDetail", dao.getUserDetailForEdit(userName));
		return model;
		
	}
	
	/*@RequestMapping(value="/updateUserDetail" ,method=RequestMethod.POST)
	public ModelAndView updateUser(@ModelAttribute("userDetail") UserDetail userDetail  ){

	
		dao.updateUser(userDetail);
		ModelAndView model=new ModelAndView();
		model=new ModelAndView("view/aaa");
		//model.addObject("userDetail", dao.getUserDetail());
		//List<UserDetail> abc=dao.getUserDetail();
		//model.addObject(abc);
		return model;

	}*/
	
	@RequestMapping(value="/updateUserDetail" , method=RequestMethod.POST)
	public ModelAndView updateUserDetail(@ModelAttribute("userDetail") UserDetail userDetail,HttpServletRequest request){
		
		
		dao.updateUser(userDetail);
		ModelAndView model=new ModelAndView("view/viewUser");
		model.addObject("userDetail", dao.getUserDetail());
		model.addObject("msg", "user updated with user name:");
		model.addObject("userName", userDetail.getUserName());
		String userRole=request.getParameter("userRole");
		model.addObject("userRole", userRole);
		
		
		return model;
		
		
		
	}
	
	

}
