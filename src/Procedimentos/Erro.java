package Procedimentos;

public class Erro implements Operacao{
    @Override
    public int calculo(int num, int num2) {
        throw new RuntimeException("Operador não cadastrado.");
    }
}