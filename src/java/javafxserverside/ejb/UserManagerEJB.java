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
        LOGGER.info("UserManager: Finding user by login.");
        return em.find(User.class, login);
    }
    
    @Override
    public List<User> findAllUsers() throws ReadException {
        LOGGER.info("UserManager: Reading all users.");
        return em.createNamedQuery("findAllUsers").getResultList();
    }

    @Override
    public List<Department> findAllDepartments() throws ReadException{
        LOGGER.info("UserManager: Reading all departments.");
        return em.createNamedQuery("findAllDepartments").getResultList();
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
