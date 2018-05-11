package com.todomodule.DAO;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TodoJDBCTemplate {

	private static DataSource dataSource;
	   private static JdbcTemplate jdbcTemplateObject;
	  public List todos = new ArrayList();   
	 
	   public void setDataSource(DataSource dataSource) {
		 //  System.out.println("dataSource==="+dataSource);
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	    //  System.out.println("jdbcTemplateObject==="+jdbcTemplateObject);
	   }
	   
	   	  
	
	   
	   public List retrieveTodos(){	
		   String SQL = "select * from springdb.TODO";
		   todos =  jdbcTemplateObject.query(SQL,  new TodoMapper());
		   //System.out.println(jdbcTemplateObject.query(SQL,  new TodoMapper()));
		 	//System.out.println("todos===="+todos );
		   return todos;
	   }

	   public void create(String name, String desc, Date targetDate, boolean isDone) {
		   String ssql = "SELECT count(*) FROM springdb.TODO";
		int size = jdbcTemplateObject.queryForObject(ssql, Integer.class);
		size++;
		//System.out.println("size======"+size);
		      String SQL = "insert into springdb.TODO (id, user, desce, targetDate, isDone) values (?, ?, ?, ?, ?)";
		      jdbcTemplateObject.update( SQL, size, name, desc, targetDate, isDone);
		      System.out.println("Created Record Name = " + name + " ==desc = " + desc+"==targetDate"+targetDate+"==isDone"+isDone);
		      return;
		   }
	   
	   
	   
	   public void delete(Integer id) {
		      String SQL = "delete from springdb.TODO where id = ?";
		      jdbcTemplateObject.update(SQL, id);
		      System.out.println("Deleted Record with ID = " + id );
		      return;
		   }
	   
	   public void update(Integer id, String desc, Date targetDate, boolean isDone){
		      String SQL = "update springdb.TODO set desce = ?,targetDate = ?, isDone = ? where id = ?";
		      jdbcTemplateObject.update(SQL, desc, targetDate, isDone, id);
		      System.out.println("Updated Record with ID = " + id );
		      return;
		   }
	   
	   /*public Student getStudent(Integer id) {
	      String SQL = "select * from Student where id = ?";
	      Student student = jdbcTemplateObject.queryForObject(SQL, 
	         new Object[]{id}, new StudentMapper());
	      
	      return student;
	   }

	   
	 
	  */
	
}
