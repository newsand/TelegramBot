/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webclient;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author FCapo
 */
public class WebClient {
    public String requestJson(){
        String output = "";
        String URIWithKey = "https://api.telegram.org/bot854054328:AAEY4q54JhsMcf8LofppTLr7-wbsZnleMIE/sendMessage";
        String bodyString   = "{\"chat_id\":-377868768,\"text\":\"wazzaaaaaaaaaaaa\"}";
        try {
            CloseableHttpClient httpClient;
            httpClient = HttpClients.createDefault();
            try {
                //Build request
                HttpRequestBase request;
                if (bodyString == null){
                    request = new HttpGet(URIWithKey);
                    request.addHeader("accept", "application/json");
                } else {
                    request = new HttpPost(URIWithKey);
                    StringEntity body = new StringEntity(bodyString, ContentType.APPLICATION_JSON);
                    ((HttpPost)request).setEntity(body);
                }

                //Run web request
                HttpResponse response = httpClient.execute(request);

                //Analyse response
                if (response.getStatusLine().getStatusCode() != 200
                        && response.getStatusLine().getStatusCode() != 201) {
                    throw new RuntimeException("Failed : HTTP error code : "
                       + response.getStatusLine().getStatusCode() + "for URI:" + URIWithKey);
                }
                HttpEntity entity = response.getEntity();
                output = EntityUtils.toString(entity);
            }  catch (ClientProtocolException e) {
                output = null;
                System.out.println("ClientProtocolException: " + e.getMessage());
            } catch (IOException e) {
                output = null;
                System.out.println("IOException: " + e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                output = null;
            } finally {
                httpClient.close();
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            output = null;
        }        

        return output;
    }
}
