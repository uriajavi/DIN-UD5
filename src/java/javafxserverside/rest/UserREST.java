/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxserverside.rest;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafxserverside.ejb.UserManagerEJBLocal;
import javafxserverside.entity.Department;
import javafxserverside.entity.Profile;
import javafxserverside.entity.User;
import javafxserverside.exception.CreateException;
import javafxserverside.exception.DeleteException;
import javafxserverside.exception.ReadException;
import javafxserverside.exception.UpdateException;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * RESTful web service class exposing CRUD operations for {@link User} entities. 
 * @author javi
 */
@Path("users")
public class UserREST{
    /**
     * Logger for class methods.
     */
    private static final Logger LOGGER =
            Logger.getLogger("javafxserverside");
    /**
     * EJB reference for business logic object.
     */
    @EJB
    private UserManagerEJBLocal ejb;
    /**
     * RESTful POST method for creating {@link User} objects from XML representation.
     * @param user The object containing user data.
     */
    @POST
    @Consumes({"application/xml"})
    public void create(User user) {
        try {
            LOGGER.log(Level.INFO,"UserRESTful service: create {0}.",user);
            ejb.createUser(user);
        } catch (CreateException ex) {
            LOGGER.log(Level.SEVERE, 
                    "UserRESTful service: Exception creating user, {0}",
                    ex.getMessage());
            throw new InternalServerErrorException(ex);
        }
    }
    /**
     * RESTful PUT method for updating {@link User} objects from XML representation.
     * @param user The object containing user data.
     */
    @PUT
    @Consumes({"application/xml"})
    public void update(User user) {
        try {
            LOGGER.log(Level.INFO,"UserRESTful service: update {0}.",user);
            ejb.updateUser(user);
        } catch (UpdateException ex) {
            LOGGER.log(Level.SEVERE,
                    "UserRESTful service: Exception updating user, {0}",
                    ex.getMessage());
            throw new InternalServerErrorException(ex);
        }
    }
    /**
     * RESTful DELETE method for deleting {@link User} objects from id.
     * @param id The id for the object to be deleted.
     */
    @DELETE
    @Path("{id}")
    //@Consumes({"application/xml", "application/json"})
    public void delete(@PathParam("id") String id) {
        try {
            LOGGER.log(Level.INFO,"UserRESTful service: delete User by id={0}.",id);
            ejb.deleteUser(ejb.findUserByLogin(id));
        } catch (ReadException | DeleteException ex) {
            LOGGER.log(Level.SEVERE,
                    "UserRESTful service: Exception deleting user by id, {0}",
                    ex.getMessage());
            throw new InternalServerErrorException(ex);
        } 
    }
    /**
     * RESTful GET method for reading {@link User} objects through an XML representation.
     * @param id The id for the object to be read.
     * @return The User object containing data. 
     */
    @GET
    @Path("{id}")
    @Produces({"application/xml"})
    public User find(@PathParam("id") String id) {
        User user=null;
        try {
            LOGGER.log(Level.INFO,"UserRESTful service: find User by id={0}.",id);
            user=ejb.findUserByLogin(id);
        } catch (ReadException ex) {
            LOGGER.log(Level.SEVERE,
                    "UserRESTful service: Exception reading user by id, {0}",
                    ex.getMessage());
            throw new InternalServerErrorException(ex);
        }
        return user;
    }
    /**
     * RESTful GET method for reading all {@link User} objects through an XML representation.
     * @return A List of User objects containing data.
     */
    @GET
    @Produces({"application/xml"})
    public List<User> findAll() {
        List<User> users=null;
        try {
            LOGGER.log(Level.INFO,"UserRESTful service: find all users.");
            users=ejb.findAllUsers();
        } catch (ReadException ex) {
            LOGGER.log(Level.SEVERE,
                    "UserRESTful service: Exception reading all users, {0}",
                    ex.getMessage());
            throw new InternalServerErrorException(ex);
        }
        return users;
    }
    /**
     * RESTful GET method for reading all {@link User} objects that has a certain profile
     * through an XML representation.
     * @param profile The profile value for the object.
     * @return A List of User objects containing data.
     */
    @GET
    @Path("profile/{profile}")
    @Produces({"application/xml"})
    public List<User> findUsersByProfile(@PathParam("profile") String profile) {
        List<User> users=null;
        try {
            LOGGER.log(Level.INFO,"UserRESTful service: find users by profile {0}.",profile);
            users=ejb.findUsersByProfile(Profile.valueOf(profile));
        } catch (ReadException ex) {
            LOGGER.log(Level.SEVERE,
                    "UserRESTful service: Exception reading users by profile, {0}",
                    ex.getMessage());
            throw new InternalServerErrorException(ex);
        }
        return users;
    }
    /**
     * RESTful GET method for reading all {@link Department} objects 
     * through an XML representation.
     * @return A List of Department objects containing data.
     */
    @GET
    @Path("departments")
    @Produces({"application/xml"})
    public List<Department> findAllDepartments() {
        List<Department> departments=null;
        try {
            LOGGER.log(Level.INFO,"UserRESTful service: find departments for users.");
            departments=ejb.findAllDepartments();
        } catch (ReadException ex) {
            LOGGER.log(Level.SEVERE, 
                    "UserRESTful service: Exception reading departments for users, {0}",
                    ex.getMessage());
            throw new InternalServerErrorException(ex);
        }
        return departments;
    }

}
