package com.niramaya.niramaya.database;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;


public class AbstractDao {
	@Autowired
    private Environment env;
	
  protected MongoDatabase db;
  protected MongoCollection<Document> usersCollection;

  public AbstractDao() {
    try {
    	String connectionUri=env.getProperty("spring.data.mongodb.uri");
        String databaseName = env.getProperty("spring.data.mongodb.database");
       db = MongoClients.create(connectionUri).getDatabase(databaseName);
      usersCollection = db.getCollection("users");
      System.out.println("Successfully connected");
    } catch (Exception e) {
    	System.out.print(e);
      this.db = null;
    }
  }
}