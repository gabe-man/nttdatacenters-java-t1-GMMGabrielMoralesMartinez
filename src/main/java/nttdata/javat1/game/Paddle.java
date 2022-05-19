package nttdata.javat1.game;

import java.util.Scanner;

public class Paddle {
	private int posX;
	private int posY;
	private int width;
	
	/**
	 * Constructor de la paleta
	 * @param posX coordenada x de la paleta
	 */
	public Paddle(int posX) {
		super();
		this.posX = posX;
		this.posY = 0;
		this.width = 20;
	}
	
	/**
	 * Comprueba si una bola se encuentra cerca de la paleta 
	 * @param ball bola a comprobar
	 * @return boolean true si está cerca false si no
	 */
	public boolean checkBallNear(Ball ball) {
		
		boolean near = false;
		
		if(ball.getPosX()>=this.posX && ball.getPosX()<=(this.posX+this.width) && ball.getPosY()==0) {
			near = true;
		}
		
		return near;
	}
	
	/**
	 * Pregunta al usuario si quiere golpear la bola
	 * @param sc scanner para registrar la respuesta del usuario
	 * @return boolean true si golpea false si no
	 */
	public boolean askUserHitBall(Scanner sc) {
		boolean hit = false;
		String answer = "";
		
		System.out.println("La bola se encuentra sobre una de las palas ¿Quiere golpearla? (s/n)");
		answer = sc.nextLine();
		
		while(!answer.equals("s") && !answer.equals("n")) {
			System.out.println("Introduce una respuesta valida. ¿Quiere golpear la bola?(s/n)");
			answer = sc.nextLine();
		}
		
		if(answer.equals("s"))
		{
			hit = true;
		}
		else
		{
			hit = false;
		}
		
		
		return hit;
	}
	
	public int addPoints() {
		return 50;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	
	
	

}
