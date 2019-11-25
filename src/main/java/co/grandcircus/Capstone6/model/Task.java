package co.grandcircus.Capstone6.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tasks")
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer taskId;
	private String description;
	private String date;
	private boolean completed;
	
	@ManyToOne
	private User user;
	
	//Constructors
	public Task() {
	}
	
	public Task(Integer taskId, String description, String date, boolean completed) {
		this.taskId = taskId;
		this.description = description;
		this.date = date;
		this.completed = completed;
	}
	
	public Task(String description, String date) {
		this.description = description;
		this.date = date;
	}

	//Getter and setter methods
	public Integer getTaskId() {
		return taskId;
	}
	
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public boolean isCompleted() {
		return completed;
	}
	
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	//Overloaded toString()
	@Override
	public String toString() {
		return "taskId=" + taskId + "&description=" + description + "&date=" + date + "&completed=" + completed;
	}
	
}
