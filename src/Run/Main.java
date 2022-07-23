package Run;

import Comparadores.CheckRes;
import Comparadores.Operandos;
import Procedimentos.Operacao;
import Screen.Clear;
import java.util.Scanner;
import static Screen.Clear.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CheckRes resFinal = new CheckRes();
        boolean loop = true;
        int cont = 0;
        System.out.println("** CALCULADORA **");
        while (loop){
            if (cont > 0){
                Clear.ClearScreen(0);
            }
            String res = scanner.nextLine();
            CheckRes.checkResValues(res);
            Object[] resFinal2 = resFinal.comparador(res);
            int num1 = (int) resFinal2[0];
            char op = (char) resFinal2[1];
            int num2 = (int) resFinal2[2];
            Operacao operador = Operandos.converter(op);
            Clear.ClearScreen();
            try{
                System.out.print(ANSI_ITALIC + ANSI_GREEN + res + ANSI_WHITE + " = " + operador.calculo(num1, num2));
                Clear.ClearScreen("");
            } catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
            cont++;
        }
    }
}