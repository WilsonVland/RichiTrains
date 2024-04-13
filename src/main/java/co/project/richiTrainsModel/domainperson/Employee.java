package co.project.richiTrainsModel.domainperson;

import co.edu.upb.estructuras1.array.Array;

public class Employee extends AbstractPerson {

    String id;
    
    public Employee() {
        super();
    }
    
    public Employee(String name, String lastName, Array<String> phoneNumbers, String id) {
        super(name, lastName, phoneNumbers);
        this.id = id;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static Employee getNullEmployee(){
        return new Employee();
    }
}
