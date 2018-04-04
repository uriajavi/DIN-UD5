/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxserverside.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity JPA class for user data. The properties of this class are login , 
 * name, profile and department.
 * @author javi
 */
@Entity
@Table(name="user",schema="dindb")
@NamedQueries({
    @NamedQuery(name="findAllUsers",
            query="SELECT u FROM User u ORDER BY u.name DESC"
    ),
    @NamedQuery(name="findUsersByProfile",
            query="SELECT u FROM User u WHERE u.profile = :profile"
    )
})
@XmlRootElement
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Id field for user entity. It is also the login id value for the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String login;
    /**
     * Full name of the user.
     */
    private String name;
    /**
     * {@link Profile} value for the user.
     */
    @Enumerated(EnumType.ORDINAL)
    private Profile profile;
    /**
     * {@link Department} of the user.
     */
    @ManyToOne
    private Department department;
    /**
     * Gets login value for user.
     * @return The login value.
     */
    public String getLogin() {
        return login;
    }
    /**
     * Sets login value for user.
     * @param login The login value.
     */
    public void setLogin(String login) {
        this.login = login;
    }
    /**
     * Gets name value for user.
     * @return The name value.
     */
    public String getName() {
        return name;
    }
    /**
     * Sets name value for user.
     * @param name The name value.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Gets Profile value for user.
     * @return The Profile value.
     */
    public Profile getProfile(){
        return profile;
    }
    /**
     * Sets Profile value for user.
     * @param profile The Profile value.
     */
    public void setProfile(Profile profile){
        this.profile=profile;
    }
    /**
     * Gets Department value for user.
     * @return The Department value.
     */
    public Department getDepartment(){
        return department;
    }
    /**
     * Sets Department value for user.
     * @param department The Department value.
     */
    public void setDepartment(Department department){
        this.department=department;
    }
    /**
     * HashCode method implementation for the entity.
     * @return An integer value as hashcode for the object. 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }
    /**
     * This method compares two user entities for equality. This implementation
     * compare login field value for equality.
     * @param object The object to compare to.
     * @return True if objects are equals, otherwise false.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.login == null && other.login != null) || 
            (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }
    /**
     * This method returns a String representation for a user entity instance.
     * @return The String representation for the user object. 
     */
    @Override
    public String toString() {
        return "javafxserverside.entity.User[ login=" + login + " ]";
    }
    
}
