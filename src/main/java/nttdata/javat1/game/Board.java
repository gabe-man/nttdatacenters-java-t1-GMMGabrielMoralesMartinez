package nttdata.javat1.game;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private int width;
	private int height;
	/**
	 * Lista con los bouncers del tablero
	 */
	private List<Bouncer> bouncerList;
	private List<SideBouncer> rightSideBouncerList;
	private List<SideBouncer> leftSideBouncerList;
	private Paddle rightPaddle;
	private Paddle leftPaddle;
	private GameOverHole gameOverHole;
	
	/**
	 * Constructor de la clase Board. Genera siempre el mismo board.
	 */
	public Board() {
		super();
		this.width=50;
		this.height=100;
		
		this.bouncerList= new ArrayList<Bouncer>();
		bouncerList.add(new Bouncer(20,70));
		bouncerList.add(new Bouncer(10,60));
		bouncerList.add(new Bouncer(30,60));
		bouncerList.add(new Bouncer(20,50));
		
		this.rightSideBouncerList= new ArrayList<SideBouncer>();
		rightSideBouncerList.add(new SideBouncer(this.width, 40));
		rightSideBouncerList.add(new SideBouncer(this.width, 50));
		rightSideBouncerList.add(new SideBouncer(this.width, 60));
		
		this.leftSideBouncerList= new ArrayList<SideBouncer>();
		leftSideBouncerList.add(new SideBouncer(0, 40));
		leftSideBouncerList.add(new SideBouncer(0, 50));
		leftSideBouncerList.add(new SideBouncer(0, 60));
		
		this.rightPaddle= new Paddle(30);
		this.leftPaddle= new Paddle(0);
		
		this.gameOverHole = new GameOverHole();
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

	public List<Bouncer> getBouncerList() {
		return bouncerList;
	}

	public void setBouncerList(List<Bouncer> bouncerList) {
		this.bouncerList = bouncerList;
	}

	public List<SideBouncer> getRightSideBouncerList() {
		return rightSideBouncerList;
	}

	public void setRightSideBouncerList(List<SideBouncer> rightSideBouncerList) {
		this.rightSideBouncerList = rightSideBouncerList;
	}

	public List<SideBouncer> getLeftSideBouncerList() {
		return leftSideBouncerList;
	}

	public void setLeftSideBouncerList(List<SideBouncer> leftSideBouncerList) {
		this.leftSideBouncerList = leftSideBouncerList;
	}

	public Paddle getRightPaddle() {
		return rightPaddle;
	}

	public void setRightPaddle(Paddle rightPaddle) {
		this.rightPaddle = rightPaddle;
	}

	public Paddle getLeftPaddle() {
		return leftPaddle;
	}

	public void setLeftPaddle(Paddle leftPaddle) {
		this.leftPaddle = leftPaddle;
	}

	public GameOverHole getGameOverHole() {
		return gameOverHole;
	}

	public void setGameOverHole(GameOverHole gameOverHole) {
		this.gameOverHole = gameOverHole;
	}
	
	
	
	

}
