package src.Casilla;

public class Casilla{
	public static final String NEGRO = "\u001B[40m";
	public static final String RESET = "\u001B[0m";
	public static final String BLANCO = "\u001B[47m";
	public static final String ROJO = "\u001B[41m";
	public static final String LBLACK = "\u001B[30m";
	private int posX;
	private int posY;
	private boolean ocupado =false;
	private boolean negro;
	protected String[] figura={"|      |",
			  				   "|      |",
							   "|      |"};
	protected String[] fOcupadoN={"|   _  |",
			  				    "|  "+NEGRO+"(_)"+RESET+" |",
							    "|      |"};
	protected String[] fOcupadoB={"|   _  |",
			  				    "|  "+LBLACK+BLANCO+"(_) |",
							    "|      |"}; 
	 
	public Casilla(int posY, int posX, boolean negro, boolean ocupado){
	 	this.posX=posX;
	 	this.posY=posY;
	 	this.negro=negro;
	 	this.ocupado=ocupado;
	}

	public String DevolverLinea(int posicion){
		String pre;
		String linea;
		//Definir si el la casilla es blanco o roja
		if ((posY%2!=0 && posX%2!=0)|| (posY%2==0 && posX%2==0)) {
			pre=ROJO;
		}else{
			pre=BLANCO;
		}
		//Definir si existe ficha en la casilla
		if (ocupado==true) {
			if (negro==true) {
				linea=pre+fOcupadoN[posicion]+RESET;
			}else{
				linea=pre+fOcupadoB[posicion]+RESET;
			}
		}else{
			linea= pre+figura[posicion]+RESET;	
		}

		
		return linea;
	}
} 	