import java.util.Vector;

public class varPart {
    String vp;
    String fnc, cntn;

    Vector<String> bracketParts;
    int pow;
    String powOf= "";
    String powVar = "";



    int powConst = 1;
    int cmplx = 1;

    varPart(String vp){
        this.vp = vp;
        fnc = "";
        cntn = "";
        pow =1;
        varPartFunctionRegulator();
    }


    //HERE  WE SEPERATE THE VARIABLE FUNCTION AND CONTAINER
    void varPartFunctionRegulator(){
        //System.out.println(vp + " "+vp.length()+" "+ start);
        int lm = vp.length()-1;
        //System.out.println(lm);
        if(vp.contains("(") && processBracket(vp).contains("x") && (processBracket(vp).contains("+") || processBracket(vp).contains("-")))
        {cmplx =1;}
        if(vp.contains("(")) processBracket(vp);  //VARIABLE CONTAINS BRACKET. So process bracket in a seperate Function.

        if(vp.contains("^"))                        //VARIABLE CONTAINS Power. So process power in a seperate Function.
        {
            System.out.println("Contains power : " + vp);
            processPVar(vp);
        }


        else {                                      //For Normal Case.
            processNVar(vp);
        }
    }


    //IF THE VARIABLE CONTAINS BRACKET, THE CONTENT INSIDE THE VARIABLE IS SEPERATED AND SENT FOR NORMAL PROCESSING.
    String processBracket(String v){
        int s=0;
        int e=0;
        bracketParts = new Vector<String>();

        for(int i=0; i<v.length(); i++){
            if(v.charAt(i) == '('){
                s=i;
            }
            else if(v.charAt(i)==')'){
                bracketParts.add(v.substring(s+1,i));
            }
        }
        processNVar(bracketParts.elementAt(0));
        System.out.println(bracketParts.elementAt(0));
        return bracketParts.elementAt(0);
        //System.out.println(bracketParts);

    }

    //HERE THE NORMAL VARIABLES ARE PROCESSED TO FIND THE FUNCTION AND CONTAINER
    void processNVar(String v){
        //System.out.println(vp + " "+vp.length()+" "+ start);
        int lm = v.length()-1;
        //System.out.println(lm);
        //if(v.contains("^"))
            //call power function
            for(int i=lm; i>=0 ; i--) {
                if(v.charAt(i)=='x' || v.charAt(i)>='0' && v.charAt(i)<='9'){
                    continue;
                }
                else{

                    fnc = v.substring(0,i+1);
                    cntn = v.substring(i+1);

                    break;
                }
            }

        System.out.println(v + " "+ fnc +" "+ cntn);
    }


    //IF THE VARIABLE CONTAINS POWER THEN THE POWER  AND POWER OF WHICH VARIABLE IS FOUND.
    // AGAIN IF THE POWER CONTAINS THE VARIABLE THEN POWER CONSTANT IS IDENTIFIED.
    void processPVar(String v){
        ConstantPart pconst;
        for(int i=0; i<v.length();i++){
            if(v.charAt(i)=='^' ){
                if(!v.substring(i+1).contains("x"))
                {
                    pow = ConstantPart.calcConst(v.substring(i+1));
                    powOf = v.substring(0,i);
                }

                else{
                    processNVar(v);
                }
                if(v.substring(i+1).contains("x")){
                    powVar = v.substring(i+1);
                    powOf = v.substring(0,i);
                    Part_var_const partPowConst = new Part_var_const(powVar);
                    powVar = partPowConst.vr;
                    powConst = ConstantPart.calcConst(partPowConst.cn);
                    System.out.println("Power of  "+ powOf +" is "+powConst+ powVar+ "\n Here power variable is "+powVar+ " and constant "+powConst);
                    return;
                }

                break;
            }
        }
        System.out.println("Power of  "+ powOf +" is "+ pow);
    }
    String getFnc(){
        return fnc;
    }

    String getCntn(){
        return  cntn;
    }

    public int getPow() {
        return pow;
    }

    public String getPowOf() {
        return powOf;
    }

    public String getPowVar() {
        return powVar;
    }

    public int getPowConst() {
        return powConst;
    }


}
