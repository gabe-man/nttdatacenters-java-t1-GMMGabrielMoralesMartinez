package nttdata.javat1.game;

public class Player {
	private String name;
	private int money;
	
	/**
	 * Constructor vacio del jugador
	 */
	public Player() {
		super();
	}

	/**
	 * Constructor del jugador con parametros
	 * @param name nombre del jugador
	 * @param money dinero del jugador
	 */
	public Player(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}
	
	/**
	 * Paga una bola que cuesta 1 euro
	 */
	public void payBall() {
		money--;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	
}
