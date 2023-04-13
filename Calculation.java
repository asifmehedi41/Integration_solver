import java.util.Vector;



public class Calculation {

    Vector<String> cterms;
    Vector<Integer> ctermCons;
    Vector<String> ctermVars;

    public String getCalcResult() {
        return calcResult;
    }

    String calcResult="";

    public Vector<String> getCterms() {
        return cterms;
    }

    public Vector<Integer> getCtermCons() {
        return ctermCons;
    }

    public Vector<String> getCtermVars() {
        return ctermVars;
    }
    int nlinec = 0;
    int pre = 0;

    Calculation(Vector<String> cterms, Vector<Integer> ctermCons, Vector<String> ctermVars ){
        this.cterms = cterms;
        this.ctermCons = ctermCons;
        this.ctermVars =  ctermVars;


    }


    //NORMAL ADDITION AND SUBTRACTION OCCURS HERE. FOR THE SAME VARIABLE TERMS.
    void Calculate(){
        int a,b;
        for(int i=0; i<cterms.size(); i++){
            for(int j=0; j<cterms.size(); j++){
                if(ctermVars.elementAt(i).equals(ctermVars.elementAt(j)) && i!=j){
                    // System.out.println(ctermVars+" \n"+ctermCons);
                    a = ctermCons.elementAt(i);
                    b= ctermCons.elementAt(j);
                    //System.out.println(a+" "+b+" "+(a+b));

                    ctermCons.set(i,a+b) ;
                    ctermVars.remove(j);
                    ctermCons.remove(j);
                    cterms.remove(j);
                    if(a+b == 0){
                        ctermVars.remove(i);
                        ctermCons.remove(i);
                        cterms.remove(i);
                    }
                    //System.out.println(ctermVars.elementAt(i)+" "+ctermCons.elementAt(i));
                }
            }
        }
        System.out.println(ctermVars+" \n"+ctermCons);
    }

    //CALC_RESULT STRING IS FORMED BASED ON THE RESULT OF CALCULATION.
    String formCalcResult( ){
        for(int i = 0; i<cterms.size(); i++){
            if(i>0){
                if(ctermCons.elementAt(i)>0 && i>0)
                    calcResult += " + ";
            }
            if(ctermCons.elementAt(i)!= 1)
                calcResult += ctermCons.elementAt(i) + ctermVars.elementAt(i)+ " ";
            else calcResult +=  ctermVars.elementAt(i)+ " ";

            nlinec += calcResult.length() - pre;
            if(nlinec>35){
                calcResult +="\n\t";
                nlinec = 0;
            }
            pre = calcResult.length();
        }
        return calcResult;
    }


}
