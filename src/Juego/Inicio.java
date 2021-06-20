package src.Juego;
import java.util.*;

import src.Casilla.Tablero;
import src.Usuario.ArregloUsuario;

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
			System.out.println("Opcion No.4: Salir");
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
						salir=true;
			}
		}while(salir==false);
	}


	public void CrearUsuario(){
		String nombre=Datos.IngresarCadena("Ingrese nombre Jugador "+(conta+1)+"  "); 
		var2.CrearArreglo(nombre);
		conta++;
	}
	public void NuevoJuego(){
		int tmp=var2.getConta();
		if (tmp>1) {
			Juego();
		}else{
			System.out.println("No hay suficientes jugadores en la lista");
			CrearUsuario();
			NuevoJuego();
		}
	}
	public void Juego(){
		boolean ganador=false;
		String jug1=var2.DefinirJugadores(1);
		String jug2=var2.DefinirJugadores(2);
		int turno=1;
		String jugador=jug1;
		do{
			var2.TurnoJugador(turno);
			var.Juego(jugador);
			if (turno==1) {
				turno=2;
				jugador=jug2;
			} else {
				turno=1;
				jugador=jug1;
			}
		}while(ganador==false);
	}
}