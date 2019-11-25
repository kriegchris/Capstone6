package co.grandcircus.Capstone6.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.Capstone6.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	//gets user info at login
	User findByEmail(String email);
	
}
