package com.usersmodule.services;
 
import java.util.List;
import com.usersmodule.entities.*;
 
public interface UsersService {
    public boolean saveOrUpdate(user user);
 
    public List<user> list();
    
    public user load(int id) ;
    
    public user loadwithname(String username) ;
 
    public boolean delete(user user);
}