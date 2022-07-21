package Screen;

public class Clear {
    public static final String ANSI_GREEN = "\u001b[32m";
    public static final String ANSI_WHITE = "\u001B[0m";
    public static final String ANSI_ITALIC = "\u001B[3m";
        public static void ClearScreen(){
        for (int i = 0; i < 9; ++i){
            System.out.println(".");
        }System.out.println("\u001B[100m \"C:\\Program Files\\Java\\jdk1.8.0_291\\bin\\java.exe\" ...");
        System.out.println(ANSI_WHITE + "** CALCULADORA **");
    }
    public static void ClearScreen(String clearFinal){
        for (int i = 0; i < 10; ++i) {
            System.out.println(".");
        }
    }
}