package src.Juego;
import java.util.*;

import src.Casilla.Tablero;
import src.Usuario.ArregloUsuario;
import src.Usuario.Usuario;

public class Inicio{
	private int conta=0;
	private Tablero var= new Tablero();
	private ArregloUsuario var2 = new ArregloUsuario();
	
	public static void main(String[] args) {
		Inicio inicio= new Inicio();
	}

	public Inicio(){
		Menu();
	}

	public void Menu(){
		boolean salir=false;
		do{
			System.out.println("\n-------------Menu Damas-------------");
			System.out.println("Opcion No.1: Crear Usuarios");
			System.out.println("Opcion No.2: Nuevo Juego");
			System.out.println("Opcion No.3: Mostrar Usuarios");
			System.out.println("Opcion No.4: Mostrar Usuarios Ordenado por partidas ganadas");
			System.out.println("Opcion No.5: Salir");
			int opcion = Datos.IngresoNumeros("Escoga una opcion");
			switch (opcion){
				case 1:
						CrearUsuario();
						break;
				case 2:
						NuevoJuego();
						break;
				case 3:
						var2.ImprimirDatos();
						break;
				case 4:
						var2.OrdenarPorPartidas();
						break;
				case 5:
						salir=true;
				case 100:
						var2.Puebas();
						break;
			}
		}while(salir==false);
	}


	public void CrearUsuario(){
		String nombre=Datos.IngresarCadena("Ingrese nombre Jugador "+(var2.getConta()+1)+"  "); 
		var2.CrearArreglo(nombre);
		conta++;
	}
	public void NuevoJuego(){
		int tmp=var2.getConta();
		if (tmp>1) {
			Juego();
		}else{
			System.out.println("\nNo hay suficientes jugadores en la lista");
			CrearUsuario();
			NuevoJuego();
		}
	}
	public void Juego(){
		boolean ganador=false;
		var2.ImprimirDatos();
		String jug1=var2.DefinirJugadores(1);
		String jug2=var2.DefinirJugadores(2);
		int turno= EscogerFichas(jug1, jug2);
		String jugador;
		if (turno==1) {
			jugador=jug1;
		}else{
			jugador=jug2;
		}
		do{
			ganador = var.Juego(jugador);
			if (turno==1) {
				turno=2;
				jugador=jug2;
			} else {
				turno=1;
				jugador=jug1;
			}
			
		}while(ganador==false);
		String win=var.getGanador();
		var2.AcreditarPartidaGanada(win);
		System.out.println("\n"+"Felicidades el Ganador de la partida es "+win+"\n"+"\n");
		var2.AcreditarPartidaPerdida(win, jug1, jug2);
		
	}

	public int EscogerFichas(String jug1,String jug2){
		int turno;
		String juego=PiePapTij.Juego(jug1, jug2);
		String fichas=PiePapTij.EscogerFichas(juego);
		if ((juego.equalsIgnoreCase(jug1) && fichas.equalsIgnoreCase("negras")) ||(juego.equalsIgnoreCase(jug2) && fichas.equalsIgnoreCase("blancas"))) {
			var.DefinirBlancas(jug2, jug1);
		}else if((juego.equalsIgnoreCase(jug1) && fichas.equalsIgnoreCase("Blancas"))||(juego.equalsIgnoreCase(jug2) && fichas.equalsIgnoreCase("negras"))){
			var.DefinirBlancas(jug1, jug2);
		}
		if (juego.equalsIgnoreCase(jug1)) {
			turno=1;
		}else{
			turno=2;
		}
		return turno;
	}
	
}