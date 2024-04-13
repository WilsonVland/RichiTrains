package co.project.richiTrainsModel.repository.repositoryTrain;


import co.edu.upb.estructuras1.array.Array;
import co.edu.upb.estructuras1.linkedlist.doubly.LinkedList;
import co.project.RichiTrainsShared.FileJsonAdapter.FileJsonAdapter;
import co.project.RichiTrainsShared.FileJsonAdapter.FileJsonInterface;
import co.project.richiTrainsModel.domainTrain.Train;

public class GestionTrain {
    
    private FileJsonInterface<TrainEntity> fileJson;
    private String pathFile;

    public GestionTrain(String pathFile) {
        this.fileJson = FileJsonAdapter.getInstance();
        this.pathFile = pathFile;
    }

    public boolean addTrain(Train tren){
        TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);
        if(trainEntities == null){
            trainEntities = new TrainEntity[0];
        }
        TrainEntity newTrainEntity = new TrainEntity(
            tren.getName(),
            tren.getReferencia(),
            tren.getTipo(),
            tren.isInRoad(),
            tren.getKilometraje(),
            tren.isEnabled()
        );
        if (existTrainByReference(tren.getReferencia())) {
            System.out.println("El tren que va a agregar ya existe"); 
            return false;
        }

        Array<TrainEntity> updatedTrainEntities = new Array<>(trainEntities.length + 1);
        for(TrainEntity entity : trainEntities){
            updatedTrainEntities.add(entity);
        }
        updatedTrainEntities.add(newTrainEntity);

        TrainEntity[] updatedTrainEntitiesArray = new TrainEntity[updatedTrainEntities.size()];
        for(int i = 0; i < updatedTrainEntities.size(); i++){
            updatedTrainEntitiesArray[i] = updatedTrainEntities.get(i);
        }

        return fileJson.writeObjects(pathFile, updatedTrainEntitiesArray);
    }

    public boolean existTrainByName(String trainName){
            TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);
            if (trainEntities == null) {
                return false; 
            }
            
            for (TrainEntity entity : trainEntities) {
                if (entity.getName().equals(trainName)) {
                    return true; 
                }
            }
    
            return false;
    }

    public boolean existTrainByReference(String trainReference){
        TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);
        if (trainEntities == null) {
            return false; 
        }
        
        for (TrainEntity entity : trainEntities) {
            if (entity.getReferencia().equals(trainReference)) {
                return true; 
            }
        }

        return false;
    }

    public Train getTrainByName(String trainName){
        TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);
        if (trainEntities == null) {
            return null; 
        }

       
        for (TrainEntity trainEntity : trainEntities) {
            if (trainEntity.getName().equals(trainName)) {
                return new Train(
                    trainEntity.getName(), 
                    trainEntity.getReferencia(), 
                    trainEntity.getTipo(), 
                    trainEntity.isInRoad(), 
                    trainEntity.getKilometraje(),
                    trainEntity.isEnabled()
                    
                    );
            }
        }

        return null; 
    }

    public Train getTrainByReference(String trainReference){
        TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);
        if (trainEntities == null) {
            return null; 
        }

        for (TrainEntity trainEntity : trainEntities) {
            if (trainEntity.getReferencia().equals(trainReference)) {
                return new Train(
                    trainEntity.getName(), 
                    trainEntity.getReferencia(), 
                    trainEntity.getTipo(), 
                    trainEntity.isInRoad(), 
                    trainEntity.getKilometraje(),
                    trainEntity.isEnabled()
                    );
            }
        }

        return null; 
    }
    
    public boolean editarTren(String referencia, Train trenEditado) {
        TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);
        if (trainEntities == null) {
            return false; 
        }
    
        boolean trenEncontrado = false;
        for (TrainEntity entity : trainEntities) {
            if (entity.getReferencia().equals(referencia)) {
                entity.setName(trenEditado.getName());
                entity.setTipo(trenEditado.getTipo());
                entity.setInRoad(trenEditado.isInRoad());
                entity.setKilometraje(trenEditado.getKilometraje());
                entity.setEnabled(trenEditado.isEnabled());
                entity.setVagonesEquipaje(trenEditado.getVagonesEquipaje());
                entity.setVagonesPasajeros(trenEditado.getVagonesPasajeros());
                trenEncontrado = true;
                break;
            }
        }
    
        if (!trenEncontrado) {
            System.out.println("No se encontró ningún tren con la referencia proporcionada.");
            return false;
        }
    
        return fileJson.writeObjects(pathFile, trainEntities);
    }

    public LinkedList<Train> getTrainList(){
        TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);
        if (trainEntities == null) {
            return null; 
        }

        LinkedList<Train> trainList = new LinkedList<>();

    if (trainEntities != null) {
        for (TrainEntity entity : trainEntities) {
            Train train = new Train(
                entity.getName(),
                entity.getReferencia(),
                entity.getTipo(),
                entity.isInRoad(),
                entity.getKilometraje(),
                entity.isEnabled()
            );
            trainList.add(train);
        }
    }

    return trainList;
    }

    public LinkedList<Train> getEnabledTrainList() {
        TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);
        if (trainEntities == null) {
            return null; 
        }
    
        LinkedList<Train> trainList = new LinkedList<>();
    
        for (TrainEntity entity : trainEntities) {
            if (entity.isEnabled()) {
                Train train = new Train(
                    entity.getName(),
                    entity.getReferencia(),
                    entity.getTipo(),
                    entity.isInRoad(),
                    entity.getKilometraje(),
                    entity.isEnabled()
                );
                trainList.add(train);
            }
        }
    
        return trainList;
    }

    public boolean disableTrainByReference(String referencia) {
        TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);
        if (trainEntities == null) {
            return false; 
        }
    
        boolean trainFound = false;
    
        for (TrainEntity entity : trainEntities) {
            if (entity.getReferencia().equals(referencia)) {
                entity.setEnabled(false); 
                trainFound = true;
                break;
            }
        }
    
        if (trainFound) {
            fileJson.writeObjects(pathFile, trainEntities);
            return true; 
        } else {
            return false; 
        }
    }
}
