package com.usersmodule.services;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usersmodule.daos.UsersDao;

import com.usersmodule.entities.user;
 
@Service
public class UsersServiceImpl implements UsersService {
 
    @Autowired
    UsersDao userDao;
 
    public boolean saveOrUpdate(user user) {
        return userDao.saveOrUpdate(user);
    }
 
    public List<user> list() {
        
        return userDao.list();
    }
    
    public user load(int id) {
    	return userDao.load(id);
    }
 
    public boolean delete(user user) {
        
        return userDao.delete(user);
    }

	
	public user loadwithname(String username) {
		return userDao.loadwithname(username);
	}
 
}