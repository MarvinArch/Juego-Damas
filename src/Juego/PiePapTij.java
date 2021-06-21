package src.Juego;

public class PiePapTij {
    
    private static String[] arreglo = {"Piedra 0", "Papel -----", "Tijera 8<"};
    public PiePapTij(){

    }

    public static String Juego(String jug1, String Jug2){
        String ganador="no hay";
        boolean salir =false;
        System.out.println("\nIniciando Juego Piedra, Papel y Tijera");
        while(salir==false){
            for (int i = 0; i < 3; i++) {
                System.out.println(arreglo[i]);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 3; i++) {
                System.out.println(""+(i+1));
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            int tmp1 = (int)(Math.random()*3);
            int tmp2 = (int)(Math.random()*3);
            if (tmp1>tmp2) {
                ganador=jug1;
                salir=true;
            }else if(tmp2>tmp1){
                ganador=Jug2;
                salir=true;
            }else{
                System.out.println("ha habido un empate");
            }
        }
        System.out.println("Felicidades El jugador "+ ganador +" ha Ganado\n");
        Datos.IngresarCadena("Presione entre para Empezar");

        return ganador;
    }
}
