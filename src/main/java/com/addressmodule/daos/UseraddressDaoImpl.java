package com.addressmodule.daos;
 
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.addressmodule.entities.useraddress;
import com.usersmodule.entities.user;
 

 
@Repository
@Transactional
public class UseraddressDaoImpl implements UseraddressDao {
 
    @Autowired
    SessionFactory session;
 
    public boolean saveOrUpdate(useraddress useraddress) {
        System.out.println("UseraddressDaoImpl........useraddress.userid="+useraddress.getUserid() );
        session.getCurrentSession().saveOrUpdate(useraddress);
        return true;
    }
 
    @SuppressWarnings("unchecked")
	public List<useraddress> list() {
        return session.getCurrentSession().createQuery("from user").list();
    }
	public List<useraddress> load(int addrid) {
		// return (useraddress)session.getCurrentSession().get(useraddress.class, new Integer(addrid));
		
		System.out.println(addrid);
		
		String hql = "from useraddress where userid in :keyword";		 
		
		 Query query = session.getCurrentSession().createQuery(hql);
		   query.setParameter("keyword",addrid );
		 
		return (List<useraddress>) query.list();
	}
	
	public useraddress loadAddress(int id) {
		return (useraddress)session.getCurrentSession().get(useraddress.class, new Integer(id));
	}
		 
    public boolean delete(useraddress useraddress) {
        try {
            session.getCurrentSession().delete(useraddress);
        } catch (Exception ex) {
            return false;
        }
 
        return true;
    }

	
	/*public user loadwithname(String useraddress) {
		System.out.println(useraddress);
		
		String hql = "from useraddress where username like :keyword";		 
		
		 Query query = session.getCurrentSession().createQuery(hql);
		   query.setParameter("keyword", "%" + username + "%");
		 
		return (user) query.uniqueResult();
	}
*/


	
}