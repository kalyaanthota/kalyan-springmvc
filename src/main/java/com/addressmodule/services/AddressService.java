package com.addressmodule.services;
 
import java.util.List;

import com.addressmodule.entities.useraddress;
import com.usersmodule.entities.*;
 
public interface AddressService {
    public boolean saveOrUpdate(useraddress useraddress);
 
    public List<useraddress> list();
    
    public List<useraddress> load(int addrid) ;
    public useraddress loadAddress(int addrid) ;
    
  //  public useraddress loadwithname(String username) ;
 
    public boolean delete(useraddress useraddress);
}