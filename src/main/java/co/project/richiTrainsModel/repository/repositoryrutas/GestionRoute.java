package co.project.richiTrainsModel.repository.repositoryrutas;


import co.edu.upb.estructuras1.array.Array;
import co.project.RichiTrainsShared.FileJsonAdapter.FileJsonAdapter;
import co.project.RichiTrainsShared.FileJsonAdapter.FileJsonInterface;
import co.project.richiTrainsModel.domainTrain.Train;
import co.project.richiTrainsModel.domainroutes.Route;

public class GestionRoute {

    private FileJsonInterface<RouteEntity> fileJson;
    private String pathFile;

    public GestionRoute(String pathFile) {
        this.fileJson = FileJsonAdapter.getInstance();
        this.pathFile = pathFile;
    }
    
   
    public boolean addRoute(Route route){
        RouteEntity[] routeEntities = fileJson.getObjects(pathFile, RouteEntity[].class);
        if(routeEntities == null){
            routeEntities = new RouteEntity[0];
        }
        RouteEntity newTrainEntity = new RouteEntity(
            route.getTrain(),
            route.getId(),
            route.getRecorrido(),
            route.getKmRecorrido(),
            route.getInicio(),
            route.getFin()
        );
        if (existRouteById(route.getId())) {
            System.out.println("El tren que va a agregar ya existe"); 
            return false;
        }

        Array<RouteEntity> updatedRouteEntities = new Array<>(routeEntities.length + 1);
        for(RouteEntity entity : routeEntities){
            updatedRouteEntities.add(entity);
        }
        updatedRouteEntities.add(newTrainEntity);

        RouteEntity[] updatedRouteEntitiesArray = new RouteEntity[updatedRouteEntities.size()];
        for(int i = 0; i < updatedRouteEntities.size(); i++){
            updatedRouteEntitiesArray[i] = updatedRouteEntities.get(i);
        }

        return fileJson.writeObjects(pathFile, updatedRouteEntitiesArray);
    }

    public boolean existRouteById(String RouteId){
        RouteEntity[] RouteEntities = fileJson.getObjects(pathFile, RouteEntity[].class);
        if (RouteEntities == null) {
            return false; 
        }
        
        for (RouteEntity entity : RouteEntities) {
            if (entity.getId().equals(RouteId)) {
                return true; 
            }
        }

        return false;
    }

    public Route getRouteById(String routeId){
        RouteEntity[] routeEntities = fileJson.getObjects(pathFile, RouteEntity[].class);
        if (routeEntities == null) {
            return null; 
        }

       
        for (RouteEntity routeEntity : routeEntities) {
            if (routeEntity.getId().equals(routeId)) {
                return new Route(
                    routeEntity.getTrain(),
                    routeEntity.getId(),
                    routeEntity.getRecorrido(),
                    routeEntity.getKmRecorrido(),
                    routeEntity.getInicio(),
                    routeEntity.getFin()
                    );
            }
        }

        return null; 
    }

    public Route getRouteByTrain(Train routeTrain){
        RouteEntity[] routeEntities = fileJson.getObjects(pathFile, RouteEntity[].class);
        if (routeEntities == null) {
            return null; 
        }

       
        for (RouteEntity routeEntity : routeEntities) {
            if (routeEntity.getTrain().equals(routeTrain)) {
                return new Route(
                    routeEntity.getTrain(),
                    routeEntity.getId(),
                    routeEntity.getRecorrido(),
                    routeEntity.getKmRecorrido(),
                    routeEntity.getInicio(),
                    routeEntity.getFin()
                    );
            }
        }

        return null; 
    }

    public boolean deleteRouteById(String routeId){
        RouteEntity[] routeEntities = fileJson.getObjects(pathFile, RouteEntity[].class);
        if (routeEntities == null) {
            return false; 
        }
        
        Array<RouteEntity> updatedRouteEntities = new Array<>(routeEntities.length - 1);
        for (RouteEntity entity : routeEntities) {
            if (!entity.getId().equals(routeId)) {
                updatedRouteEntities.add(entity);
            }
        }

        RouteEntity[] updatedRouteEntitiesArray = new RouteEntity[updatedRouteEntities.size()];
        for(int i = 0; i < updatedRouteEntities.size(); i++){
            updatedRouteEntitiesArray[i] = updatedRouteEntities.get(i);
        }

        return fileJson.writeObjects(pathFile, updatedRouteEntitiesArray);
    }

    public boolean editarRoute(String routeId, Route routeEditada) {
        RouteEntity[] routeEntities = fileJson.getObjects(pathFile, RouteEntity[].class);
        if (routeEntities == null) {
            return false; 
        }
    
        boolean routeEncontrada = false;
        for (RouteEntity entity : routeEntities) {
            if (entity.getId().equals(routeId)) {
                entity.setTrain(routeEditada.getTrain());
                entity.setRecorrido(routeEditada.getRecorrido());
                entity.setKmRecorrido(routeEditada.getKmRecorrido());
                entity.setInicio(routeEditada.getInicio());
                entity.setFin(routeEditada.getFin());
                routeEncontrada = true;
                break;
            }
        }
    
        if (!routeEncontrada) {
            System.out.println("No se encontró ningún tren con la referencia proporcionada.");
            return false;
        }
    
        return fileJson.writeObjects(pathFile, routeEntities);
    }
}
