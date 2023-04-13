import java.util.Stack;
import java.util.Vector;

public class ComplexPart {

    //COMPLEX PART IS STILL IN DEVELOPMENT
    String rawTerm = "";

    Stack brackets = new Stack();
    Stack<Integer> bracketId = new Stack<>();
    Vector<String> bterms;
    ComplexPart (String rawTerm){
        this.rawTerm = rawTerm;
        System.out.println(rawTerm);
        bterms = new Vector<>();
    }

    void seperateBrackets( ){
        for (int i=0; i<rawTerm.length(); i++){
            if(rawTerm.charAt(i) == '(' || rawTerm.charAt(i) == ')'){

                if(rawTerm.charAt(i) == ')') {

                    brackets.pop();
                    bterms.add(rawTerm.substring(bracketId.pop()+1,i));
                }
                else {
                    if(brackets.empty() && i!=0) {
                        bterms.add(rawTerm.substring(0,i));
                        checkIfFnc(bterms.elementAt(0));
                    }
                    //else bterms.add("1");
                    brackets.push(rawTerm.charAt(i));
                    bracketId.push(i);
                }

            }
        }

        System.out.println(bterms);
    }

    void checkIfFnc(String fncpart){
        String revFnc = new StringBuilder(fncpart).reverse().toString();
        System.out.println(revFnc);
        //for(int i = fncpart.length(); i >= 0; i--){
           // if(fncpart.charAt(i) == 'x' || (fncpart.charAt(i)>='0' && fncpart.charAt(i) <='9' )){

          //  }
       // }

        if (revFnc.startsWith("sin")||revFnc.startsWith("cos")||revFnc.startsWith("tan")||revFnc.startsWith("cot")||revFnc.startsWith("sec")||
                revFnc.startsWith("cosec")||revFnc.startsWith("/")||revFnc.startsWith("*")||revFnc.startsWith("ln")||revFnc.startsWith("log")||
                revFnc.startsWith ("^")){

        }
    }
}
