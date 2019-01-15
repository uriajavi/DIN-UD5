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
    /**
     * Logger for the class.
     */
    private static final Logger LOGGER =
            Logger.getLogger("javafxserverside");
    /**
     * Entity manager object.
     */
    @PersistenceContext
    private EntityManager em;
    /**
     * Finds a {@link User} by its login. 
     * @param login The login for the user to be found.
     * @return The {@link User} object containing user data. 
     * @throws ReadException If there is any Exception during processing.
     */
    @Override
    public User findUserByLogin(String login) throws ReadException {
        User user=null;
        try{
            LOGGER.info("UserManager: Finding user by login.");
            user=em.find(User.class, login);
            if (user!=null)LOGGER.log(Level.INFO,"UserManager: User found {0}",
                                      user.getLogin());
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "UserManager: Exception Finding user by login:",
                    e.getMessage());
            throw new ReadException(e.getMessage());
        }
        return user;
    }
    /**
     * Finds a List of {@link User} objects containing data for all users in the
     * application data storage.
     * @return A List of {@link User} objects.
     * @throws ReadException If there is any Exception during processing.
     */
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
    /**
     * Finds a List of {@link User} objects containing data for all users with certain
     * profile value.
     * @param profile The profile value for the users to be found.
     * @return A List of {@link User} objects.
     * @throws ReadException If there is any Exception during processing.
     */
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
    /**
     * Finds a List of {@link Department} objects containing data for all departments in the
     * application data storage.
     * @return A List of {@link Department} objects.
     * @throws ReadException If there is any Exception during processing.
     */
    @Override
    public List<Department> findAllDepartments() throws ReadException{
        List<Department> departments=null;
        try{
            LOGGER.info("UserManager: Reading all departments.");
            departments=em.createNamedQuery("findAllDepartments").getResultList();
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, 
                    "UserManager: Exception reading departments for users, {0}",
                    e.getMessage());
            throw new ReadException(e.getMessage());
        }
        return departments;
    }
    /**
     * Creates a User and stores it in the underlying application storage. 
     * @param user The {@link User} object containing the user data. 
     * @throws CreateException If there is any Exception during processing.
     */
    @Override
    public void createUser(User user) throws CreateException {
        LOGGER.info("UserManager: Creating user.");
        try{
            em.persist(user);
            LOGGER.info("UserManager: User created.");
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "UserManager: Exception creating user.{0}",
                    e.getMessage());
            throw new CreateException(e.getMessage());
        }
    }
    /**
     * Updates a user's data in the underlying application storage. 
     * @param user The {@link User} object containing the user data. 
     * @throws UpdateException If there is any Exception during processing.
     */
    @Override
    public void updateUser(User user) throws UpdateException {
        LOGGER.info("UserManager: Updating user.");
        try{
            //if(!em.contains(user))em.merge(user);
            em.merge(user);
            em.flush();
            LOGGER.info("UserManager: User updated.");
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "UserManager: Exception updating user.{0}",
                    e.getMessage());
            throw new UpdateException(e.getMessage());
        }
    }
    /**
     * Deletes a user's data in the underlying application storage. 
     * @param user The {@link User} object containing the user data. 
     * @throws DeleteException If there is any Exception during processing.
     */
    @Override
    public void deleteUser(User user) throws DeleteException {
        LOGGER.info("UserManager: Deleting user.");
        try{
            user=em.merge(user);
            em.remove(user);
            LOGGER.info("UserManager: User deleted.");
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "UserManager: Exception deleting user.{0}",
                    e.getMessage());
            throw new DeleteException(e.getMessage());
        }
    }


}
