public class Player {

	/**
	 * @param args
	 */
	private static int pId = 0;
	private String name;
	private Team team;

	private void setName(String name) {
		this.name = name;
	}

	public static Player getPlayer(Team team) {
		pId++;
		Player temp = new Player();
		temp.setName("Player " + pId);
		temp.team = team;
		return temp;
	}

	public static Player getPlayer(String name, Team team) {
		pId++;
		Player temp = new Player();
		temp.setName(name);
		temp.team = team;
		return temp;
	}

}
