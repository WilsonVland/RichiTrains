package co.project.richiTrainsModel.repository.repositoryTrain;


import co.edu.upb.estructuras1.array.Array;
import co.project.RichiTrainsShared.FileJsonAdapter.FileJsonAdapter;
import co.project.RichiTrainsShared.FileJsonAdapter.FileJsonInterface;
import co.project.richiTrainsModel.domainTrain.TipoTrain;

public class GestionTipoTrain {
    
    private FileJsonInterface<TipoTrainEntity> fileJson;
    private String pathFile;

    public GestionTipoTrain(String pathFile) {
        this.fileJson = FileJsonAdapter.getInstance();
        this.pathFile = pathFile;
    }

    public boolean addTipoTrain(TipoTrain tipoTrain){
        TipoTrainEntity[] tipoTrainEntities = fileJson.getObjects(pathFile, TipoTrainEntity[].class);
        if(tipoTrainEntities == null){
            tipoTrainEntities = new TipoTrainEntity[0];
        }
        TipoTrainEntity newTipoTrainEntity = new TipoTrainEntity(
            tipoTrain.getMarca(),
            tipoTrain.getCantMxVagones()
        );
        /*if (existTrainByReference(tren.getReferencia())) {
            System.out.println("El tren que va a agregar ya existe"); 
            return false;
        }/* */

        Array<TipoTrainEntity> updatedTipoTrainEntities = new Array<>(tipoTrainEntities.length + 1);
        for(TipoTrainEntity entity : tipoTrainEntities){
            updatedTipoTrainEntities.add(entity);
        }
        updatedTipoTrainEntities.add(newTipoTrainEntity);

        TipoTrainEntity[] updatedTipoTrainEntitiesArray = new TipoTrainEntity[updatedTipoTrainEntities.size()];
        for(int i = 0; i < updatedTipoTrainEntities.size(); i++){
            updatedTipoTrainEntitiesArray[i] = updatedTipoTrainEntities.get(i);
        }

        return fileJson.writeObjects(pathFile, updatedTipoTrainEntitiesArray);
    }

    public TipoTrain getTipoTrain(String name){
        TipoTrainEntity[] tipoTrainEntities = fileJson.getObjects(pathFile, TipoTrainEntity[].class);
        if(tipoTrainEntities == null){
            tipoTrainEntities = new TipoTrainEntity[0];
        }

        for (TipoTrainEntity tipoTrainEntity : tipoTrainEntities) {
            if (tipoTrainEntity.getMarca().equals(name)) {
                return new TipoTrain(
                    tipoTrainEntity.getMarca(),
                    tipoTrainEntity.getCantMxVagones());
            }
        }

        return null; 
    }
}
