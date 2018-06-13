package com.addressmodule.daos;
 
import java.util.List;

import com.addressmodule.entities.useraddress;

 
public interface UseraddressDao {
    public boolean saveOrUpdate(useraddress useraddress);
 
    public List<useraddress> list();
    public List<useraddress> load(int addrid); 
    public useraddress loadAddress(int addrid); 
    public boolean delete(useraddress useraddress);

//	public useraddress loadwithname(String user);
}