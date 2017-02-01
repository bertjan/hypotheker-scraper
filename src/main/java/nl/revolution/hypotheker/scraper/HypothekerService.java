package nl.revolution.hypotheker.scraper;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class HypothekerService {

    private static final String API_ENDPOINT_URL = "https://api.hypotheker.nl/Calculations/CalculateResidenceValue";

    public Residence calculateResidenceValue(Residence inputResidence) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(API_ENDPOINT_URL);
        post.setEntity(new StringEntity(inputResidence.toJSON(), ContentType.APPLICATION_JSON));
        HttpResponse response = client.execute(post);
        String responseBody = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8.name());
        Residence outputResidence = Residence.fromJSON(responseBody);
        return outputResidence;
    }

}
