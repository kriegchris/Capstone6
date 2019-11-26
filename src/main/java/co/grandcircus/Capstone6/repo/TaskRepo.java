package co.grandcircus.Capstone6.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.Capstone6.model.Task;

public interface TaskRepo extends JpaRepository<Task, Integer> {
	Task findByTaskId(Integer id);
}
