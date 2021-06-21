package src.Juego;
import java.util.*;

public class Datos {
    static Scanner leer= new Scanner(System.in);
    static String[] arreglo={"A","B","C","D","E","F","G","H"};

    public static String IngresarCadena(String mensaje){
        System.out.print("\n"+mensaje+" ");
        String respuesta =leer.nextLine();
        return respuesta;
    }

    public static int IngresoNumeros(String mensaje){
        int num=-1;
        String tmp;
        System.out.print("\n"+mensaje+" ");
        int tmp1=leer.nextInt();
        tmp=leer.nextLine();
        if (tmp1>=0){
            num=tmp1;
        }
        return num;
    }

    public static int ConvertirNumero(String combinacion){
        int posicionX=-1;
        for (int i = 0; i < arreglo.length; i++) {
            if (combinacion.equalsIgnoreCase(arreglo[i])) {
                posicionX=i;
            }
        }
        return posicionX;
    }
    public static String ConvertirLetra(int num){
        String letra=arreglo[num];
        return letra;
    }
}
