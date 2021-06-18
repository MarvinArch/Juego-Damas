package src.Juego;
import src.Usuario.*;

public class ArregloUsuario{
	
	private Usuario[] var = new Usuario[5];
	private int conta=0;
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
}