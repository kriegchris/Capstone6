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
		ModelAndView mv = new ModelAndView("task-list");
			User userInfo = uRepo.findByEmail(user.getEmail());
			if (userInfo != null) {
				if (user.getPassword().equals(userInfo.getPassword())) {
					mv.addObject("message", "Welcome, " + userInfo.getName());
					List<Task> tasks = tRepo.findAll();
					mv.addObject("list", tasks);
				} else {
					mv.addObject("message", "Password is invalid. Please try again");
					mv.addObject("goBack", "<a href='/' class='btn btn-primary'>Go back</a>");
				}
			} else {
				mv.addObject("message", "Name not found please try again");
				mv.addObject("goBack", "<a href='/' class='btn btn-primary'>Go back</a>");
				mv.addObject("register", "<a href='/register' class='btn btn-primary'>Register New User</a>");
			}
		return mv;
	}
	
}
