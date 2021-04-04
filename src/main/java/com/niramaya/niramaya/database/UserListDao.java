package com.niramaya.niramaya.database;

import org.springframework.data.jpa.repository.JpaRepository;
import com.niramaya.niramaya.entities.User;
public interface UserListDao extends JpaRepository<User,String>{
	
}
