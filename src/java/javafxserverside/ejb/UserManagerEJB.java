/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxserverside.ejb;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafxserverside.entity.Department;
import javafxserverside.entity.Profile;
import javafxserverside.entity.User;
import javafxserverside.exception.CreateException;
import javafxserverside.exception.DeleteException;
import javafxserverside.exception.ReadException;
import javafxserverside.exception.UpdateException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * EJB class for managing User entity CRUD operations.
 * @author javi
 */
@Stateless
public class UserManagerEJB implements UserManagerEJBLocal {
    //logger for the class
    private static final Logger LOGGER =
            Logger.getLogger("javafxserverside");
    //Entity manager object
    @PersistenceContext
    private EntityManager em;

    @Override
    public User findUserByLogin(String login) throws ReadException {
        User user=null;
        try{
            LOGGER.info("UserManager: Finding user by login.");
            user=em.find(User.class, login);
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "UserManager: Exception Finding user by login:",
                    e.getMessage());
            throw new ReadException(e.getMessage());
        }
        if(user!=null) 
            LOGGER.log(Level.INFO,"UserManager: User found {0}",user.getLogin());
        else
            LOGGER.log(Level.INFO,"UserManager: No User found for login = {0}",login);
        return user;
    }
    
    @Override
    public List<User> findAllUsers() throws ReadException {
        List<User> users=null;
        try{
            LOGGER.info("UserManager: Reading all users.");
            users=em.createNamedQuery("findAllUsers").getResultList();
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "UserManager: Exception reading all users:",
                    e.getMessage());
            throw new ReadException(e.getMessage());
        }
        return users;
    }

    @Override
    public List<User> findUsersByProfile(Profile profile) throws ReadException {
        List<User> users=null;
        try{
            LOGGER.info("UserManager: Reading users by profile.");
            users=em.createNamedQuery("findUsersByProfile")
                     .setParameter("profile", profile)
                     .getResultList();
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "UserManager: Exception reading users by profile.",
                    e.getMessage());
            throw new ReadException(e.getMessage());
        }
        return users;
    }

    @Override
    public List<Department> findAllDepartments() throws ReadException{
        List<Department> departments=null;
        try{
            LOGGER.info("UserManager: Reading all departments.");
            departments=em.createNamedQuery("findAllDepartments").getResultList();
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "UserManager: Exception reading departments for users",
                    e.getMessage());
            throw new ReadException(e.getMessage());
        }
        return departments;
    }

    @Override
    public void createUser(User user) throws CreateException {
        LOGGER.info("UserManager: Creating user.");
        try{
            em.persist(user);
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "UserManager: Exception creating user.{0}",
                    e.getMessage());
            throw new CreateException(e.getMessage());
        }
        LOGGER.info("UserManager: User created.");
    }

    @Override
    public void updateUser(User user) throws UpdateException {
        LOGGER.info("UserManager: Updating user.");
        try{
            if(!em.contains(user))em.merge(user);
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "UserManager: Exception updating user.{0}",
                    e.getMessage());
            throw new UpdateException(e.getMessage());
        }
        LOGGER.info("UserManager: User updated.");
    }

    @Override
    public void deleteUser(User user) throws DeleteException {
        LOGGER.info("UserManager: Deleting user.");
        try{
            user=em.merge(user);
            em.remove(user);
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "UserManager: Exception deleting user.{0}",
                    e.getMessage());
            throw new DeleteException(e.getMessage());
        }
        LOGGER.info("UserManager: User deleted.");
    }


}
