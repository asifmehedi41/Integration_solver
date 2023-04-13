public class Part_var_const {
    String s;
    String vr ="";
    String cn ="";
    Part_var_const(String s){
        this.s = s;
        partition_var_const();
        //System.out.println("Inside part var const "+cn+" "+vr);

    }

    //VARIABLE PART IS SEPERATED FROM THE CONSTANT PART HERE AND KEPT IN VR AND CONSTANT PART IN CN.
    void partition_var_const(){
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            if(!Character.isDigit(c) && c!='+' && c!='-' ){
                vr = s.substring(i);
                cn = s.substring(0,i);
                break;
            } else if (i==(s.length()-1)) {
                cn = s;
            }
        }
    }

    //COMPLEX PART IS STILL IN DEVELOPMENT
    public static boolean  complexTerm(String v){
        String p1,p2;
        for(int i=0; i<v.length(); i++){
            if(v.charAt(i) == '*' || v.charAt(i) == '/'  ){
                p1 = v.substring(0, i);
                p2 = v.substring(i);
                if(p1.contains("x") && p2.contains("x")){
                    System.out.println("This "+v+" term is complex");
                    return true;
                }
            }
        }
        System.out.println("This "+v+" term is not complex");
        return false;
    }
}
