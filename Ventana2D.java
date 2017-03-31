package snake2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.LineNumberInputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Ventana2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Marco2D();
	}
}


class Marco2D extends JFrame {
	
	Lamina2D lamina2D = new Lamina2D();
	
	public static int width=200,height=200;
	
	public Marco2D(){	

		setTitle("JUEGO 2D");
		setSize(width,height);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		Snake2d.listaPosiciones.add(new int[]{0,0});
		
		//Añadimos la lámina
		add(lamina2D);
		
		//Añadimos el evento de teclado, poniendo la lámina a la escucha
		addKeyListener(lamina2D);
		
	}
}


class Lamina2D extends JPanel implements ActionListener,KeyListener{
	
	protected static int keyCode;
	
	protected Snake2d serpiente;
	protected Manzana2d manzana;
	//Creamos el temporizador para hacer el repaint de la pantalla
	protected Timer timer = new Timer (100,this);
	
	/**
	 * Esta es la función que se ejecuta cada vez que se lo dice el timer
	 */
	protected void paintComponent(Graphics g){
	
		//ejecutamos la función super en primer lugar
		super.paintComponent(g);
		
		
		BufferedImage bufferImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
			
		Graphics2D g2 = (Graphics2D)bufferImage.getGraphics();
			
		
		
		//Pintamos el fondo
		g2.setColor(Color.black);
		g2.fillRect(0, 0, Marco2D.width, Marco2D.height);

		serpiente = new Snake2d(g2);
		
		//Comprobamos colisión
		if (serpiente.posX==manzana.posX && serpiente.posY==manzana.posY){
			
			int listaSize = Snake2d.listaPosiciones.size();
			
			manzana.cambioPosicionX(Marco2D.width);
			manzana.cambioPosicionY(Marco2D.height);
			
			//Añadimos la última posición a la lista
			Snake2d.listaPosiciones.add(new int[]{Snake2d.listaPosiciones.get(listaSize-1)[0],Snake2d.listaPosiciones.get(listaSize-1)[1]});
		}
		
		serpiente.mover2D(keyCode);
		
		manzana = new Manzana2d(g2);
		
		g.drawImage(bufferImage, 0, 0, null);
		
		
				
		timer.start();
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		this.repaint();
	}

	/**
	 * KeyListener methods
	 */
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		keyCode = e.getKeyCode();
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}
	
	
}




































