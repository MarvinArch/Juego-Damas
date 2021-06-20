package src.Usuario;

import src.Juego.Datos;

public class ArregloUsuario{
	
	private Usuario[] var = new Usuario[5];
	private int conta=0;
	private int jugador1, jugador2;
	public ArregloUsuario(){

	}

	public void CrearArreglo(String nombre){
		if (conta<5) {
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
		String jug;
		System.out.println("Eliga 2 jugadores para la partida");
		jug=Datos.IngresarCadena("Ingrese Nombre del jugador");
		if(num==1){
			jugador1 = ComprobarUsuario(jug);
		}else{
			jugador2 = ComprobarUsuario(jug);
		}
		return jug;
	}

	public int ComprobarUsuario(String nombre){
		int num=-1;
		for (int i = 0; i < conta; i++) {
			if(var[i].getNombre().equalsIgnoreCase(nombre)){
				num=i;
			}
		}
		if (num<0) {
			System.out.println("El usuario no coincide con los usuarios en la lista");
			DefinirJugadores(num);
		}
		return num;
	}

	public void TurnoJugador(int jugador){
		if (jugador==1) {
			System.out.println("Turno Jugador "+var[jugador1].getNombre()+"\n");	
		}else{
			System.out.println("Turno Jugador "+var[jugador2].getNombre()+"\n");
		}
		
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
}