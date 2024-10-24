package net.genelabs.utility;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.slf4j.Logger;
public class Utilities {

    private static Logger logger = LoggerFactory.getLogger(Utilities.class);


    public Utilities() {
    }

    public HttpHeaders createHttpHeaders() {

        logger.info("createHttpHeaders - start");
        HttpHeaders httpHeaders = new HttpHeaders();

        return httpHeaders;

    }

    public String callOVSRestAPI(String url) throws Exception {
        logger.info("callOVSRestAPI - start");
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("accept", "application/json");
        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        logger.info("callOVSRestAPI - end");
        return response.toString();
    }

    public String callATRestAPI(String url, String method, String payload) throws Exception {
        URL obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod(method);
        if (method.equals("POST")) {
            con.setRequestProperty("Content-Type", "application/json");
        }
        con.setRequestProperty("ApiIntegrationCode", "CTSIU3ES2G5W2EJNZX256VY5MLS");
        con.setRequestProperty("UserName", "dz7rwt3fdqlnuck@mjm.com");
        con.setRequestProperty("Secret", "3Hc$a8#M~gZ01Q*zo@9X7rF#w");
        con.setRequestProperty("accept", "application/json");
        con.setDoOutput(true);

        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(payload);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        logger.info("callATRestAPI - responseCode: " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}

