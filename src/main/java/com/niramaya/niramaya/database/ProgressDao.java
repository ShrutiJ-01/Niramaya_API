package com.niramaya.niramaya.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niramaya.niramaya.entities.UserProgressLog;

public interface ProgressDao extends JpaRepository<UserProgressLog,String> {

}
