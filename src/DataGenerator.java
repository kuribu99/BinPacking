


import javax.swing.JOptionPane;

/*
 */
/**
 *
 * @author Kong My
 */
public class DataGenerator {

    public static void main(String[] args) {
        String loadLimitStr = JOptionPane.showInputDialog(
                null,
                "Enter load limit",
                "Load limit",
                JOptionPane.QUESTION_MESSAGE);
        
        String numberParcelStr = JOptionPane.showInputDialog(
                null,
                "Enter number of parcel",
                "Parcel Number",
                JOptionPane.QUESTION_MESSAGE);
        
        int loadLimit = Integer.parseInt(loadLimitStr);
        int numberParcel = Integer.parseInt(numberParcelStr);
        
        
    }

}
