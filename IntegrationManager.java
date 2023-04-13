import java.util.Vector;

public class IntegrationManager {

    Vector<String> cterms;
    Vector<Integer> ctermCons;
    Vector<String> ctermVars;
    String integrationResult = "";
    String stepByStep = "";
    int nlinec = 0;
    public String getIntegrationResult() {
        return integrationResult;
    }

    public String getStepByStep() {
        return stepByStep;
    }


    IntegrationManager(Vector<String> cterms, Vector<Integer> ctermCons, Vector<String> ctermVars){
        this.cterms = cterms;
        this.ctermCons = ctermCons;
        this.ctermVars =  ctermVars;
        System.out.println("\nIn integration Manager" + cterms+ "\n" + ctermVars + "\n " + ctermCons);
    }



    //WITH INTEGRATE FUNCTION FOR EACH TERM SIMPLE INTEGRATION IS DONE
    // THEY ARE COLLECTED TOGETHER IN A STRING TO FORM THE INTEGRATION RESULT.
    // STEP BY STEP STRING FORMS THE TERM WISE INTEGRATION.
    String integrate(){
        System.out.println();
        for(int i = 0; i<cterms.size(); i++){


            System.out.println(ctermCons.elementAt(i)+ctermVars.elementAt(i));
            IntegrateSimple integrateSimpleTerms = new IntegrateSimple(ctermVars.elementAt(i), ctermCons.elementAt(i));

            integrateSimpleTerms.IntegrateS();

            if(i==0){

                integrationResult += integrateSimpleTerms.result.substring(1) +" ";

                stepByStep+= "Term: ";
                if(ctermCons.elementAt(i)!= 1)
                    stepByStep += ctermCons.elementAt(i) + ctermVars.elementAt(i)+ " ";
                else stepByStep +=  ctermVars.elementAt(i)+ " ";

                stepByStep += "\n Intg: " + integrateSimpleTerms.result+"\n\n";
                continue;
            }
            integrationResult += integrateSimpleTerms.result + " ";
            nlinec += integrateSimpleTerms.result.length()+1;
            if(nlinec>35) {
                integrationResult += "\n\t";
                nlinec = 0;
            }
            stepByStep+= "Term: ";
            if(ctermCons.elementAt(i)!= 1)
                stepByStep += ctermCons.elementAt(i) + ctermVars.elementAt(i)+ " ";
            else stepByStep +=  ctermVars.elementAt(i)+ " ";

            stepByStep += "\n Intg: " + integrateSimpleTerms.result+"\n\n";
        }
        return integrationResult;
    }
}
