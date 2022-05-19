package nttdata.javat1;

import nttdata.javat1.game.Board;
import nttdata.javat1.game.Game;
import nttdata.javat1.game.Player;

public class MainApp {
	
	/**
	 * M�todo principal que crea una tablero y un nuevo juego y llama a la funci�n launchAndStart de la clase game
	 * @param args
	 */
	public static void main(String[] args) {
		Board board = new Board();
		Game game = new Game(board);
		
		game.launchAndStart();

	}

}
