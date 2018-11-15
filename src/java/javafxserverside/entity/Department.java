/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxserverside.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *  Entity class for departments. It has the following fields: 
 *  <ul>
 *      <li><strong>id:</strong> Identifier field. Integer auto-generated value.</li>
 *      <li><strong>name:</strong> Name of the department.</li>
 *      <li><strong>description:</strong> Department´s long text description.</li>
 *      <li><strong>users:</strong> A List of User objects containing all users that belong to the department.</li>
 *  </ul>
 * @author Javier Martin Uria
 */
@Entity
@Table(name="department",schema="dindb")
@NamedQuery(name="findAllDepartments",
            query="SELECT d FROM Department d ORDER BY d.name DESC"
)

@XmlRootElement
public class Department implements Serializable {
    /**
     * List of {@link User} belonging to the department.
     */
    @OneToMany(mappedBy = "department")
    private List<User> users;
    private static final long serialVersionUID = 1L;
    /**
     * Id for the department.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * Name of the department.
     */
    private String name;
    /**
     * Long description for the department.
     */
    private String description;
    /**
     * Gets the id of the department.
     * @return The id value for the department.
     */
    public Integer getId() {
        return id;
    }
    /**
     * Sets the id for the department.
     * @param id The id value for the department.
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Gets the name of the department.
     * @return The name of the department. 
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name for the department.
     * @param name The name of the department.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Gets the long description of the department.
     * @return The description value.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Sets the long description for the department.
     * @param description The description value.
     */
    public void setDescription(String description) {
        this.description = description;
    }   
    /**
     * Gets the list of users belonging to this department.
     * @return A List of {@link User}.
     */
    @XmlTransient
    public List<User> getUsers() {
        return users;
    }
    /**
     * Sets the list of users belonging to this department.
     * @param users A List of {@link User}.
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }
    /**
     * HashCode method implementation for the entity.
     * @return An integer value as hashcode for the object. 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    /**
     * This method compares two department entities for equality. This implementation
     * compare id field value for equality.
     * @param object The object to compare to.
     * @return True if objects are equals, otherwise false.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    /**
     * This method returns a String representation for a user entity instance.
     * @return The String representation for the department object. 
     */
    public String toString() {
        return "javafxserverside.entity.Department[ id=" + id + " ]";
    }
    
}
