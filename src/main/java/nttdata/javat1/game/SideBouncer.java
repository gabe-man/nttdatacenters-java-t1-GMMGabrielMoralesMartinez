package nttdata.javat1.game;

public class SideBouncer {
	private int posX;
	private int posY;
	private int height;
	private boolean bounced;
	
	/**
	 * Constructor de los side bouncers
	 * @param posX coordenada X del side bouncer
	 * @param posY coordenada y del side bouncer
	 */
	public SideBouncer(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.height = 10;
		this.bounced = false;
	}
	
	/**
	 * Comprueba si la bola rebota sobre el side bouncer
	 * @param ball bola a comprobar el rebote
	 * @return boolean true si rebota false si no
	 */
	public boolean checkBounced(Ball ball)
	{
		boolean bounced = false;
		
		if(ball.getPosX()==this.posX && ball.getPosY()>=this.posY && ball.getPosY()<=(this.posY+this.height))
		{
			bounced = true;
			this.bounced=!isBounced();
		}
		
		return bounced;
		
	}
	
	/**
	 * Añade los puntos base de chocar contra un side bouncer
	 * @return 50 puntos
	 */
	public int addPoints() {
		return 150;
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isBounced() {
		return bounced;
	}

	public void setBounced(boolean bounced) {
		this.bounced = bounced;
	}
	
	
	
	

}
