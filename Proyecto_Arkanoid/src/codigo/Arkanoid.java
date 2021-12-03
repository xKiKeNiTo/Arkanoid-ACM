package codigo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Arkanoid extends GraphicsProgram{

	static final int ANCHO_LADRILLO = 35;
	static final int ALTO_LADRILLO = 15;
	static final int ANCHO_PANTALLA = 520;

	Bola bola1 = new Bola(10,10, Color.MAGENTA);
	Cursor miCursor = new Cursor(400, 60, 12, "imagenes/cursor.png");
	GImage fondo = new GImage("imagenes/background_arkanoid.png");
	Marcador miMarcador = new Marcador(20, 40);
	GLabel puntuacion = new GLabel("0");
	GImage fondoInicio = new GImage("imagenes/fondoInicio.png");
	GImage gameOver = new GImage("imagenes/gameOver.gif");
	GImage fondoDeMarcador = new GImage("imagenes/fondoMarcador.jpg");
	GLabel pressStart = new GLabel("");
	GLabel puntuacionEscrito = new GLabel("");
	GLabel arkanoidHeader = new GLabel("");
	GLabel nextLevel = new GLabel("");
	GImage nextLevelFondo = new GImage("imagenes/nextLevelFondo.jpg");
	

	public void init(){
		add(fondoInicio);
		pressStart.setLabel("Press Start");
		pressStart.setFont(new Font("Arkanoid Solid", Font.BOLD, 18));
		pressStart.setColor(Color.MAGENTA);
		puntuacionEscrito.setLabel("Puntuacion:");
		puntuacionEscrito.setColor(Color.WHITE);
		puntuacionEscrito.setFont(new Font("Arkanoid Solid", Font.BOLD, 14));
		arkanoidHeader.setLabel("ARKANOID");
		arkanoidHeader.setColor(Color.RED);
		arkanoidHeader.setFont(new Font("Arkanoid", Font.BOLD, 30));
		nextLevel.setLabel("Next Level");
		nextLevel.setColor(Color.CYAN);
		nextLevel.setFont(new Font("Arkanoid Solid", Font.BOLD, 30));
		add(pressStart, 315,240 );
		waitForClick();
		remove(fondoInicio);
		remove(pressStart);
		add(fondo);
		add(pressStart, 180, 240);
		addMouseListeners();
		add(bola1, 30, 260);
		add(miCursor);
		this.setSize(ANCHO_PANTALLA -30 + 300,500);	
		add(fondoDeMarcador, ANCHO_PANTALLA -20,0);
	}

	public void run(){
		creaNivel1();
		miMarcador.addMarcador(this);
		add(puntuacionEscrito, 550, 200);
		add(arkanoidHeader, 550, 50);
		waitForClick();
		remove(pressStart);
		while (true){
			bola1.muevete(this);
			pause(1);

			//AutoAim
			miCursor.muevete(ANCHO_PANTALLA -30, (int) bola1.getX());

			if(miMarcador.puntuacion == 91){
				removeAll();
				add(nextLevelFondo);
				add(nextLevel, 270, 200);
				add(pressStart,307, 240);
				waitForClick();
				remove(pressStart);
				remove(nextLevel);
				remove(nextLevelFondo);
				add(fondo);
				add(fondoDeMarcador, ANCHO_PANTALLA -20,0);
				creaNivel2();
				addMouseListeners();
				add(miCursor);
				add(bola1, 30, 250);	
				this.setSize(ANCHO_PANTALLA -30 + 300,500);
				miMarcador.addMarcador(this);
				add(pressStart, 180, 240);
				add(puntuacionEscrito, 550, 200);
				add(arkanoidHeader, 550, 50);
				miMarcador.puntuacion = 0;
				waitForClick();	
				remove(pressStart);
			}

			if(bola1.getY() > miCursor.getY()){
				removeAll();
				add(gameOver);
				miMarcador.puntuacion = 0;
				waitForClick();
				init();
				run();
			}

		}

	}

	public void mouseMoved(MouseEvent evento){
		miCursor.muevete (ANCHO_PANTALLA -30, evento.getX());
	}

	private void creaNivel1(){
		int numeroLadrillos = 13;
		int desplazamiento_inicial_X = 20;
		int desplazamiento_inicial_Y = 15;
		for (int j=0; j<numeroLadrillos; j++){
			for (int i=j; i<numeroLadrillos; i++){
				Ladrillo miLadrillo = new Ladrillo(ANCHO_LADRILLO*i - ANCHO_LADRILLO/2*j + desplazamiento_inicial_X, ALTO_LADRILLO*j + desplazamiento_inicial_Y, ANCHO_LADRILLO,ALTO_LADRILLO,Color.GREEN);
				add(miLadrillo);
			}

		}

	}
	
	private void creaNivel2(){

		for (int i = 0; i < 6; i++) {
			Ladrillo miLadrillo = new Ladrillo(ANCHO_LADRILLO*i +13, ALTO_LADRILLO + 15 , ANCHO_LADRILLO, ALTO_LADRILLO, Color.GREEN );
			add(miLadrillo);
		}


		for (int i = 0; i < 6; i++) {
			Ladrillo miLadrillo = new Ladrillo(ANCHO_LADRILLO*i + ANCHO_LADRILLO*8, ALTO_LADRILLO + 15 , ANCHO_LADRILLO, ALTO_LADRILLO, Color.GREEN );
			add(miLadrillo);
		}

		for (int i = 0; i < 6; i++) {
			Ladrillo miLadrillo = new Ladrillo(ANCHO_LADRILLO*i +13, ALTO_LADRILLO*3 + 15 , ANCHO_LADRILLO, ALTO_LADRILLO, Color.MAGENTA );
			add(miLadrillo);
		}

		for (int i = 0; i < 6; i++) {
			Ladrillo miLadrillo = new Ladrillo(ANCHO_LADRILLO*i + ANCHO_LADRILLO*8, ALTO_LADRILLO*3 + 15 , ANCHO_LADRILLO, ALTO_LADRILLO, Color.MAGENTA);
			add(miLadrillo);
		}

		for (int i = 0; i < 6; i++) {
			Ladrillo miLadrillo = new Ladrillo(ANCHO_LADRILLO*i +13, ALTO_LADRILLO*4 + 15 , ANCHO_LADRILLO, ALTO_LADRILLO, Color.MAGENTA );
			add(miLadrillo);
		}

		for (int i = 0; i < 6; i++) {
			Ladrillo miLadrillo = new Ladrillo(ANCHO_LADRILLO*i + ANCHO_LADRILLO*8, ALTO_LADRILLO*4 + 15 , ANCHO_LADRILLO, ALTO_LADRILLO, Color.MAGENTA );
			add(miLadrillo);
		}

		for (int i = 0; i < 6; i++) {
			Ladrillo miLadrillo = new Ladrillo(ANCHO_LADRILLO*i +13, ALTO_LADRILLO*6 + 15 , ANCHO_LADRILLO, ALTO_LADRILLO, Color.GREEN );
			add(miLadrillo);
		}

		for (int i = 0; i < 6; i++) {
			Ladrillo miLadrillo = new Ladrillo(ANCHO_LADRILLO*i + ANCHO_LADRILLO*8, ALTO_LADRILLO*6 + 15 , ANCHO_LADRILLO, ALTO_LADRILLO, Color.GREEN );
			add(miLadrillo);
		}

	}

}
