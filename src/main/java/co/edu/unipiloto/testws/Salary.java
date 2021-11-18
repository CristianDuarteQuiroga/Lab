/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.testws;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author JEFRY
 */
@XmlRootElement(name = "salary")
@XmlType(propOrder = {"total"})
public class Salary implements Serializable{
    private static final long serialVersionUID=1L;
    private int total;

    @XmlElement
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Salary() {
    }
    
}
