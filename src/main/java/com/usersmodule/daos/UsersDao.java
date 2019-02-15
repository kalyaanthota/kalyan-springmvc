package com.usersmodule.daos;
 
import java.util.List;
 

import com.usersmodule.entities.user;
 
public interface UsersDao {
    public boolean saveOrUpdate(user user);
 
    public List<user> list();
    public user load(int id); 
    public boolean delete(user user);

	public user loadwithname(String username);
}