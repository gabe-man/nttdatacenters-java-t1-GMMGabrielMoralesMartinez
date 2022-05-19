package nttdata.javat1.game;

public class GameOverHole {
	private int posX;
	private int posY;
	private int width;
	
	/**
	 * Constructor del agujero de fin de ronda
	 */
	public GameOverHole() {
		super();
		this.posX = 20;
		this.posY = 10;
		this.width = 10;
	}
	
	/**
	 * Comprueba si la bola se encuentra en el agujero de fin de ronda
	 * @param ball bola a comprobar
	 * @return boolean true si esta en el hoyo false si no
	 */
	public boolean checkBallInHole(Ball ball) {
		boolean inHole = false;
		
		if(ball.getPosX()>this.posX && ball.getPosX()<(this.posX+this.width) && ball.getPosY()==this.posY) {
			inHole = true;
		}
		
		return inHole;
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
