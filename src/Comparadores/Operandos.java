package Comparadores;

import Procedimentos.*;

public class Operandos {
    public static Operacao converter(char operando) {
        if (operando == '+'){
            return new Adicao();
        } else if (operando == '-'){
            return new Subtracao();
        } else if (operando == '/'){
            return new Divisao();
        } else if (operando == '*'){
            return new Multiplicacao();
        } else if (operando == '%'){
            return new Modulo();
        } else {
            return new Erro();
        }
    }
}