package com.fengzhi.basislearning.activity.hh.day17;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUtils {
	public static byte[] getBytes(String path){
		try {
			HttpURLConnection connection = (HttpURLConnection) 
					new URL(path).openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			if (200 == connection.getResponseCode()) {
				InputStream is = connection.getInputStream();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				int len = 0;
				byte[] buffer = new byte[1024];
				while((len = is.read(buffer)) !=-1){
					baos.write(buffer, 0, len);
				}
				
				return baos.toByteArray();
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
