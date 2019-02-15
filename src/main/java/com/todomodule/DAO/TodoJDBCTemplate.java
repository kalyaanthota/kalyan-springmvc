package com.todomodule.DAO;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Types;
import java.text.SimpleDateFormat;
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
		      String SQL = "insert into TODO (id, user, desce, targetDate, isDone) values (?, ?, ?, ?, ?)";
		      jdbcTemplateObject.update( SQL, size, name, desc, targetDate, isDone);
		      System.out.println("Created Record Name = " + name + " ==desc = " + desc+"==targetDate"+targetDate+"==isDone"+isDone);
		      return;
		   }
	   
	   
	   
	   public void delete(Integer id) {
		      String SQL = "delete from todo where id = ?";
		      int[] types = {Types.TINYINT};
		      jdbcTemplateObject.update(SQL, new Object[]{id}, types, new TodoMapper());
		      System.out.println("Deleted Record with ID = " + id );
		      return;
		   }
	   
	   public void update(Integer id, String desc, Date targetDate, boolean isDone){
		   
		 String targetDateS = new SimpleDateFormat("dd/MM/yyyy").format(targetDate);
		   
    		   System.out.println(desc+ targetDateS+ isDone+ id);
		   
		      //String SQL = "update PUBLIC.TODO set PUBLIC.TODO.DESCE = ?, PUBLIC.TODO.ISDONE = ?, PUBLIC.TODO.TARGETDATE = ?  where 'PUBLIC.TODO.ID' = ?";
		      
		      String SQL = "UPDATE public.todo SET 'DESCE'="+desc+", 'ISDONE'="+isDone+", 'TARGETDATE'="+targetDateS+", 'user'="+desc+" WHERE 'ID'="+id+"";
		      
		      int[] types = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,Types.VARCHAR};
		      
		    // jdbcTemplateObject.update(SQL, new Object[] {desc,  isDone, targetDateS, id}, types);
		     
		     //jdbcTemplateObject.update(SQL, desc, targetDate, isDone, id );
		      
		     jdbcTemplateObject.update(SQL);
		     
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
