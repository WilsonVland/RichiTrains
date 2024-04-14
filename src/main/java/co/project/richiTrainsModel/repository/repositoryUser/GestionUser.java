package co.project.richiTrainsModel.repository.repositoryUser;

import co.edu.upb.estructuras1.array.Array;
import co.project.RichiTrainsShared.FileJsonAdapter.FileJsonAdapter;
import co.project.RichiTrainsShared.FileJsonAdapter.FileJsonInterface;
import co.project.richiTrainsModel.domainperson.User;

public class GestionUser {
    
    private FileJsonInterface<UserEntity> fileJson;
    private String pathFile;

    public GestionUser(String pathFile) {
        this.fileJson = FileJsonAdapter.getInstance();
        this.pathFile = pathFile;
    }
    //pasarle el get de usuario en base a la contras
    public boolean addUser(User user){
        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);
        if(userEntities == null){
            userEntities = new UserEntity[0];
        }
        UserEntity newUserEntity = new UserEntity(
            user.getUserName(),
            user.getPassword(),
            user.getId(),
            user.getTipo()
        );
        if (existUserByUsername(user.getUserName())) {
            System.out.println("El usuario que va a agregar ya existe"); 
            return false;
        }

        Array<UserEntity> updatedUserEntities = new Array<>(userEntities.length + 1);
        for(UserEntity entity : userEntities){
            updatedUserEntities.add(entity);
        }
        updatedUserEntities.add(newUserEntity);

        UserEntity[] updatedUserEntitiesArray = new UserEntity[updatedUserEntities.size()];
        for(int i = 0; i < updatedUserEntities.size(); i++){
            updatedUserEntitiesArray[i] = updatedUserEntities.get(i);
        }

        return fileJson.writeObjects(pathFile, updatedUserEntitiesArray);
    }

    public boolean existUserByUsername(String userName){
        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);
        if (userEntities == null) {
            return false; 
        }
        
        for (UserEntity entity : userEntities) {
            if (entity.getUserName().equals(userName)) {
                return true; 
            }
        }
        return false;
    }

    public boolean existUserByPassword(String password){
        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);
        if (userEntities == null) {
            return false; 
        }
        
        for (UserEntity entity : userEntities) {
            if (entity.getPassword().equals(password)) {
                return true; 
            }
        }
        return false;
    }

    public boolean deleteUserByUsername(String userName){
        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);
        if (userEntities == null) {
            return false; 
        }
        
        Array<UserEntity> updatedUserEntities = new Array<>(userEntities.length - 1);
        for (UserEntity entity : userEntities) {
            if (!entity.getUserName().equals(userName)) {
                updatedUserEntities.add(entity);
            }
        }

        UserEntity[] updatedUserEntitiesArray = new UserEntity[updatedUserEntities.size()];
        for(int i = 0; i < updatedUserEntities.size(); i++){
            updatedUserEntitiesArray[i] = updatedUserEntities.get(i);
        }

        return fileJson.writeObjects(pathFile, updatedUserEntitiesArray);
    }

    
}
