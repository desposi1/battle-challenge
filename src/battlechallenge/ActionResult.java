package battlechallenge;

public class ActionResult {

	public static enum ShotResult {
		HIT, SUNK, MISS
	}
	
	private Coordinate coordinate;
	private ShotResult result;
	private int health;
	private int playerId;
	
	public Coordinate getCoordinate() {
		return coordinate;
	}

	public ShotResult getResult() {
		return result;
	}

	public int getHealth() {
		return health;
	}

	public int getPlayerId() {
		return playerId;
	}

	public ActionResult(Coordinate c, ShotResult result, int health, int playerId) {
		// TODO: Action Result constructor: validate input
		this.coordinate = c;
		this.result = result;
		this.health = health;
		this.playerId = playerId;
	}
	
}