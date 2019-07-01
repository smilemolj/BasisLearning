package com.fengzhi.basislearning.activity.hh.day29;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 有下载功能的图片控件
 */
@SuppressLint("AppCompatCustomView")
public class DownImg extends ImageView {
    public DownImg(Context context) {
        super(context);
    }

    public DownImg(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    //实现下载，展示
    public void downLoad(final String path) {
        new Thread(new Runnable() {
            @Override
            public void run() {//子线程中下载
                try {
                    URL url = new URL(path);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setReadTimeout(5000);
                    if (connection.getResponseCode() == 200) {
                        InputStream is = connection.getInputStream();
//                                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                                int len = 0;
//                                byte[] buffer = new byte[1024];
//                                while((len = is.read(buffer)) != -1){
//                                    baos.write(buffer,0,len);
//                                }
//
//                                byte[] bytes = baos.toByteArray();
//                                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes
//                                .length);
                        final Bitmap bitmap = BitmapFactory.decodeStream(is);
                        /*DownImg.this.*/
                        post(new Runnable() {
                            @Override
                            public void run() {//主线程
                                //展示数据
                                setImageBitmap(bitmap);
                            }
                        });


                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }).start();
    }

}
