package nttdata.javat1.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
	private Board board;
	private Player player;
	private List<Ball> ballList;
	private int score;
	private int multiplyierBouncers;
	private int multiplyierRightSideBouncers;
	private int multiplyierLeftSideBouncers;
	private boolean finished;

	/**
	 * Constructor del juego.
	 * 
	 * @param board tablero de juego
	 */
	public Game(Board board) {
		super();
		this.board = board;
		this.player = new Player();
		this.ballList = new ArrayList<Ball>();
		this.score = 0;
		this.finished = false;
		this.multiplyierBouncers = 1;
		this.multiplyierLeftSideBouncers = 1;
		this.multiplyierRightSideBouncers = 1;

	}

	/**
	 * Metodo que simula la partida entera
	 */
	public void launchAndStart() {

		Scanner sc = new Scanner(System.in);

		String name = welcome(sc);
		System.out.println("¿De cuanto dinero dispone?");

		int money = askMoney(sc);

		this.player = new Player(name, money);

		System.out.println("¿Cuantas bolas quieres comprar?");

		int nBalls = askBalls(sc);

		addBalls(nBalls);

		System.out.println("Va a empezar la partida");

		for (int i = 0; i < ballList.size(); i++) {

			resetBoard();

			System.out.println("Se lanza la " + (i + 1) + "ª bola.");

			while (!this.finished) {
				ballList.get(i).setPosX((int) (Math.random() * (this.board.getWidth() + 1)));
				ballList.get(i).setPosY((int) (Math.random() * (this.board.getHeight() + 1)));

				checkBouncerList(i);

				checkRightBouncerList(i);

				checkLeftBouncerList(i);

				checkRightPaddle(sc, i);

				checkLeftPaddle(sc, i);

				checkGameOverHole(i);

			}
		}

		System.out.println("Se le han acabado las bolas.");

		System.out.println("Su puntuacion es de " + this.score + "puntos");
		
		sc.close();

	}
	
	/**
	 * Comprueba si la bola se encuentra en el agujero de game over, terminando con esa bola si es así
	 * @param i bola en juego
	 */
	public void checkGameOverHole(int i) {
		if (this.board.getGameOverHole().checkBallInHole(ballList.get(i))) {
			this.finished = true;
			System.out.println("La bola ha caido por el agujero.");
		}
	}
	
	/**
	 * Comprueba si la bola se encuentra cerca de la paleta izquierda y si es asi pregunta si quiere golpearla
	 * @param sc scanner que registra las respuestas del usuario
	 * @param i bola en juego
	 */
	public void checkLeftPaddle(Scanner sc, int i) {
		if (this.board.getLeftPaddle().checkBallNear(ballList.get(i))) {
			if (this.board.getLeftPaddle().askUserHitBall(sc)) {
				score += this.board.getLeftPaddle().addPoints() * this.multiplyierBouncers * this.multiplyierLeftSideBouncers * this.multiplyierLeftSideBouncers;
				
				System.out.println("+" + (this.board.getLeftPaddle().addPoints() * this.multiplyierBouncers * this.multiplyierLeftSideBouncers * this.multiplyierLeftSideBouncers) + " puntos");
				
			} else {
				this.finished = true;
				
				System.out.println("La bola ha caido por el agujero");
			}

		}
	}
	
	/**
	 * Comprueba si la bola se encuentra cerca de la paleta derecha y si es asi pregunta si quiere golpearla
	 * @param sc
	 * @param i
	 */
	public void checkRightPaddle(Scanner sc, int i) {
		if (this.board.getRightPaddle().checkBallNear(ballList.get(i))) {
			if (this.board.getRightPaddle().askUserHitBall(sc)) {
				score += this.board.getRightPaddle().addPoints() * this.multiplyierBouncers * this.multiplyierLeftSideBouncers * this.multiplyierLeftSideBouncers;
				
				System.out.println("+" + (this.board.getRightPaddle().addPoints() * this.multiplyierBouncers * this.multiplyierLeftSideBouncers * this.multiplyierLeftSideBouncers) + " puntos");
			} else {
				this.finished = true;
			}

		}
	}
	
	/**
	 * Comprueba si la bola rebota con cada bouncer izquierdo y si es asi añade los puntos pertinentes
	 * @param i bola en juego
	 */
	public void checkLeftBouncerList(int i) {
		int contLeftBouncer = 0;
		
		for (int j = 0; j < this.board.getLeftSideBouncerList().size(); j++) {
			if (this.board.getLeftSideBouncerList().get(j).checkBounced(ballList.get(i))) {
				System.out.println("Ha golpeado un Side Bouncer izquierdo");
				
				score += this.board.getLeftSideBouncerList().get(j).addPoints() * this.multiplyierBouncers * this.multiplyierLeftSideBouncers * this.multiplyierLeftSideBouncers;
				
				System.out.println("+" + (this.board.getLeftSideBouncerList().get(j).addPoints() * this.multiplyierBouncers * this.multiplyierLeftSideBouncers * this.multiplyierLeftSideBouncers) + " puntos");
			}

			if (this.board.getLeftSideBouncerList().get(j).isBounced()) {
				contLeftBouncer++;
			}

			if (contLeftBouncer == 3) {
				multiplyierLeftSideBouncers = 3;
			} else {
				multiplyierLeftSideBouncers = 1;
			}
		}
	}
	
	/**
	 * Comprueba si la bola rebota con cada bouncer derecho y si es asi añade los puntos pertinentes
	 * @param i bola en juego
	 */
	public void checkRightBouncerList(int i) {
		int contRightBouncer = 0;
		for (int j = 0; j < this.board.getRightSideBouncerList().size(); j++) {
			if (this.board.getRightSideBouncerList().get(j).checkBounced(ballList.get(i))) {
				System.out.println("Ha golpeado un Side Bouncer derecho");
				
				score += this.board.getRightSideBouncerList().get(j).addPoints() * this.multiplyierBouncers * this.multiplyierLeftSideBouncers * this.multiplyierRightSideBouncers;
				
				System.out.println("+" + (this.board.getRightSideBouncerList().get(j).addPoints() * this.multiplyierBouncers * this.multiplyierLeftSideBouncers * this.multiplyierLeftSideBouncers) + " puntos");
			}

			if (this.board.getRightSideBouncerList().get(j).isBounced()) {
				contRightBouncer++;
			}

			if (contRightBouncer == 3) {
				multiplyierRightSideBouncers = 3;
			} else {
				multiplyierRightSideBouncers = 1;
			}
		}
	}
	
	/**
	 * Comprueba si la bola rebota con cada bouncer y si es asi añade los puntos pertinentes
	 * @param i bola en juego
	 */
	public void checkBouncerList(int i) {
		int contBouncer = 0;
		for (int j = 0; j < this.board.getBouncerList().size(); j++) {
			if (this.board.getBouncerList().get(j).checkBounce(ballList.get(i))) {
				System.out.println("Ha golpeado un Bouncer");
				
				score += this.board.getBouncerList().get(j).addPoints() * this.multiplyierBouncers * this.multiplyierLeftSideBouncers * this.multiplyierRightSideBouncers;
				
				System.out.println("+" + (this.board.getBouncerList().get(j).addPoints() * this.multiplyierBouncers * this.multiplyierLeftSideBouncers * this.multiplyierLeftSideBouncers) + " puntos");
			}

			if (this.board.getBouncerList().get(j).isBounced()) {
				contBouncer++;
			}

			if (contBouncer == 4) {
				multiplyierBouncers = 10;
			} else {
				multiplyierBouncers = 1;
			}
		}
	}
	
	/**
	 * Resetea el tablero quitando multiplicadores y bonuses activos
	 */
	public void resetBoard() {
		this.finished = false;
		this.multiplyierBouncers = 1;
		this.multiplyierLeftSideBouncers = 1;
		this.multiplyierRightSideBouncers = 1;

		for (int j = 0; j < this.board.getBouncerList().size(); j++) {
			this.board.getBouncerList().get(j).setBounced(false);
		}

		for (int j = 0; j < this.board.getRightSideBouncerList().size(); j++) {
			this.board.getRightSideBouncerList().get(j).setBounced(false);
		}

		for (int j = 0; j < this.board.getLeftSideBouncerList().size(); j++) {
			this.board.getLeftSideBouncerList().get(j).setBounced(false);
		}
	}
	
	/**
	 * Añade las bolas elegidas por el jugador
	 * @param nBalls numero de bolas a jugar
	 */
	public void addBalls(int nBalls) {
		for (int i = 0; i < nBalls; i++) {
			player.payBall();
			Ball ball = new Ball();
			ballList.add(ball);
		}
	}
	
	/**
	 * Pregunta al usuario cuantas bolas quiere jugar
	 * @param sc scanner para registrar la respuesta del usuario
	 * @return int numero de bolas elegidas
	 */
	public int askBalls(Scanner sc) {
		boolean validateNBalls = false;
		boolean enoughMoney = false;
		int nBalls = 0;

		while (!enoughMoney) {
			validateNBalls = false;
			enoughMoney = false;

			while (!validateNBalls) {
				try {
					nBalls = Integer.parseInt(sc.nextLine());
					
					validateNBalls = true;
				} catch (Exception e) {
					System.out.println("Introduzca una cantidad valida");
					
					validateNBalls = false;
				}
			}

			if (nBalls <= player.getMoney()) {
				enoughMoney = true;
			} else {
				System.out.println("No tiene suficiente dinero ¿Cuantas bolas quiere?");
			}
		}
		return nBalls;
	}
	
	/**
	 * Le pregunta al usuario de cuanto dinero dspone
	 * @param sc scanner para registrar la respuesta del usuario
	 * @return int dinero del jugador
	 */
	public int askMoney(Scanner sc) {
		boolean validateMoney = false;
		int money = 0;

		while (!validateMoney) {
			try {
				money = Integer.parseInt(sc.nextLine());
				
				validateMoney = true;
			} catch (Exception e) {
				System.out.println("Introduzca una cantidad valida.");
				
				validateMoney = false;
			}
		}
		return money;
	}
	
	/**
	 * Le pregunta al usuario su nombre y le da la bienvenida
	 * @param sc scanner para registrar la respuesta del usuario
	 * @return String nombre del usuario
	 */
	public String welcome(Scanner sc) {
		System.out.println("Bienvenido al juego de pinball SuperBall. Por favor introduzca su nombre:");

		String name = sc.nextLine();

		System.out.println("Bienvenido " + name);

		return name;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<Ball> getBallList() {
		return ballList;
	}

	public void setBallList(List<Ball> ballList) {
		this.ballList = ballList;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getMultiplyierBouncers() {
		return multiplyierBouncers;
	}

	public void setMultiplyierBouncers(int multiplyierBouncers) {
		this.multiplyierBouncers = multiplyierBouncers;
	}

	public int getMultiplyierRightSideBouncers() {
		return multiplyierRightSideBouncers;
	}

	public void setMultiplyierRightSideBouncers(int multiplyierRightSideBouncers) {
		this.multiplyierRightSideBouncers = multiplyierRightSideBouncers;
	}

	public int getMultiplyierLeftSideBouncers() {
		return multiplyierLeftSideBouncers;
	}

	public void setMultiplyierLeftSideBouncers(int multiplyierLeftSideBouncers) {
		this.multiplyierLeftSideBouncers = multiplyierLeftSideBouncers;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

}
