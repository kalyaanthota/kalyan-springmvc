package com.usersmodule.daos;
 
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.usersmodule.entities.user;
 

 
@Repository
@Transactional
public class UsersDaoImpl implements UsersDao {
 
    @Autowired
    SessionFactory session;
 
    public boolean saveOrUpdate(user user) {
        
        session.getCurrentSession().saveOrUpdate(user);
        return true;
    }
 
    @SuppressWarnings("unchecked")
	public List<user> list() {
        return session.getCurrentSession().createQuery("from user").list();
    }
	public user load(int id) {
		return (user)session.getCurrentSession().get(user.class, new Integer(id));
	}
		 
    public boolean delete(user user) {
        try {
            session.getCurrentSession().delete(user);
        } catch (Exception ex) {
            return false;
        }
 
        return true;
    }

	
	public user loadwithname(String username) {
		System.out.println(username);
		
		String hql = "from user where username like :keyword";		 
		
		 Query query = session.getCurrentSession().createQuery(hql);
		   query.setParameter("keyword", "%" + username + "%");
		 
		return (user) query.uniqueResult();
	}
}