package src.Usuario;

import src.Juego.Datos;

public class ArregloUsuario{
	
	private Usuario[] var = new Usuario[10];
	private int conta=0;
	private int jugador1=-1, jugador2;
	public ArregloUsuario(){

	}
	
	public void CrearArreglo(String nombre){
		if (conta<10) {
			var[conta]=new Usuario(nombre);
			conta++;
		}else{
			System.out.println("Se ha superado el maximo de Usuarios");
		}
	}
	public void ImprimirDatos(){
		for (int i = 0; i < conta; i++) {
			System.out.println(var[i].getDatos());
		}
	}
	
	public int getConta() {
		return conta;
	}

	public String DefinirJugadores(int num){
		String jug="";
		boolean salir=false;
		while (salir==false) {
			System.out.println("\nSe nesecitan 2 jugadores para la partida");
			jug=Datos.IngresarCadena("Ingrese Nombre del jugador No."+num);
			int tmp2=ComprobarUsuario(jug,num);
			if(num==1 && tmp2>=0){
				jugador1 = tmp2;
				jug=var[jugador1].getNombre();
				salir=true;
			}else if(num==2 && tmp2>=0 && tmp2!=jugador1){
				jugador2 = tmp2;
				jug=var[jugador2].getNombre();
				salir=true;
			}
		}
		return jug;
	}
  //8<
	public int ComprobarUsuario(String nombre, int num){
		int num1=-1;
		for (int i = 0; i < conta; i++) {
			if(var[i].getNombre().equalsIgnoreCase(nombre)){
				num1=i;
			}
		}
		if (num1<0) System.out.println("El usuario no coincide con los usuarios en la lista");
		if (num1==jugador1) System.out.println("El usuario ingresado ya fue elegido"); 
		return num1;
	}

	public void AcreditarPartidaGanada(String nombre){
		for (int i = 0; i < conta; i++) {
			if (nombre.equalsIgnoreCase(var[i].getNombre())) {
				var[i].ResultadoPartida(1, 1);
			}
		}
	}

	public void AcreditarPartidaPerdida(String nombre , String jug1, String jug2){
		if (nombre.equalsIgnoreCase(jug1) ) {
			nombre=jug2;
		}else if (nombre.equalsIgnoreCase(jug2)){
			nombre=jug1;
		}
		for (int i = 0; i < conta; i++) {
			if (nombre.equalsIgnoreCase(var[i].getNombre())) {
				var[i].ResultadoPartida(0, 1);
			}
		}
	}
	
	public void OrdenarPorPartidas(){
		Usuario[] ordenado = new Usuario[conta];
		for (int i = 0; i < conta; i++) {
			ordenado[i]=var[i];
		} 
		for (int i = 0; i < conta; i++) {
			boolean salir=false;
			for (int j = 0; j < (conta-1); j++) {
				if (ordenado[j+1].getGanadas()>ordenado[j].getGanadas()) {
					Usuario temp = ordenado[j+1];
					ordenado[j+1]=ordenado[j];
					ordenado[j]=temp;
					salir =true;
				}
			}
			if (salir==false) {
				i=9;
			}
		}
		for (int i = 0; i < conta; i++) {
			System.out.println(ordenado[i].getDatos());
		}

	}
	// arreglo de usuario pruebas
	public void Puebas(){
		conta=8;
		var[0]=new Usuario("Casimiro", 5, 3);
		var[1]=new Usuario("Zaira", 4, 2);
		var[2]=new Usuario("Maria", 10, 7);
		var[3]=new Usuario("Markel", 8, 3);
		var[4]=new Usuario("Dionisio", 4, 1);
		var[5]=new Usuario("Maribel", 7, 5);
		var[6]=new Usuario("Marina", 9, 4);
		var[7]=new Usuario("Valeriano", 7, 2);
	}
}