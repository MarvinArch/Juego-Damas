package src.Juego;
import java.util.*;

public class Inicio{
	static Scanner leer = new Scanner(System.in);
	private int conta=0;
	private Tablero var;
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
			System.out.println("-------------Menu Damas-------------");
			System.out.println("Opcion No.1: Crear Usuarios");
			System.out.println("Opcion No.2: Imprimir Tablero");
			System.out.println("Opcion No.3: Mostrar Usuarios");
			System.out.println("Opcion No.4: Salir");
			int opcion = leer.nextInt();
			String tmp= leer.nextLine();
			switch (opcion){
				case 1:
						CrearUsuario();
						break;
				case 2:
						var= new Tablero();
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
		System.out.print("\nIngrese nombre Jugador "+(conta+1)+"  ");
		String nombre= leer.nextLine();
		var2.CrearArreglo(nombre);
		conta++;
	}
}