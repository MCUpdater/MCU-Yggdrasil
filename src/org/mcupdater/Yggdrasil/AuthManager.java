package org.mcupdater.Yggdrasil;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import com.google.gson.Gson;

public class AuthManager {
	private final Agent MINECRAFT = new Agent("Minecraft",1);
	private final URL AUTH = constantURL("https://authserver.mojang.com/authenticate");
	private final URL REFRESH = constantURL("https://authserver.mojang.com/refresh");
	private final Gson gson = new Gson();
	
	public SessionResponse authenticate(String username, String password, String clientToken) {
		AuthRequest request = new AuthRequest(MINECRAFT, username, password, clientToken);
		String result = performJsonPost(AUTH, gson.toJson(request));
		System.out.println(result);
		SessionResponse response = gson.fromJson(result, SessionResponse.class);
		return response;
	}
	
	public SessionResponse refresh(String accessToken, String clientToken) {
		RefreshRequest request = new RefreshRequest(accessToken, clientToken);
		String result = performJsonPost(REFRESH, gson.toJson(request));
		System.out.println(result);
		SessionResponse response = gson.fromJson(result, SessionResponse.class);
		return response;
	}
	
	private String performJsonPost(URL url, String json) {
		try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			byte[] payloadAsBytes = json.getBytes(Charset.forName("UTF-8"));
			
			conn.setConnectTimeout(15000);
			conn.setReadTimeout(15000);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("User-Agent", "MCU-Yggdrasil/1.0");
			conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			conn.setRequestProperty("Content-Length", "" + payloadAsBytes.length);
			conn.setRequestProperty("Content-Language", "en-US");
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			
			DataOutputStream outStream = new DataOutputStream(conn.getOutputStream());
			outStream.write(payloadAsBytes);
			outStream.flush();
			outStream.close();
			
			InputStream inStream = null;
			try {
				inStream = conn.getInputStream();
			} catch (Exception e) {
				inStream = conn.getErrorStream();
			}
			
			StringBuilder response = new StringBuilder();
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = inStream.read(buffer)) > 0) {
				response.append(new String(buffer,"UTF-8").substring(0,bytesRead));
			}
			return response.toString();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static URL constantURL(String input) {
	    try {
	      return new URL(input);
	    } catch (MalformedURLException e) {
	      throw new Error(e);
	    }
	  }
}

