package co.project.richiTrainsModel.testMain;

import co.project.richiTrainsModel.domainTrain.TipoTrain;
import co.project.richiTrainsModel.domainTrain.Train;
import co.project.richiTrainsModel.repository.repositoryTrain.GestionTrain;

public class TrainMainTest {
    public static void main(String[] args) {

        TipoTrain mercerdez = new TipoTrain("Mercedez-benz", 28);
        TipoTrain arnold = new TipoTrain("Arnold", 28);

        Train train1 = new Train("rayo", "1", arnold, false,  100, true);
        Train train2 = new Train("fuego", "2", mercerdez, false,  50, false);
        Train train3 = new Train("agua", "3", mercerdez, true,  100, true);

        GestionTrain trainRepository = new GestionTrain("C:\\Users\\juans\\OneDrive\\Escritorio\\richi-trains\\src\\main\\java\\co\\project\\richiTrainsDatabase\\Train.json");
       
        //trainRepository.addTrain(train2);
        //trainRepository.addTrain(train1);
        //trainRepository.addTrain(train2);
        //System.out.println(trainRepository.getTrainByReference("1").toString());
        //System.out.println(train1.toString()); 
        //trainRepository.removerTren("rayo");
        /*TipoTrainRepository tipoTrainRepository = new TipoTrainRepository("C:\\Users\\User\\Desktop\\StructuresForProject\\arrayestructura\\src\\main\\java\\co\\edu\\upb\\estructuras1\\MVC\\database\\TipoTrain.json");
        tipoTrainRepository.addTipoTrain(arnold);
        tipoTrainRepository.addTipoTrain(mercerdez);
        /* */
        //trainRepository.editarTren("2", train3);
       
        //trainRepository.addTrain(train3);

        System.out.println(trainRepository.getEnabledTrainList());
        trainRepository.disableTrainByReference(train1.getReferencia());

    }
}