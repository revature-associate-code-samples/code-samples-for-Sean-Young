package com.fanatics.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.fanatics.models.User;
import com.fanatics.repository.UserRepository;

@Service("userService")
public class UserService {
	/**
	 * 
	 */
	public UserService() {
	}

	public List<User> getAll() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserRepository repo = (UserRepository) context.getBean(UserRepository.class);
		List<User> user = repo.findAll();

		return user;
	}

	public User getById(int id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserRepository repo = (UserRepository) context.getBean(UserRepository.class);
		User user = repo.findOne(id);

		return user;
	}

	public User getByUsername(String username) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserRepository uRepo = (UserRepository) context.getBean(UserRepository.class);
		User u = uRepo.findByUsernameLikeIgnoreCase(username);
		return u;
	}

	public User validateUser(User u, String password) {
		if (u.getPassword().equals(password)) {
			return u;
		} else {
			return null;
		}
	}

	public User newUser(User u) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserRepository repo = (UserRepository) context.getBean(UserRepository.class);
		System.out.println(u);
		u.setIsAdmin(0);
		u.setIsVerified(0);
		u.setJoinDate(new Timestamp(System.currentTimeMillis()));
		System.out.println(u);
		User user = repo.save(u);
		System.out.println(user);
		return user;
	}

}
