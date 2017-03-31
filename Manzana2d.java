package snake2D;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Manzana2d {
	//Generamos coordenadas aleatorias
		public static int posX=100,posY=100;
		
		Random generadorRandom = new Random(); 
		
		public Manzana2d(Graphics a){
			
			
			a.setColor(Color.red);
			a.fillOval(posX, posY, 10, 10);
			
		}
		
		
		public void cambioPosicionX(int width){
			int tempPosX = 3;
			
			//Hacemos que la posición generada sea múltiplo de 10 (tamaño de la serpiente)
			while (tempPosX%10!=0){
				tempPosX = generadorRandom.nextInt(width-10);
			}
			posX = tempPosX;
			
		}
		
		public void cambioPosicionY(int height){
			int tempPosY = 3;
			
			while (tempPosY%10!=0){
				
				tempPosY = generadorRandom.nextInt(height-10);
			}
			
			posY = tempPosY;

		}
		
}
