import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Jokes {


    public static String getJoke() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("https://icanhazdadjoke.com/")
                .header("Accept", "application/json")
                .asJson();


        String result = response.getBody().getObject().getString("joke");

        return result;

    }


}
