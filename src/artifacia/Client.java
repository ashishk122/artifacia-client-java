/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artifacia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.simple.JSONObject;

/**
 *
 * @author ashish
 */
public class Client {
    private final String api_key;
    public Client(String api_key)throws KeyManagementException, NoSuchAlgorithmException{
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
      @Override
      public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return null;
      }

      @Override
      public void checkClientTrusted(X509Certificate[] certs, String authType) {
      }

      @Override
      public void checkServerTrusted(X509Certificate[] certs, String authType) {
      }
    } };

    SSLContext sc = SSLContext.getInstance("SSL");
    sc.init(null, trustAllCerts, new java.security.SecureRandom());
    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        
        
        
        this.api_key = api_key;
    }
    public void visual_recommendation(int prodid, int num){
        System.out.println(api_key);
        URL url;
        try {
            String someStr = "https://api.artifacia.com/v1/recommendation/similar/";
            String newStr = someStr + prodid+"/"+ num;
            System.out.println(newStr);
            url = new URL(newStr);

            URL obj = url;
            HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");   
            conn.setRequestProperty ("api_key", api_key);

            // Send post request
            conn.setDoOutput(true);
            // DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            // wr.writeBytes(urlParameters);
            // wr.flush();
            // wr.close();

            String line;
            conn.getInputStream();
            StringBuffer response;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = reader.readLine()) != null) {
                    response.append(inputLine);
                }
            }
            System.out.println(response.toString());

        }
        catch (IOException e) {
            // TODO Auto-generated catch block

        }
    }
    public void upload_item_data(JSONObject data){
        URL url;
        try {
            url = new URL("https://api.artifacia.com/v1/items");

            URL obj = url;
            HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
            System.out.println(data.get("details"));
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");   
            conn.setRequestProperty ("api_key", api_key);
            // Send post request
            conn.setDoOutput(true);
            
            try (BufferedWriter httpRequestBodyWriter = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()))) {
                httpRequestBodyWriter.write(data.toJSONString());
            }

            String line;
            conn.getInputStream();
            StringBuffer response;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = reader.readLine()) != null) {
                    response.append(inputLine);
                }
            }
            System.out.println(response.toString());

        }
        catch (IOException e) {
            // TODO Auto-generated catch block

        }
    }
    public void upload_user_purchased_items(int userid, JSONObject data){
        URL url;
        try {
            url = new URL("https://api.artifacia.com/v1/users/"+userid+"/purchased_items");

            URL obj = url;
            HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");   
            conn.setRequestProperty ("api_key", api_key);
            // Send post request
            conn.setDoOutput(true);
            
            try (BufferedWriter httpRequestBodyWriter = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()))) {
                httpRequestBodyWriter.write(data.toJSONString());
            }

            String line;
            conn.getInputStream();
            StringBuffer response;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = reader.readLine()) != null) {
                    response.append(inputLine);
                }
            }
            System.out.println(response.toString());

        }
        catch (IOException e) {
            // TODO Auto-generated catch block

        }
    }
    public void upload_user_viewed_items(int userid, JSONObject data){
        URL url;
        try {
            url = new URL("https://api.artifacia.com/v1/users/"+userid+"/viewed_items");

            URL obj = url;
            HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");   
            conn.setRequestProperty ("api_key", api_key);
            // Send post request
            conn.setDoOutput(true);
            
            try (BufferedWriter httpRequestBodyWriter = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()))) {
                httpRequestBodyWriter.write(data.toJSONString());
            }

            String line;
            conn.getInputStream();
            StringBuffer response;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = reader.readLine()) != null) {
                    response.append(inputLine);
                }
            }
            System.out.println(response.toString());

        }
        catch (IOException e) {
            // TODO Auto-generated catch block

        }
    }
    public void get_cpr_recommendation(int prodid, int num){
        System.out.println(api_key);
        URL url;
        try {
            String someStr = "https://api.artifacia.com/v1/recommendation/collections/";
            String newStr = someStr + prodid+"/"+ num;
            System.out.println(newStr);
            url = new URL(newStr);

            URL obj = url;
            HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");   
            conn.setRequestProperty ("api_key", api_key);

            // Send post request
            conn.setDoOutput(true);

            String line;
            conn.getInputStream();
            StringBuffer response;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = reader.readLine()) != null) {
                    response.append(inputLine);
                }
            }
            System.out.println(response.toString());

        }
        catch (IOException e) {
            // TODO Auto-generated catch block

        }
    }
    public void get_smart_recommendation(int userid, int num){
        System.out.println(api_key);
        URL url;
        try {
            String someStr = "https://api.artifacia.com/v1/recommendation/user/";
            String newStr = someStr + userid+"/"+ num;
            System.out.println(newStr);
            url = new URL(newStr);

            URL obj = url;
            HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");   
            conn.setRequestProperty ("api_key", api_key);

            // Send post request
            conn.setDoOutput(true);

            String line;
            conn.getInputStream();
            StringBuffer response;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = reader.readLine()) != null) {
                    response.append(inputLine);
                }
            }
            System.out.println(response.toString());

        }
        catch (IOException e) {
            // TODO Auto-generated catch block

        }
    }
}
