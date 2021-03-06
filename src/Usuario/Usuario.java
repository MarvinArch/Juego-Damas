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
	//constructor para pruebas 
	public Usuario(String nombre, int jugadas, int ganadas){
		this.nombre=nombre;
		this.ganadas=ganadas;
		this.jugadas=jugadas;
	}

	public String getNombre(){
		return nombre;
	}

	public String getDatos(){
		int perdida= jugadas-ganadas;
		String linea = "Nombre: "+nombre + "    Partidas Jugadas: " +jugadas+"      Partidas Ganadas: "+ganadas+"        Partidas Perdidas: "+perdida;
		return linea;
	}

	public void ResultadoPartida(int ganada, int jugada){
		this.ganadas+=ganada;
		this.jugadas+=jugada;
	}

	public int getGanadas(){
		return ganadas;
	}
}