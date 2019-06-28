package com.fengzhi.basislearning.activity.hh.day17;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.Handler;
import android.os.Message;

//下载。在子线程下载，把数据返回到主线程
public class HandlerNetworkUtil2 {
	
	public static void doNetwork(final String path,final Handler handler){
		
		new Thread(() -> {//子线程中进行下载操作
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
					while((len = is.read(buffer)) != -1){
						baos.write(buffer, 0, len);
					}

					final byte[] bytes = baos.toByteArray();
					Message message = Message.obtain();
					message.obj = bytes;
					handler.sendMessage(message);

				}

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}).start();
		
		
		
	}
	
	
}
