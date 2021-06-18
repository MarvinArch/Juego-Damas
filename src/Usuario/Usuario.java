package src.Usuario;

public class Usuario{
	private String nombre;
	private int jugadas;
	private int ganadas;

	public Usuario(){

	}
	public Usuario(String nombre){
		this.nombre=nombre;
		jugadas=0;
		ganadas=0;
	}

	public String getNombre(){
		return nombre;
	}

	public String getDatos(){
		String linea = "Nombre: "+nombre + " Partidas Jugadas: " +jugadas+" Partidas Ganadas: "+ganadas;
		return linea;
	}
}