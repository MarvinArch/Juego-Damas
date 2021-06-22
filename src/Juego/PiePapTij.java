package src.Juego;

public class PiePapTij {
    
    private static String[] arreglo = {"Piedra 0", "Papel -----", "Tijera 8<"};
    public PiePapTij(){

    }

    public static String Juego(String jug1, String Jug2){
        String ganador="no hay";
        boolean salir =false;
        System.out.println("\nIniciando Juego Piedra, Papel y Tijera");
        Datos.IngresarCadena("Presione enter para Empezar");
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
            System.out.println("\nJugador "+jug1+" utilizo "+arreglo[tmp1]);
            System.out.println("Jugador "+Jug2+" utilizo "+arreglo[tmp2]);
            if (tmp1==0 && tmp2==2) tmp1=3;
            if (tmp2==0 && tmp1==2) tmp2=3;
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
        return ganador;
    }

    public static String EscogerFichas(String jugador){
        String fichas;
        String tmp=Datos.IngresarCadena("Jugador "+jugador +" Con que fichas desea jugar Blancas o Negras");
        if (tmp.equalsIgnoreCase("blancas")) {
            fichas="Blancas";
        } else {
            fichas="Negras";
        }
        return fichas;
    } 
}
