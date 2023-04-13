import java.util.Stack;
import java.util.Vector;

public class Postfix {
    String infix;
    String postfix;
    Vector<String> postfixV;
    Stack<Character> stackOp;
    char[] operators = {'(',')','{','}','[',']','/','*','+','-'};

    Postfix(String infix){
        this.infix =infix;
        stackOp = new Stack<Character>();
        postfixV = new Vector<String>();

    }

    String toPostfix(){

        for(char c: infix.toCharArray()){
            if(isOp(c)){
                stackOp.push(c);
                System.out.print(c+ " ");

            }
            else{
                postfixV.add(""+c);
            }
        }
        System.out.println("The Operator Stack is "+ stackOp);
        System.out.println("The postfix vector is "+ postfixV);


        return postfix;
    }

    boolean isOp(char o){
        boolean r = false;
        for(char op: operators){
            if(o == op) r = true;
        }

        return r;
    }
}
