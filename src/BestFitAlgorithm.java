
import java.util.LinkedList;

public class BestFitAlgorithm extends Algorithm {

    public BestFitAlgorithm() {
        super(Factory.BEST_FIT);
    }

    protected BestFitAlgorithm(String algorithmName) {
        super(algorithmName);
    }

    public boolean FitBestTruck(LinkedList<Truck> trucks, Parcel parcel)
	{
            
		Truck minTruck = null;
		for (Truck truck : trucks)
		{
			int currentLoad = truck.getCurrentLoad();
			int parcelWeight = parcel.getWeight();
                        if (currentLoad >= parcelWeight)
			{
				minTruck = truck;
			}
			if (currentLoad == parcelWeight)
			{
				break;
			}
		}
		
		// no more trucks could fit
		if (minTruck == null)
			return false;
                
                minTruck.addParcel(parcel);		
		return true;
        }     
    
    
    @Override
    public void execute(
            int loadLimit,
            LinkedList<Parcel> parcels,
            LinkedList<String> executionStack,
            LinkedList<Truck> trucks,
            Truck.Factory factory) {

        Truck newTruck = null;

        // Parcel label
        ParcelLoop:
        for (Parcel parcel : parcels) {
            executionStack.add("Adding parcel with weight " + parcel.getWeight());

            // Truck label
            TruckLoop:
            for (Truck truck : trucks) {
                if (truck.canFit(parcel)) {
                    executionStack.add(
                            String.format(
                                    "\tAdded to truck with load (%d/%d)",
                                    truck.getRemainingLoad(),
                                    loadLimit));
                    truck.addParcel(parcel);

                    // Continue parcel loop
                    continue ParcelLoop;
                }
                    if (FitBestTruck(trucks, parcel) == true){
                        continue ParcelLoop; 
                    }
            }

            executionStack.add("\tAdded to new truck");

            newTruck = factory.make();
            newTruck.addParcel(parcel);
            trucks.add(newTruck);
        }
    }

}
