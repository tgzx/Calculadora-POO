package Comparadores;

public class CheckRes {
    public Object[] comparador(String res) {
        Object[] resFinal = new Object[3];
        char[] resChar = res.toCharArray();
        int cont = 0;
        int cont2= 0;

        for (int i = 0; i < resChar.length && "1234567890".contains(""+resChar[i]); i++) {
            cont++;
            cont2 = cont;
        }


        //----- Pega o PRIMEIRO numero -----//
        char[] numCompleto = new char[cont];
        for (int i = 0; i < cont; i++) {
            numCompleto[i] = resChar[i];
        }
        String numString1 = new String(numCompleto);
        resFinal[0] = Integer.parseInt(numString1);

        //----- Pega o SEGUNDO numero -----//
        int positiveArray = resChar.length - (cont + 1);
        char[] numCompleto2 = new char[positiveArray];
        cont2 = cont2 + 1;
        for (int i = 0; i < numCompleto2.length; i++) {
            numCompleto2[i] = resChar[cont2 + i];
        }
        String numString2 = new String(numCompleto2);
        resFinal[2] = Integer.parseInt(numString2);
        resFinal[2] = ((int)resFinal[2] < 0 ? -(int)resFinal[2] : (int)resFinal[2]);

        //----- Pega o OPERADOR -----//
        resFinal[1] = resChar[cont];

        //----- Testa os Valores -----//
        //System.out.println(resFinal[0]);
        //System.out.println(resFinal[1]);
        //System.out.println(resFinal[2]);
        return resFinal;
    }

    public static void checkResValues(String res){
        if (!res.equals("")){
            char[] resChar = res.toCharArray();
            for (int i = 0; i < res.length(); i++) {
                if (!"1234567890+/*-%".contains(""+resChar[i])){
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}