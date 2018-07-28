package com.todomodule.DAO;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Types;
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
		   String SQL = "select * from TODO";
		   todos =  jdbcTemplateObject.query(SQL,  new TodoMapper());
		   //System.out.println(jdbcTemplateObject.query(SQL,  new TodoMapper()));
		 	//System.out.println("todos===="+todos );
		   return todos;
	   }

	   public void create(String name, String desc, Date targetDate, boolean isDone) {
		   String ssql = "SELECT count(*) FROM TODO";
		int size = jdbcTemplateObject.queryForObject(ssql, Integer.class);
		size++;
		System.out.println("size======"+size);
		System.out.println("Created Record Name = " + name + " ==desc = " + desc+"==targetDate"+targetDate+"==isDone"+isDone);
		      String SQL = "insert into table TODO (id, user, desce, targetDate, isDone) values (?, ?, ?, ?, ?)";
		      jdbcTemplateObject.update( SQL, size, name, desc, targetDate, isDone);
		      System.out.println("Created Record Name = " + name + " ==desc = " + desc+"==targetDate"+targetDate+"==isDone"+isDone);
		      return;
		   }
	   
	   
	   
	   public void delete(Integer id) {
		      String SQL = "delete from TODO where id = ?";
		      jdbcTemplateObject.update(SQL, id);
		      System.out.println("Deleted Record with ID = " + id );
		      return;
		   }
	   
	   public void update(Integer id, String desc, Date targetDate, boolean isDone){
		   System.out.println(desc+ targetDate+ isDone+ id);
		      String SQL = "update table todo set desce = ?,targetDate = ?, isDone = ? where ID = ?";
		     /* int[] types = {Types.VARCHAR, Types.TIMESTAMP,Types.VARCHAR, Types.SMALLINT};
		      jdbcTemplateObject.update(SQL, new Object[] {desc, targetDate, isDone, id}, types);*/
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
