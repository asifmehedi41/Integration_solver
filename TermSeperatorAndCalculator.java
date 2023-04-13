import java.util.Stack;
import java.util.Vector;

public class TermSeperatorAndCalculator {
    String rawExp;
    Vector<String> terms;
    Vector<Integer> termCons;
    Vector<String> termVars;

    Vector<String> cterms ;
    Vector<Integer> ctermCons ;
    Vector<String> ctermVars;

    String calcResult = "";
    String integrationResult = "";
    Stack stack = new Stack();

    String stepByStep = "";
    boolean cplx =false;

    TermSeperatorAndCalculator(String rawExp){
        this.rawExp = rawExp;
        terms = new Vector<String>();
        termCons = new Vector<Integer>();
        termVars = new Vector<String>();
    }

    //SEPERATING TERMS BASED ON THE '+' AND '-' SIGN.
    void seperateTerms(){
        ComplexPart complexPart; // using

        int lastop = 0;
        for (int i=0; i<rawExp.length(); i++){
            if(rawExp.charAt(i) == '(' || rawExp.charAt(i) == ')'){
                cplx = true;
                if(rawExp.charAt(i) == ')') stack.pop();
                else stack.push(rawExp.charAt(i));

            }
            if(i!=0 && (rawExp.charAt(i) == '+' || rawExp.charAt(i) == '-') &&  stack.empty()) {

                terms.add(rawExp.substring(lastop, i));
                lastop = i;

            }
        }
        terms.add(rawExp.substring(lastop, rawExp.length()));

        for(int i=0; i<terms.size();i++){
            seperaterTermConst(terms.elementAt(i));
        }
        System.out.println(terms+" terms \n"+termVars+ " term Vars \n" +termCons+" termcons \n");
    }

    //SEPERATING THE CONSTANT AND VARIBLE PART OF A TERM
    void seperaterTermConst(String sTerm){

        Part_var_const partTermVarConst = new Part_var_const(sTerm);
        ConstantPart constantPart = new ConstantPart(partTermVarConst.cn);
        termVars.add(partTermVarConst.vr);
        termCons.add(constantPart.getCon());
    }

    //SIMPLIFYING THE SIMILAR VARIABLES AND ADDING THEM
    void calculate(){

        Calculation calculation = new Calculation(terms,termCons, termVars);
        calculation.Calculate();
        cterms = calculation.getCterms();//(Vector<String>) terms.clone();
        ctermCons = calculation.getCtermCons();//(Vector<Integer>) termCons.clone();
        ctermVars =  calculation.ctermVars; //(Vector<String>) termVars.clone();
        System.out.println("\n" + cterms+ "\n" + ctermVars + "\n " + ctermCons);
        calculation.formCalcResult();
        calcResult = calculation.getCalcResult();
        System.out.println(ctermVars+" \n"+ctermCons);

    }

    //INTEGRATING THE SIMPLIFIED TERMS...
    void integrateS(){
        IntegrationManager integrationManager = new IntegrationManager(cterms, ctermCons, ctermVars);
        System.out.println();
        integrationManager.integrate();
        integrationResult = integrationManager.getIntegrationResult();
        stepByStep = integrationManager.getStepByStep();

    }
}
