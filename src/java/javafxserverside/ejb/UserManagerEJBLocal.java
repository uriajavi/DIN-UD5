/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxserverside.ejb;

import java.util.List;
import javafxserverside.entity.Department;
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

    public User findUserByLogin(String login) throws ReadException;
    public List<User> findAllUsers() throws ReadException;
    public List<Department> findAllDepartments() throws ReadException;
    public void createUser(User user) throws CreateException;
    public void updateUser(User user) throws UpdateException;
    public void deleteUser(User user) throws DeleteException;
    
}
