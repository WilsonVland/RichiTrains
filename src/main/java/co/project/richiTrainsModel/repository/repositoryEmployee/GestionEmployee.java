package co.project.richiTrainsModel.repository.repositoryEmployee;

import co.edu.upb.estructuras1.io.Array;
import co.edu.upb.estructuras1.linkedlist.Singly.LinkedList;
import co.project.RichiTrainsShared.FileJsonAdapter.FileJsonAdapter;
import co.project.RichiTrainsShared.FileJsonAdapter.FileJsonInterface;
import co.project.richiTrainsModel.domainperson.Employee;

public class GestionEmployee {
  private FileJsonInterface<EmployeeEntity> fileJson;
  private String pathFile;

  public GestionEmployee(String pathFile) {
    this.fileJson = FileJsonAdapter.getInstance();
    this.pathFile = pathFile;
  }

  public Employee getEmployeeByName(String name){
    EmployeeEntity[] employeeEntities = fileJson.getObjects(pathFile, EmployeeEntity[].class);
    if(employeeEntities == null){
        return null;
    }

    for (EmployeeEntity employeeEntity : employeeEntities) {
      if (employeeEntity.getName().equals(name)) {
        return new Employee(
          employeeEntity.getName(),
          employeeEntity.getLastname(),
          employeeEntity.getPhoneNumbers(),
          employeeEntity.getId());
      }
    }
    return null;
  }


  public boolean addEmployee(Employee employee){
    EmployeeEntity[] employeeEntities = fileJson.getObjects(pathFile, EmployeeEntity[].class);
    if(employeeEntities == null){
        employeeEntities = new EmployeeEntity[0];
    }
    EmployeeEntity newEmployeeEntity = new EmployeeEntity(
        employee.getId(),
        employee.getName(),
        employee.getLastName(),
        employee.getPhoneNumbers()
    );
    if (existEmployeeById(employee.getId())) {
        System.out.println("El empleado que va a agregar ya existe"); 
        return false;
    }

    Array<EmployeeEntity> updatedEmployeeEntities = new Array<>(employeeEntities.length + 1);
    for(EmployeeEntity entity : employeeEntities){
        updatedEmployeeEntities.add(entity);
    }
    updatedEmployeeEntities.add(newEmployeeEntity);

    EmployeeEntity[] updatedEmployeeEntitiesArray = new EmployeeEntity[updatedEmployeeEntities.size()];
    for(int i = 0; i < updatedEmployeeEntities.size(); i++){
        updatedEmployeeEntitiesArray[i] = updatedEmployeeEntities.get(i);
    }

    return fileJson.writeObjects(pathFile, updatedEmployeeEntitiesArray);
  }


  public boolean existEmployeeById(String employeeId){
    EmployeeEntity[] employeeEntities = fileJson.getObjects(pathFile, EmployeeEntity[].class);
    if (employeeEntities == null) {
        return false; 
    }
    
    for (EmployeeEntity entity : employeeEntities) {
        if (entity.getId().equals(employeeId)) {
            return true; 
        }
    }

    return false;
  }

  public boolean existEmployeeByName(String employeeName){
    EmployeeEntity[] employeeEntities = fileJson.getObjects(pathFile, EmployeeEntity[].class);
    if (employeeEntities == null) {
        return false; 
    }
    
    for (EmployeeEntity entity : employeeEntities) {
        if (entity.getName().equals(employeeName)) {
            return true; 
        }
    }

    return false;
  }

  public boolean deleteEmployeeById(String employeeId){
    EmployeeEntity[] employeeEntities = fileJson.getObjects(pathFile, EmployeeEntity[].class);
    if (employeeEntities == null) {
        return false; 
    }
    
    Array<EmployeeEntity> updatedEmployeeEntities = new Array<>(employeeEntities.length - 1);
    for (EmployeeEntity entity : employeeEntities) {
        if (!entity.getId().equals(employeeId)) {
            updatedEmployeeEntities.add(entity);
        }
    }

    EmployeeEntity[] updatedEmployeeEntitiesArray = new EmployeeEntity[updatedEmployeeEntities.size()];
    for(int i = 0; i < updatedEmployeeEntities.size(); i++){
        updatedEmployeeEntitiesArray[i] = updatedEmployeeEntities.get(i);
    }

    return fileJson.writeObjects(pathFile, updatedEmployeeEntitiesArray);
  }  

  public LinkedList<Employee> getEmployeeList() {
    EmployeeEntity[] employeeEntities = fileJson.getObjects(pathFile, EmployeeEntity[].class);
    if (employeeEntities == null) {
        return null; 
    }

    LinkedList<Employee> trainList = new LinkedList<>();

    for (EmployeeEntity employeeEntity : employeeEntities) {
            Employee train = new Employee(
              employeeEntity.getName(),
              employeeEntity.getLastname(),
              employeeEntity.getPhoneNumbers(),
              employeeEntity.getId());
            trainList.add(train);
    }

    return trainList;
}

public boolean editEmployee(String employeeId, Employee employeeEditado){
  EmployeeEntity[] employeeEntities = fileJson.getObjects(pathFile, EmployeeEntity[].class);
  if (employeeEntities == null) {
      return false; 
  }

  boolean employeeEncontrado = false;
  for (EmployeeEntity entity : employeeEntities) {
      if (entity.getId().equals(employeeId)) {
          entity.setName(employeeEditado.getName());
          entity.setLastname(employeeEditado.getLastName());
          entity.setPhoneNumbers(employeeEditado.getPhoneNumbers());
          entity.setId(employeeEditado.getId());
          break;
      }
  }

  if (!employeeEncontrado) {
      System.out.println("No se encontró ningún tren con la referencia proporcionada.");
      return false;
  }

  return fileJson.writeObjects(pathFile, employeeEntities);
}

}
