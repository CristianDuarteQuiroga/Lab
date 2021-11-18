/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.testws.services;

import co.edu.unipiloto.testws.Persona;
import co.edu.unipiloto.testws.Salary;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author JEFRY
 */

@Path("service")
public class Servicio {
    private static Map<Integer,Persona> persons = new HashMap<Integer,Persona>();
    private static final int MINIMUM_SALARY=908000;
    
    static {
        for (int i = 0; i < 10; i++) {
            Persona person = new Persona();
            int id = i + 1;
            person.setId(id);
            person.setFullName("My wonderfull Person " + id);
            person.setAge(new Random().nextInt(40) + 1);
            person.setSalary(person.getAge()*MINIMUM_SALARY/3);
            persons.put(id, person);
        }
        
        
    }
    
    @GET
    @Path("/getAllPersonsInXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Persona> getAllPersonsInXML(){
        return new ArrayList<Persona>(persons.values());
    }
    
    @POST
    @Path("/addPersonInJson")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public Persona addPersonInJson (Persona person) {

        persons.put(new Integer(person.getId()), person);
        return person;
    }
    
    @GET
    @Path("/getPersonByIdJson/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Persona getPersonByIdJson(@PathParam("id") int id) {
        return persons.get(id);
    }
    
    @GET
    @Path("/getAverageSalaryInXML")
    @Produces(MediaType.APPLICATION_XML)
    public Salary getAverageSalary(){
        int avSalary=0;
        for (Persona persona : persons.values()) {
            avSalary+=persona.getSalary();
        }
        avSalary=avSalary/persons.size();
        Salary salary=new Salary();
        salary.setTotal(avSalary);
        return salary;
    }
    
    @GET
    @Path("/getSalarySum")
    @Produces(MediaType.APPLICATION_JSON)
    public Salary getSalarySum() {
        int sumSalary=0;
        for (Persona persona : persons.values()) {
            sumSalary+=persona.getSalary();
        }
        Salary salary=new Salary();
        salary.setTotal(sumSalary);
        return salary;
    }
}
