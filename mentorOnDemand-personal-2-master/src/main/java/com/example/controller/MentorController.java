package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.MentorDao;
import com.example.dao.UserDao;
import com.example.dao.requestTableDao;
import com.example.models.User;

@Controller
@Scope("session")
public class MentorController {
	@Autowired
	UserController usercontroller;
	@Autowired
	MentorDao mentordao;
	@Autowired
	requestTableDao rtdao;
	@Autowired
	UserDao userdao;

	@RequestMapping(value = "/listRequest",method = RequestMethod.GET)
	public ModelAndView listRequests() {
		int mentorid = usercontroller.getId();
		List<String> studentNameList = new ArrayList<>();
		List<Integer> studentIdList = mentordao.studentList(mentorid);

		for (int i = 0; i < studentIdList.size(); i++) {
			String name = mentordao.studentName(studentIdList.get(i));
			studentNameList.add(name);
		}
		//System.out.println(studentNameList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mentor-notification-page");
		mv.addObject("studentList",studentNameList);
		return mv;
	}
   
	@RequestMapping(value="/requestAcceptAction")
	public String acceptRequest(@RequestParam("name") String studentName)
	{
		int studentId = mentordao.StudentId(studentName);
		int mentorId = usercontroller.getId();
		rtdao.setAcceptStatus(studentId,mentorId);	
		return "mentor-landing-page";
	}
	
	@RequestMapping(value="/requestIgnoreAction")
	public String ignoreRequest(@RequestParam("name") String studentName)
	{
		int studentId = mentordao.StudentId(studentName);
		int mentorId = usercontroller.getId();
		rtdao.setIgnoreStatus(studentId,mentorId);
		return "mentor-landing-page";

	}
	@RequestMapping(value="/updateSkills",method = RequestMethod.GET)
	public String updateSkillForm(Model model)
	{
		int mentorid = usercontroller.getId();
		User mentordetails = userdao.findByid(mentorid);
		model.addAttribute("mentor",mentordetails);
		return "update-skills";
	}
	@RequestMapping(value="/updateSkills",method = RequestMethod.POST)
	public String updateSkill(@ModelAttribute("mentor")User mentor)
	{   int mentorid = usercontroller.getId();
	    User mentordetails = userdao.findByid(mentorid);
		mentor.setName(mentordetails.getName());
		mentor.setEmail(mentordetails.getEmail());
		mentor.setMobileno(mentordetails.getMobileno());
		mentor.setPassword(mentordetails.getPassword());
		mentor.setUserType(mentordetails.getUserType());
		mentor.setFacilities(mentordetails.getFacilities());
		mentor.setLinkedin_URL(mentordetails.getLinkedin_URL());
		mentor.setTechnologies(mentordetails.getTechnologies());
		mentor.setTimezone(mentordetails.getTimezone());
		mentor.setAvailable_date(mentordetails.getAvailable_date());
		
		userdao.save(mentor);
		return "mentor-landing-page";
	}
}
