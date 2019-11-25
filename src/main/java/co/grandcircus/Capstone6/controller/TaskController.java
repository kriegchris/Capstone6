package co.grandcircus.Capstone6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.Capstone6.model.Task;
import co.grandcircus.Capstone6.model.User;
import co.grandcircus.Capstone6.repo.TaskRepo;
import co.grandcircus.Capstone6.repo.UserRepo;

@Controller
public class TaskController {

	@Autowired
	TaskRepo tRepo;
	
	@Autowired
	UserRepo uRepo;
	
	@RequestMapping("/add-task")
	public ModelAndView addTask(@RequestParam("userId") Integer Id, Task task) {
		User user = uRepo.findByUserId(Id);
		ModelAndView mv = new ModelAndView("task-list", "message", "Welcome, " + user.getName());
		user.getTasks().add(task);
		task.setUser(user);
		tRepo.save(task);
		mv.addObject("list", user.getTasks());
		return mv;
	}
}
