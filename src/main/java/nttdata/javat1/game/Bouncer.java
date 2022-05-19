package nttdata.javat1.game;

public class Bouncer {
	private int posX;
	private int posY;
	private int width;
	private int height;
	private boolean bounced;
	
	/**
	 * Constructor de un bouncer. Crea bouncer de 10x10 con unas coordenadas.
	 * @param posX coordenada X
	 * @param posY coordenada Y
	 */
	public Bouncer(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.width = 10;
		this.height = 10;
		this.bounced = false;
	}
	
	/**
	 * Comprueba si la bola ha rebotado con el bouncer
	 * @param ball bola a comprobar si ha rebotado
	 * @return boolean true si ha rebotado false si no ha rebotado
	 */
	public boolean checkBounce(Ball ball)
	{
		boolean bounced = false;
		
		if(ball.getPosX()>=this.posX && ball.getPosX()<=(this.posX+this.width) && ball.getPosY()>=this.posY && ball.getPosY()<=(this.posY+this.height))
		{
			bounced = true;
			this.bounced=!isBounced();
		}
		
		return bounced;
	}
	
	/**
	 * Añade los puntos base que corresponde al rebote del bouncer
	 * @return 250 puntos
	 */
	public int addPoints()
	{
		return 250;
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
