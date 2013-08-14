package org.mcupdater.Yggdrasil;

public class SessionResponse extends ErrorResponse {
	private String accessToken;
	private String clientToken;
	private Profile[] availableProfiles;
	private Profile selectedProfile;

	public String getAccessToken() {
		return this.accessToken;
	}

	public String getClientToken() {
		return this.clientToken;
	}

	public Profile[] getAvailableProfiles() {
		return this.availableProfiles;
	}

	public Profile getSelectedProfile() {
		return this.selectedProfile;
	}
	
	public String getSessionId() {
		return "token:" + this.accessToken + ":" + this.selectedProfile.getId();
	}
}
