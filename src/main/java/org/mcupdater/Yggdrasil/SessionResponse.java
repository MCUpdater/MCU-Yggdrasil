package org.mcupdater.Yggdrasil;
/**
 * Authentication response
 * 
 * @author Scott M. Barbour
 *
 */
public class SessionResponse extends ErrorResponse {
	private String accessToken;
	private String clientToken;
	private Profile[] availableProfiles;
	private Profile selectedProfile;

	/**
	 * Returns the authentication token.
	 * 
	 * @return
	 */
	public String getAccessToken() {
		return this.accessToken;
	}

	/**
	 * Returns the UUID used for the authentication process.
	 * 
	 * @return
	 */
	public String getClientToken() {
		return this.clientToken;
	}

	/**
	 * Returns all player profiles for the authenticated account.
	 * 
	 * @return
	 */
	public Profile[] getAvailableProfiles() {
		return this.availableProfiles;
	}

	/**
	 * Returns the current player profile for the authenticated account.
	 * 
	 * @return
	 */
	public Profile getSelectedProfile() {
		return this.selectedProfile;
	}
	
	/**
	 * Get session key formatted for use in Minecraft's command-line arguments.
	 * 
	 * @return
	 */
	public String getSessionId() {
		return "token:" + this.accessToken + ":" + this.selectedProfile.getId();
	}
}
