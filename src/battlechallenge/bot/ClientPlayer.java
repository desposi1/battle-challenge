package battlechallenge.bot;

import java.util.LinkedList;
import java.util.List;

import battlechallenge.Coordinate;
import battlechallenge.ShipAction;
import battlechallenge.ShipIdentifier;
import battlechallenge.client.ClientGame;
import battlechallenge.ship.Ship;
import battlechallenge.ship.Ship.Direction;

/**
 * The Class ClientPlayer.
 */
public class ClientPlayer {

	/** The minerals. */
	protected int minerals;
	
	/** The player name. */
	protected final String playerName;
	
	/** The id to identify the player. */
	protected int networkID;

	/** The board width. */
	protected int boardWidth;

	/** The board height. */
	protected int boardHeight;
	
	/**
	 * Gets the minerals.
	 *
	 * @return the minerals
	 */
	public int getMinerals() {
		return minerals;
	}

	/**
	 * Sets the minerals.
	 *
	 * @param minerals the new minerals
	 */
	public void setMinerals(int minerals) {
		this.minerals = minerals;
	}

	/**
	 * Save the width of the game board.
	 *
	 * @param boardWidth the width of the game board
	 */
	public void setBoardWidth(int boardWidth) {
		this.boardWidth = boardWidth;
	}
	
	/**
	 * Save the height of the game board.
	 *
	 * @param boardHeight the height of the game board
	 */
	public void setBoardHeight(int boardHeight) {
		this.boardHeight = boardHeight;
	}
	
	/**
	 * Sets the network id.
	 *
	 * @param networkID the new network id
	 */
	public void setNetworkID(int networkID) {
		this.networkID = networkID;
	}
	
	/**
	 * Instantiates a new client player.
	 *
	 * @param playerName the player name
	 * @param mapWidth the map width
	 * @param mapHeight the map height
	 * @param networkID the network id
	 */
	public ClientPlayer(final String playerName, final int mapWidth, final int mapHeight, final int networkID) {
		this.playerName = playerName;
		this.boardWidth = mapWidth;
		this.boardHeight = mapHeight;
		this.networkID = networkID;
	}
	
	/**
	 * This class will be filled in by the player. All logic regarding in game decisions to be
	 * made by your bot should be put in here. This class will be called every turn until the
	 * end of the game
	 *
	 * @return a List of coordinates corresponding to where you wish to fire
	 */
	
	int count = 0;
	public List<ShipAction> doTurn() {
		List<ShipAction> actions = new LinkedList<ShipAction>();
		List<Coordinate> shotCoord = new LinkedList<Coordinate>();
		List<Direction> moveCoord = new LinkedList<Direction>();
//		shotCoord.add(null);
		shotCoord.add(new Coordinate(10,10));
		moveCoord.add(Direction.NORTH);
		ShipIdentifier shipID = null;
		int i = 0;
		for (Ship s: ClientGame.getMyShips()) {
			if (i == 0) {
				shipID = s.getIdentifier();
			}
			if (i > 0) {
				moveCoord.clear();
				moveCoord.add(Direction.SOUTH);
				shotCoord.add(new Coordinate(10,9));
			}
			actions.add(new ShipAction(shipID, shotCoord, moveCoord)); 
			i++;
		}
		count+= 200;
		if (count > 1000) {
			count = 0;
		}
		try {
			Thread.sleep(count); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actions;
	}
}

