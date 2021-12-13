package application.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class IConverterServiceImpl implements IConverterService {

    private String url = "";

    public IConverterServiceImpl(String url) {
        this.url = url;
    }

    public void setURL(String url) {
        this.url = url;
    }

    @Override
    public int convertToNumber(String romanNumber) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = "";
        try {

            HttpGet request = new HttpGet(url + "/to-number?value=" + romanNumber);

            CloseableHttpResponse response = httpClient.execute(request);

            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity);
                }

            } finally {
                response.close();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Integer.valueOf(result);
    }

    @Override
    public String convertToRoman(String number) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = "";
        try {

            HttpGet request = new HttpGet(url + "/to-roman?value=" + number);

            CloseableHttpResponse response = httpClient.execute(request);

            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity);
                }

            } finally {
                response.close();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}