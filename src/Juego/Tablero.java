package src.Juego;

import src.Casilla.*;

public class Tablero{
	public static final String GREEN= "\u001B[43m";
	public static final String RESET = "\u001B[0m";
	public static final String LBLACK = "\u001B[30m";
	private Casilla[][] tab;

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
					tab[i][j]=new Casilla(i,j,true,false);
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
}