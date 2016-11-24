package zt.qf.com.cbkdemo_a7;

import android.os.AsyncTask;
import android.text.TextUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/8/3.
 */
public class RequestHeaderJson extends AsyncTask<String,Void,String> {
    private Callback callback;

    public RequestHeaderJson(Callback callback) {
        this.callback = callback;
    }

    @Override
    protected String doInBackground(String... params) {
        //执行请求返回string
        String url = params[0];
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
            if (httpURLConnection.getResponseCode() ==  HttpURLConnection.HTTP_OK) {
                InputStream inputStream = httpURLConnection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bytes = new byte[1024];
                int len=-1;
                while(-1!=(len = inputStream.read(bytes)))
                {
                    byteArrayOutputStream.write(bytes,0,len);
                }
                return byteArrayOutputStream.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(!TextUtils.isEmpty(s))
        {
            //getString(s);
            callback.response(s);
        }
    }

   //public abstract void getString(String s);

    public interface Callback
    {
        public void response(String result);
    }

}
