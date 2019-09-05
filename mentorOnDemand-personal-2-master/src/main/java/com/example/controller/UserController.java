package com.example.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.UserDao;
import com.example.dao.requestTableDao;
import com.example.models.Login;
import com.example.models.RequestTable;
import com.example.models.User;
import com.example.service.LoginService;

@Controller
@Scope("session")
public class UserController {
	@Autowired
	LoginService loginservice;
    @Autowired
    UserDao userdao;
    @Autowired
    requestTableDao requesttabledao;
    private HttpSession session = null;
	@RequestMapping(value = "/loginUser", method = RequestMethod.GET)
	public ModelAndView loginPage(ModelAndView model) {

		model = new ModelAndView("login");
		Login login = new Login();
		model.addObject("login", login);
		return model;
	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public ModelAndView loginPagepost(Login login,HttpServletRequest request) throws ClassNotFoundException, SQLException {
		ModelAndView model = null;
        User user = new User();
        
        
		if (login.getEmail().equals("Admin@gmail.com") && login.getPassword().equals("admin")) {
			System.out.println("Success Login ADMIN");
			model = new ModelAndView("admin-landing-page");

		} else {
			System.out.println(login.getEmail());
			System.out.println(login.getPassword());
			String isValidUser = loginservice.isValidUser(login.getEmail(), login.getPassword());

			if (isValidUser.equals("User")) {
			
				System.out.println("Success Login");
				int userid=loginservice.obtainUserid(login.getEmail());
				session=request.getSession();
				session.setAttribute("userid", userid);
				System.out.println(userid);
				model = new ModelAndView("user-landing-page1");
			} 
			else if(isValidUser.equals("Mentor"))
			{
				int mentorid=loginservice.obtainUserid(login.getEmail());
				session=request.getSession();
				session.setAttribute("mentorid",mentorid);
				model = new ModelAndView("mentor-landing-page");
			}
			else {

				model = new ModelAndView("login");
				model.addObject("login", login);

			}
			
		}

		return model;
	}
	
	@RequestMapping(value="/registerUser",method = RequestMethod.GET)
	public String registerPage(ModelMap model)
	{
		User user = new User();
		model.addAttribute("user", user);
		return "userRegister";
	}
	@RequestMapping(value="/registerUser",method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user")User user,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("user",user);
			return "userRegister";
		}
		user.setUserType("User");
		userdao.save(user);
		return "redirect:/loginUser";
	}
	
	@RequestMapping(value="/registerMentor",method = RequestMethod.GET)
	public String registerMentor(Model model)
	{
		User user = new User();
		model.addAttribute("mentor",user);
		return "mentorRegister";
	}
	@RequestMapping(value="/registerMentor",method = RequestMethod.POST)
	public String insertMentor(@Valid @ModelAttribute("mentor")User user,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("mentor",user);
			return "mentorRegister";
		}
		user.setUserType("Mentor");
		userdao.save(user);
		return "redirect:/loginUser";
	}
@RequestMapping(value="/user-landing-page")
public String viewUserPage()
{
	return "user-landing-page1";
}
@RequestMapping(value="/search",method = RequestMethod.POST)
public ModelAndView viewCourses(@RequestParam("searchValue")String searchvalue)
{
	//System.out.println(searchvalue);
	ModelAndView mv = new ModelAndView();
	mv.setViewName("user-landing-page");
	mv.addObject("mentorlist",userdao.mentorsList(searchvalue));
	return mv;
	
}

@RequestMapping(value="/sendRequest")
public String sendRequest(@RequestParam("userid")int userid,@RequestParam("mentorid") int mentorid,HttpSession session,HttpServletRequest request)
{
	RequestTable rt = new RequestTable();
	String mentorname = userdao.getMentorName(mentorid);
	//System.out.println(mentorname);
	rt.setUserId(userid);
	rt.setMentorid(mentorid);
	rt.setStatus("requested");
	rt.setMentorName(mentorname);
	requesttabledao.save(rt);
	return "user-landing-page1";
}

@RequestMapping(value="/notificationsList")
public ModelAndView viewNotificationList(HttpServletRequest request,Model model)
{
	session=request.getSession();
	int userId = (int) session.getAttribute("userid");
	/*List<Integer> mentorids = new ArrayList<>();
	 mentorids = (List<Integer>)requesttabledao.getMentor(userId);
	List<String> status_list = new ArrayList<>();
	for(int i=0;i<mentorids.size();i++)
	{
	String status = requesttabledao.getStatus1(userId, mentorids.get(i));
	status_list.add(status);
	}
	model.addAttribute("statuslist",status_list);*/
	ModelAndView mv = new ModelAndView();
	mv.setViewName("user-notification-page");
	mv.addObject("list",requesttabledao.findByuserId(userId));
	return mv;
	
}


public int getId()
 {
	
	 
	 int mentorId = (int) session.getAttribute("mentorid");
	 //System.out.println(mentorId);
	// int userId = (int) session.getAttribute("userid");
	 return mentorId;
 }


}
