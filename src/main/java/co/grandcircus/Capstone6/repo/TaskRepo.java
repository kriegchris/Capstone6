package co.grandcircus.Capstone6.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.grandcircus.Capstone6.model.Task;

public interface TaskRepo extends JpaRepository<Task, Integer> {
	
//	@Query("select * from Task where taskId=?")
//	List<Task> searchByUser(Integer id);
}
