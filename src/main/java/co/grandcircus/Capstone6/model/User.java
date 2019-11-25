package co.grandcircus.Capstone6.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	private String name;
	private String email;
	private String password;
	
	@OneToMany(mappedBy="user", orphanRemoval=true)
	private List<Task> tasks = new ArrayList<>();
	
	//Constructor
	public User() {
	}
	
	public User(Integer userId, String name, String email, String password, List<Task> tasks) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.tasks = tasks;
	}
	
	public User(String name, String email, String password, List<Task> tasks) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.tasks = tasks;
	}
	
	//Getter and Setter methods
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Task> getTasks(){
		return tasks;
	}
	
	//Overloaded toString()
	@Override
	public String toString() {
		return "userId=" + userId + "&email=" + email + "&password=" + password;
	}

}
