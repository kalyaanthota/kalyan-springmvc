package com.addressmodule.services;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addressmodule.daos.UseraddressDao;
import com.addressmodule.entities.useraddress;


 
@Service
public class AddressServiceImpl implements AddressService {
 
    @Autowired
    UseraddressDao UseraddressDao;
 
    public boolean saveOrUpdate(useraddress useraddress) {
        return UseraddressDao.saveOrUpdate(useraddress);
    }
 
    public List<useraddress> list() {
        
        return UseraddressDao.list();
    }
    
    public List<useraddress> load(int addrid) {
    	return UseraddressDao.load(addrid);
    }
 
    public useraddress loadAddress(int addrid) {
    	return UseraddressDao.loadAddress(addrid);
    }
    
    public boolean delete(useraddress useraddress) {
        
        return UseraddressDao.delete(useraddress);
    }

	
	/*public user loadwithname(String username) {
		return userDao.loadwithname(username);
	}*/
 
}