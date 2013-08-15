package org.mcupdater.Yggdrasil;
/**
 * Initial authentication request
 * 
 * @author Scott M. Barbour
 *
 */
public class AuthRequest {
	@SuppressWarnings("unused")
	private Agent agent;
	private String username;
	@SuppressWarnings("unused")
	private String password;
	private String clientToken;
	
	/**
	 * Create a new authentication request.
	 * 
	 * @param agent
	 * @param username
	 * @param password
	 * @param clientToken
	 */
	public AuthRequest(Agent agent, String username, String password, String clientToken) {
		this.agent = agent;
		this.username = username;
		this.password = password;
		this.clientToken = clientToken;
	}

	/**
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @return
	 */
	public String getClientToken() {
		return clientToken;
	}
}
