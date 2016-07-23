
import java.util.LinkedList;

public class WorstFitAlgorithm extends Algorithm {
    
    public WorstFitAlgorithm() {
        super(Algorithm.Factory.WORST_FIT);
    }

    protected WorstFitAlgorithm(String algorithmName) {
        super(algorithmName);
    }

    @Override
    public void execute(
            int loadLimit,
            LinkedList<Parcel> parcels,
            LinkedList<String> executionStack,
            LinkedList<Truck> trucks,
            Truck.Factory factory) {
        
        Truck newTruck = null;
        
        ParcelLoop:
        for(Parcel parcel: parcels){
            executionStack.add("Adding parcel with weight" + parcel.getWeight());
        
            TruckLoop:
            for(Truck truck: trucks){
                if(truck.isMax()){
                    if(truck.canFit(parcel)){
                        executionStack.add(String.format
                                        ("\tAdded to truck with load (%d/%d)",
                                        truck.getRemainingLoad(),
                                        loadLimit));
                        truck.addParcel(parcel);

                        continue ParcelLoop;
                    }
                }
            }
            
            executionStack.add("\tAdded to new truck");
            
            newTruck = factory.make();
            newTruck.addParcel(parcel);
            trucks.add(newTruck);
      
        }
        
    }

}
