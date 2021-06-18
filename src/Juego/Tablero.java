package src.Juego;

import src.Casilla.*;

public class Tablero{
	Casilla[][] tab;

	public Tablero(){
		ConstruirTablero();
		ImprimirTablero();
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
		for (int posY=0;posY<8 ;posY++ ) {
			for (int linea=0;linea<3 ;linea++ ) {
				for (int posX=0;posX<8 ;posX++ ) {
					System.out.print(""+tab[posY][posX].DevolverLinea(linea));
				}
				System.out.println("");
			}
			//System.out.println("");
		}
	}
}