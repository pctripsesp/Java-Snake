package snake2D;

import java.awt.Color;
import java.awt.Graphics;

public class Snake2d {
	/**
	 * Podemos usar Point para crear una posición, y poder usar sus métodos como "move"
	 */
	protected static int posX =0,posY=0;

	
	//Serpiente con posición inicial y vector de dirección
	protected Snake2d(Graphics s){
		
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
		
		
		s.setColor(Color.green);
		
		s.fillRect(posX, posY, 10, 10);
		
		

	}

	
	protected void mover2D(int keyCode){
		
		
		switch (keyCode) {
			//Izquierda
			case 37:
				this.posX-=10;
				break;
			//Abajo	
			case 38:
				this.posY-=10;
				break;
			//Derecha
			case 39:
				this.posX+=10;
				break;
			//Arriba
			case 40:
				this.posY+=10;
				break;
		default:
			break;
		}
		
	
	}
	
}
