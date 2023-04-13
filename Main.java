import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String s ="";
        //Scanner scan =  new Scanner(System.in);

        IntegrationSolverGUI gui = new IntegrationSolverGUI();
        gui.setVisible(true);

        s = "1/(1+x^2) + cosec5x+cot3x+tan5x+3cosx+7sinx+10/x+8cosx-5(secx)^2+(cosecx)^2+x^3+e^15x"; //TESTLINE

         //FUNCTION and CLASS CALL SEQUENCE
        //Main -> IntegrationSolverGUI -> TermSeperatorAndCalculator -> Calculation -> TermSeperatorAndCalculator -> IntegrationManager
        // -> IntegrateSimple - > varPart -> ConstantPart -> IntegrateSimple -> IntegrationManager -> TermSeperatorAndCalculator
        // -> IntegrationSolverGUI -> RESULT.


    }
}