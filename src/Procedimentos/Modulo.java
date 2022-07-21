package Procedimentos;

public class Modulo implements Operacao{

    @Override
    public int calculo(int num, int num2) {
        return num % num2;
    }
}