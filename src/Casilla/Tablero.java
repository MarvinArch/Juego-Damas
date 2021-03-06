package src.Casilla;


import src.Juego.Datos;

public class Tablero{
	public static final String GREEN= "\u001B[43m";
	public static final String RESET = "\u001B[0m";
	public static final String LBLACK = "\u001B[30m";
	private Casilla[][] tab;
	private String blancas;
	private String negras;
	private int lado=0;
	private int vertical=0;
	private int cBlancas;
	private int cNegras;
	private String ganador;
	private boolean sugerido=false;
	private boolean tiroE;
	

	public Tablero(){
		ConstruirTablero();
	}

	public void ConstruirTablero(){
		tab = new Casilla[8][8];
		for (int i=0;i<8 ;i++ ) {
			for (int j=0;j<8 ;j++ ) {
				if (((i==0 || i==2)&& j%2==0) ||(i==1 && j%2!=0)) {
					tab[i][j]=new Casilla(i,j,true,true);
				}else if (((i==5 || i==7)&& j%2!=0) ||(i==6 && j%2==0)){
					tab[i][j]=new Casilla(i,j,false,true);
				}else{
					tab[i][j]=new Casilla(i,j,false,false);
				}

			}
		}
	}
	public void ImprimirTablero(){
		int fila=1;
		System.out.println(GREEN+LBLACK+"    A       B       C       D       E       F       G       H    "+RESET);
		for (int posY=0;posY<8 ;posY++ ) {
			for (int linea=0;linea<3 ;linea++ ) {
				for (int posX=0;posX<8 ;posX++ ) {
					System.out.print(""+tab[posY][posX].DevolverLinea(linea));
					if (linea==1 && posX==7) {
						System.out.print(GREEN+LBLACK+fila+RESET);
						fila++;
					}else if(posX==7){
						System.out.print(GREEN+LBLACK+" "+RESET);
					}
				}
				System.out.println("");
			}
		}
	}

	public String getGanador(){
		return ganador;
	}

	public void DefinirBlancas(String blanca, String negra){
		this.blancas=blanca;
		this.negras=negra;
		cBlancas=12;
		cNegras=12;
		ganador="";
	}
	
	public String ColorFichas(String jugador){
		String fichas="";
		if (jugador.equalsIgnoreCase(blancas)) {
			fichas="Blancas";
		}else{
			fichas="Negras";
		}
		return fichas;
	}

	public boolean Juego(String jugador){
		boolean eganador=false;
		tiroE=false;
		ImprimirTablero();
		if (jugador.equalsIgnoreCase(blancas)) {
			ComprobarComer(false);
		}else if (jugador.equalsIgnoreCase(negras)){
			ComprobarComer(true);
		}
		MoverFicha(jugador);
		if (cBlancas==0) {
			ganador=negras;
			eganador=true;
		} else if(cNegras==0){
			ganador=blancas;
			eganador=true;
		}
		if (tiroE==true) Juego(jugador); 
		return eganador;
	}

	public void MoverFicha(String jugador){

		System.out.println("\n-----------Turno Jugador "+ jugador+" fichas "+ ColorFichas(jugador)+"-------");
		String lugarIni=Datos.IngresarCadena("Ingrese posicion actual de ficha a mover");
		int xIni=Datos.ConvertirNumero(lugarIni.substring(0, 1));
		int yIni=Integer.parseInt(lugarIni.substring(1, 2))-1;
		String lugarFin=Datos.IngresarCadena("Ingrese posicion final de ficha a mover");
		int xFin=Datos.ConvertirNumero(lugarFin.substring(0, 1));
		int yFin=Integer.parseInt(lugarFin.substring(1, 2))-1;
		if (jugador.equalsIgnoreCase(blancas)) {
			MoverBlancas(xIni, yIni, xFin, yFin,jugador);
		}else if (jugador.equalsIgnoreCase(negras)){
			MoverNegras(xIni, yIni, xFin, yFin,jugador);
		}

	}
	// Agregar Fichas Negras
	public void MoverBlancas(int posXI, int posYI, int posXF, int posYF, String jugador){
		boolean valido = ComprobarMovimiento(false, posXI, posYI, posXF, posYF, jugador);
		if (valido==true){
			tab[posYI][posXI].setNegro(false);
			tab[posYF][posXF].setNegro(false);
		}
		
	}
	// Agregar Fichas Negras
	public void MoverNegras(int posXI, int posYI, int posXF, int posYF, String jugador){
		boolean valido=ComprobarMovimiento(true, posXI, posYI, posXF, posYF, jugador);
		if(valido==true){
			tab[posYI][posXI].setNegro(false);
			tab[posYF][posXF].setNegro(true);
		}
		
	}

	public int DevolverLado(int posXI, int posXF){
		int lado=0;
		if (posXI-posXF<0) {
			lado=1;
		}else if (posXI-posXF>0)
			lado=-1;
		return lado;
	}

	public int DevolverVertical(int posYI, int posYF){
		int verti=0;
		if (posYI-posYF<0) {
			verti=1;
		}else if (posYI-posYF>0)
			verti=-1;
		return verti;
	}
	
	public boolean ComprobarMovimiento(boolean color,int posXI, int posYI, int posXF, int posYF, String jugador){
		boolean valido=false;
		boolean comer=false;
		//comprobar validez del Movimiento
		if (color==false && posYI-posYF==1 && Math.abs(posXI-posXF)==1) { //comprueba que el movimiento sea hacia arriba
			valido=true;
		}else if(color==true && posYF-posYI==1 && Math.abs(posXI-posXF)==1){//comprueba que el movimiento se hacia abajo
			valido=true;	
		}else if(Math.abs(posYI-posYF)==2 && Math.abs(posXI-posXF)==2){
			lado=DevolverLado(posXI, posXF);
			vertical=DevolverVertical(posYI, posYF);
			if (tab[posYI+vertical][posXI+lado].getOcupado()==true && tab[posYI+vertical][posXI+lado].getNegro()!=color){
				valido=true;
				comer=ComprobarComer(color,posXI, posYI, posXF, posYF); 
				
			}
		}

		if (tab[posYI][posXI].getNegro()==color && tab[posYI][posXI].getOcupado()==true && valido==true) {
			if (tab[posYF][posXF].getOcupado()==false) {
				tab[posYI][posXI].setOcupado(false);
				tab[posYF][posXF].setOcupado(true);
				if (comer==true) {
					tab[posYI+vertical][posXI+lado].setOcupado(false);
					tab[posYI+vertical][posXI+lado].setNegro(false);
					if (color==true) {
						cBlancas--;
						comer=false;
						tiroE=SegundoMovimiento(true, posXF, posYF,1);
						sugerido=false;
					}else if(color==false){
						cNegras--;
						comer=false;
						tiroE=SegundoMovimiento(color, posXF, posYF,-1);
						sugerido=false;
					}
				}
			}else{
				System.out.println("La casilla elegida esta ocupada");
				valido=false;
				MoverFicha(jugador);
			}
		}else{
			System.out.println("La casilla elegida es incorrecta");
			valido=false;
			MoverFicha(jugador);
		}
		return valido;
	}

	// ejecuta comer pieza contraria
	public boolean ComprobarComer(boolean color,int posXI, int posYI, int posXF, int posYF){
		boolean comer=false;
		lado=DevolverLado(posXI, posXF);
		vertical=DevolverVertical(posYI, posYF);
		if (tab[posYI+vertical][posXI+lado].getOcupado()==true && tab[posYI+vertical][posXI+lado].getNegro()!=color){
			comer=true;
		}
		int vertical=1;
		if (color==false) {
			vertical=-1;
		}
		return comer;
	}

	//comprueba al Inicio del turno si existen Fichas que puedan comer
	public boolean ComprobarComer(boolean color){
		vertical=1;
		if (color==false) {
			vertical=-1;
		}
		for (int i=0; i<8 ;i++ ) {
			for (int j=0; j<8 ;j++ ) {
				if ((color==true && i+2<=7)||(color==false && i-2>=0 )) {
					if (j+2<=7 && tab[i][j].getNegro()==color && tab[i][j].getOcupado()==true && tab[i+vertical][j+1].getOcupado()==true && tab[i+vertical][j+1].getNegro()!=color && tab[i+(2*vertical)][j+2].getOcupado()==false) {
						System.out.print("Movimiento Sugerido de ");
						sugerido=true;
						System.out.println(""+Datos.ConvertirLetra(j)+(i+1)+" hacia "+Datos.ConvertirLetra(j+2)+(i+(2*vertical)+1));
					}
					if (j-2>=0 && tab[i][j].getNegro()==color && tab[i][j].getOcupado()==true && tab[i+vertical][j-1].getOcupado()==true && tab[i+vertical][j-1].getNegro()!=color && tab[i+(2*vertical)][j-2].getOcupado()==false){	
						System.out.print("Movimiento Sugerido de ");
						sugerido=true;
						System.out.println(""+Datos.ConvertirLetra(j)+(i+1)+" hacia "+Datos.ConvertirLetra(j-2)+(i+(2*vertical)+1));
					}
					
				}
			}
		}
		return sugerido;	
	}

	public boolean SegundoMovimiento(boolean color,int posXI, int posYI, int verticalp){
		boolean sMov=false;
		int i = posYI;
		int j = posXI;
		if ((color==true && i+2<=7)||(color==false && i-2>=0 )) {
			if (j+2<=7 && tab[i][j].getNegro()==color && tab[i][j].getOcupado()==true && tab[i+verticalp][j+1].getOcupado()==true && tab[i+verticalp][j+1].getNegro()!=color && tab[i+(2*verticalp)][j+2].getOcupado()==false) {
				sMov=true;
			}
			if (j-2>=0 && tab[i][j].getNegro()==color && tab[i][j].getOcupado()==true && tab[i+verticalp][j-1].getOcupado()==true && tab[i+verticalp][j-1].getNegro()!=color && tab[i+(2*verticalp)][j-2].getOcupado()==false){	
				sMov=true;
				System.out.println("entro");
			}
			
		}
		return sMov;
	}
}