package org.mcupdater.Yggdrasil;
/**
 * Identifies the game to authenticate for.
 * 
 * @author Scott M. Barbour
 *
 */
public class Agent {

	private final String name;
	private final int version;
	
	/**
	 * 
	 * @param name	The name of the Mojang game.
	 * @param version	The version of authentication (speculation)
	 */
	public Agent(String name, int version) {
		this.name=name;
		this.version=version;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getVersion() {
		return this.version;
	}
}
