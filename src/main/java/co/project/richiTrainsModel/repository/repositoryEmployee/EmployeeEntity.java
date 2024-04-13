package co.project.richiTrainsModel.repository.repositoryEmployee;

import java.io.Serializable;

import co.edu.upb.estructuras1.array.Array;

public class EmployeeEntity implements Serializable{
    
    private String id;
    private String name;
    private String lastname;
    private Array<String> phoneNumbers;

    
    public EmployeeEntity(String id, String name, String lastname, Array<String> phoneNumbers) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phoneNumbers = phoneNumbers;
    }
    
    public Array<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Array<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    



}
