package org.mcupdater.Yggdrasil;

public class AuthRequest {
	private Agent agent;
	private String username;
	private String password;
	private String clientToken;
	
	public AuthRequest(Agent agent, String username, String password, String clientToken) {
		this.agent = agent;
		this.username = username;
		this.password = password;
		this.clientToken = clientToken;
	}

	public Agent getAgent() {
		return agent;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getClientToken() {
		return clientToken;
	}
}
