public class ConstantPart {
    String cst;
    int con = 0;
    int sign = 1;
    ConstantPart(String cst){
        this.cst = cst;
        con = calcConst(cst);

    }

    //IT CALCULATES THE SIGNED NUMBER FROM A STRING
    public static int calcConst(String cst){
        int cn = 0;
        int sn = 1;

        if(!cst.equals("")){
            if(cst.charAt(0) == '+'){
                cst = cst.substring(1);
            } else if (cst.charAt(0) == '-') {
                sn = -1;
                cst = cst.substring(1);
            }
            if(!cst.equals("")){
                for(int i=0; i< cst.length(); i++){
                    char c = cst.charAt(i);
                    int a =(c-'0');
                    cn = cn* 10 + a;
                }
            }else cn = 1;
            cn*=sn;

            //System.out.println(con);
        }
        else{
            cn= 1;
        }
        return cn;
    }

    int getCon(){
        return con;
    }
}
