package org.mcupdater.Yggdrasil;

import org.mcupdater.JSON;

/**
 * Authentication refresh request
 * 
 * @author Scott M. Barbour
 *
 */
@JSON
public class RefreshRequest {
	private String accessToken;
	private String clientToken;
	
	public RefreshRequest(String access, String client) {
		this.accessToken = access;
		this.clientToken = client;
	}
	
	public String getAccessToken() {
		return this.accessToken;
	}
	
	public String getClientToken() {
		return this.clientToken;
	}
	
}
