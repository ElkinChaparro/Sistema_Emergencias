package images;

public class ConsoleColor {
     // color rojo para errores
    public static final String redColor = "\u001B[31m";
    // color verde
    public static final String greenColor = "\u001B[32m";
    // color naranja
    public static final String orangeColor = "\u001B[38;5;208m";
    // color cyan
    public static final String cyanColor = "\u001B[36m";
    // color azul
    public static final String blueColor = "\u001B[34m";
     // restablecer color
    public static final String resetColor = "\u001B[0m";

    // metodo para obtener el texto en color rojo
    public static String redText(String text){
        return redColor +  text + resetColor;
    }

    //metodo para obtener el texto en color verde
    public static String greenText(String text) {
        return greenColor + text + resetColor;
    }

    //metodo para obtener el texto en color naranja
    public static String orangeText(String text) {
        return orangeColor + text + resetColor;
    }

    //metodo para obtener el texto en color Cyan
    public static String cyanText(String text){
        return cyanColor + text + resetColor;
    }

    //metodo para obtener el texto en color azul
    public static String blueText(String text){
        return blueColor + text + resetColor;
    }
}
