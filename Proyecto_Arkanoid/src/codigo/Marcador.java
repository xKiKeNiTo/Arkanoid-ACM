package codigo;

import java.awt.Color;
import java.awt.Font;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Marcador extends GRect{

	GLabel texto = new GLabel("");
	
	int puntuacion = 0;

	

	public Marcador(double width, double height) {
		super(width, height);
		texto.setLabel("0");
		texto.setColor(Color.WHITE);
		texto.setFont(new Font("Arial", Font.BOLD, 18));
	}

	public void incrementaMarcador(int puntos){
		//Suma 1 por cada valor que entre en la variable puntos a la variable puntuación
		puntuacion = puntuacion + puntos; 
		texto.setLabel("" + puntuacion);
	}

	public void addMarcador(Arkanoid arkanoid){
		arkanoid.add(texto, 700, 200);
	}

}
