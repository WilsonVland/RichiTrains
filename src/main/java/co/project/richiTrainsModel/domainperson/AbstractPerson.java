package co.project.richiTrainsModel.domainperson;

import co.edu.upb.estructuras1.array.Array;

public abstract class AbstractPerson {

    protected String name;
    protected String lastName; 
    protected Array<String> phoneNumbers;

    protected AbstractPerson() {
        this.name = "N/A";
        this.lastName = "N/A";
        this.phoneNumbers = new Array<>();
    }

    protected AbstractPerson(String name, String lastName, Array<String> phoneNumbers) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;

    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Array<String> getPhoneNumbers() {
        return phoneNumbers;
    }
    public void setPhoneNumbers(Array<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    } 

    
}
