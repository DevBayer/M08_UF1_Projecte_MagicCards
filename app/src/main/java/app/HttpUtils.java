package app;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

import app.exceptions.ApiControllerException;

public class HttpUtils {
    public static String get(String dataUrl) throws IOException, ApiControllerException {
        URL url = new URL(dataUrl);
        String response = null;

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            response = readStream(in);
        }catch(FileNotFoundException e) {
            throw new ApiControllerException("404", e.getMessage());
        }catch(UnknownHostException e) {
            throw new ApiControllerException("Unable to resolve host", e.getMessage());
        } finally {
            urlConnection.disconnect();
        }
        return response;
    }

    private static String readStream(InputStream in) throws IOException {
        InputStreamReader is = new InputStreamReader(in);
        BufferedReader rd = new BufferedReader(is);
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();
        return response.toString();
    }
}