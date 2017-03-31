package snake2D;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Snake2d {
	/**
	 * Podemos usar Point para crear una posición, y poder usar sus métodos como "move"
	 */
	protected static int posX =0,posY=0, longitud=1;
	protected static List<int[]> listaPosiciones = new ArrayList<>();
	
	//Serpiente con posición inicial y vector de dirección
	protected Snake2d(Graphics s){
				
		s.setColor(Color.green);		
		
		for (int i=0; i<listaPosiciones.size();i++){
			
			s.fillRect(listaPosiciones.get(i)[0], listaPosiciones.get(i)[1], 10, 10);

		}
			
		
		
				

	}

	//Actualizamos las posiciones de la lista de la serpiente
	protected void actualizarPosiciones(){
		
		int listaSize = listaPosiciones.size();
		
		//Impedimos que la serpiente se salga del marco
				if (posX<0){
					posX=0;
							
				}else if (posX>Marco2D.width-10){
					posX=Marco2D.width-10;
					
				}
				
				//Lo mismo para el eje de las Y
				if (posY<0){
					posY=0;
					
				}else if (posY>Marco2D.height-50){
					
					posY=Marco2D.height-50;
				}
				
		//Actualizamos la lista
		if (listaSize>1){
			
			for (int i=listaSize-2; i>=0;i--){
				//Corremos una posición a la derecha cada elemento de la lista
				listaPosiciones.set(i+1, listaPosiciones.get(i));
				//Añadimos al comienzo de la lista la nueva posición
				listaPosiciones.set(0,new int[]{posX,posY});
				
			}
		}else{
			listaPosiciones.set(0,new int[]{posX,posY});
		}
	}
	
	
	protected void mover2D(int keyCode){
		
		
		switch (keyCode) {
			//Izquierda
			case 37:
				this.posX-=10;
				actualizarPosiciones();
				break;
			//Abajo	
			case 38:
				this.posY-=10;
				actualizarPosiciones();
				break;
			//Derecha
			case 39:
				this.posX+=10;
				actualizarPosiciones();
				break;
			//Arriba
			case 40:
				this.posY+=10;
				actualizarPosiciones();
				break;
		default:
			break;
		}
		
	
	}
	
}
