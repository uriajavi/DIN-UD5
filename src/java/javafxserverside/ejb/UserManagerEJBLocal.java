/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxserverside.ejb;

import java.util.List;
import javafxserverside.entity.Department;
import javafxserverside.entity.Profile;
import javafxserverside.entity.User;
import javafxserverside.exception.CreateException;
import javafxserverside.exception.DeleteException;
import javafxserverside.exception.ReadException;
import javafxserverside.exception.UpdateException;
import javax.ejb.Local;

/**
 * EJB Local Interface for managing User entity CRUD operations.
 * @author javi
 */
@Local
public interface UserManagerEJBLocal {
    /**
     * Finds a {@link User} by its login. 
     * @param login The login for the user to be found.
     * @return The {@link User} object containing user data. 
     * @throws ReadException If there is any Exception during processing.
     */
    public User findUserByLogin(String login) throws ReadException;
    /**
     * Finds a List of {@link User} objects containing data for all users in the
     * application data storage.
     * @return A List of {@link User} objects.
     * @throws ReadException If there is any Exception during processing.
     */
    public List<User> findAllUsers() throws ReadException;
    /**
     * Finds a List of {@link User} objects containing data for all users with certain
     * profile value.
     * @param profile The profile value for the users to be found.
     * @return A List of {@link User} objects.
     * @throws ReadException If there is any Exception during processing.
     */
    public List<User> findUsersByProfile(Profile profile) throws ReadException;
    /**
     * Finds a List of {@link Department} objects containing data for all departments in the
     * application data storage.
     * @return A List of {@link Department} objects.
     * @throws ReadException If there is any Exception during processing.
     */
    public List<Department> findAllDepartments() throws ReadException;
    /**
     * Creates a User and stores it in the underlying application storage. 
     * @param user The {@link User} object containing the user data. 
     * @throws CreateException If there is any Exception during processing.
     */
    public void createUser(User user) throws CreateException;
    /**
     * Updates a user's data in the underlying application storage. 
     * @param user The {@link User} object containing the user data. 
     * @throws UpdateException If there is any Exception during processing.
     */
    public void updateUser(User user) throws UpdateException;
    /**
     * Deletes a user's data in the underlying application storage. 
     * @param user The {@link User} object containing the user data. 
     * @throws DeleteException If there is any Exception during processing.
     */
    public void deleteUser(User user) throws DeleteException;
    
}
