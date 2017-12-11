/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxserverside.entity;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for entity Department
 * @author javi
 */
public class DepartmentTest {
    
    public DepartmentTest() {
    }

    /**
     * Test of getId method, of class Department.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Department instance = new Department();
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Department.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        Department instance = new Department();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Department.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Department instance = new Department();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Department.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Department instance = new Department();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Department.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Department instance = new Department();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Department.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Department instance = new Department();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Department.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Department instance = new Department();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Department.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Department instance = new Department();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Department.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Department instance = new Department();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
