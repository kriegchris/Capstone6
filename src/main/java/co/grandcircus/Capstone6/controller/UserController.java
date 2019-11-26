package co.grandcircus.Capstone6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.Capstone6.model.Task;
import co.grandcircus.Capstone6.model.User;
import co.grandcircus.Capstone6.repo.TaskRepo;
import co.grandcircus.Capstone6.repo.UserRepo;

@Controller
public class UserController {

	@Autowired
	UserRepo uRepo;
	
	@Autowired
	TaskRepo tRepo;
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/login")
	public ModelAndView userDash(User user) {
			User userInfo = uRepo.findByEmail(user.getEmail());
			if (userInfo != null) {
				if (user.getPassword().equals(userInfo.getPassword())) {
					ModelAndView mv = new ModelAndView("task-list");
					mv.addObject("message", "Welcome, " + userInfo.getName());
					mv.addObject("id", userInfo.getUserId());
					List<Task> tasks = userInfo.getTasks();
					mv.addObject("list", tasks);
					return mv;
				} else {
					ModelAndView mv = new ModelAndView("sorry");
					mv.addObject("message", "Password is invalid. Please try again");
					mv.addObject("goBack", "<a href='/' class='btn btn-primary'>Go back</a>");
					return mv;
				}
			} else {
				ModelAndView mv = new ModelAndView("sorry");
				mv.addObject("message", "Name not found. Either register a new account or please try again");
				mv.addObject("goBack", "<a href='/' class='btn btn-primary'>Go back</a>");
				mv.addObject("register", "<a href='/register' class='btn btn-primary'>Register New User</a>");
				return mv;
			}
	}
	
	@RequestMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("register");
	}
	
	@RequestMapping("/add-user")
	public ModelAndView addUser(User user) {
		uRepo.save(user);
		ModelAndView mv = new ModelAndView("redirect:/");
		mv.addObject("login", "<span style='color:red'>Please login with your new username and password</span>");
		return mv;
	}
	
}
