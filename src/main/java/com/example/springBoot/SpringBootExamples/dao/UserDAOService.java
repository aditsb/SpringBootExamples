package com.example.springBoot.SpringBootExamples.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.springBoot.SpringBootExamples.model.UserBean;
@Component
public class UserDAOService {

	public static List<UserBean> users = new ArrayList<UserBean>();
	private static int userCount = 4;
	static {
		users.add(new UserBean(1, "Adam", new Date()));
		users.add(new UserBean(2, "Mark", new Date()));
		users.add(new UserBean(3, "Steve", new Date()));
		users.add(new UserBean(4, "Glenn", new Date()));
		users.add(new UserBean(5, "Iasn", new Date()));

	}

	public List<UserBean> findUsers() {
		return users;

	}

	public UserBean findOne(int id) {
		for (UserBean userBean : users) {
			if (id == userBean.getId()) {
				return userBean;
			}
		}
		return null;

	}

	public UserBean SaveUser(UserBean user) {
		if (user.getId() == 0) {
			user.setId(++userCount);
		}

		users.add(user);
		
		return user;
	}

	public UserBean deletUser(int id) {
		for (Iterator<UserBean> iterator = users.iterator(); iterator.hasNext();) {
			UserBean userBean = (UserBean) iterator.next();
			if(userBean.getId()==id){
				iterator.remove();
				
				return userBean;
			}
			
		}
		// TODO Auto-generated method stub
		return null;
	}
}
