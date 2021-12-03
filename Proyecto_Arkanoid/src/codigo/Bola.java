package codigo;

import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GOval;

public class Bola extends GOval{
	int dx = 5; //Velocidad en el eje x
	int dy = 5; //Velocidad en el eje y

	public Bola(double width, double height, Color c) {
		super(width, height);
		setFillColor(c);
		setFilled(true);
	}

	public void muevete(Arkanoid ark){
		//Rebote con el techo
		if (getY() < 12){
			dy = dy * -1;
		}

		//Rebote con la pared dcha e izqda
		if (getX()+getWidth() > ark.ANCHO_PANTALLA -30 || getX() < 10){
			dx = dx * -1;
		}

		//Colisiones pelota
		if (checkColision(this.getX(), this.getY(), ark)){//esquina arriba izquierda
			if (checkColision(this.getX() + getWidth(), this.getY(), ark)){//esquina arriba derecha
				if (checkColision(this.getX(), this.getY()+getHeight(), ark)){ //esquina abajo izquierda
					if (checkColision(this.getX()+getWidth(), this.getY()+getHeight(), ark)){ //esquina abajo derecha

					}

				}

			}

		}
		//Mueve la bola en la dirección con los valores devueltos de checkColision
		move(dx,dy);
	}

	private boolean checkColision(double posx, double posy, Arkanoid ark){
		boolean noHaChocado = true;
		GObject auxiliar;

		auxiliar = ark.getElementAt(posx, posy);

		if (auxiliar == ark.miCursor){ //La pelota choca con el cursor
			dy = dy * -1;
			noHaChocado = false;
		}

		else if (auxiliar == null){//No habia nada donde chocó

		}

		else if (auxiliar instanceof Ladrillo){ //La pelota choca con un ladrillo

			if(posy > auxiliar.getY()+ auxiliar.getHeight() -2 && posy < auxiliar.getY() + auxiliar.getHeight() + 1 
					|| posy > auxiliar.getY()-1 && posy < auxiliar.getY()  + 2){//Si choca con la parte superior o inferior del ladrillo
				dy *= -1;
			} 
			else {//Si choca con un lateral del ladrillo 
				dx *= -1;
			}

			ark.miMarcador.incrementaMarcador(1);
			ark.remove(auxiliar); //Se borra el ladrillo

			noHaChocado = false;
		}
		return noHaChocado;
	}

}

