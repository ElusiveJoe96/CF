package ru.vstu.CodeForce.handle;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.vstu.CodeForce.model.ContestRating;
import ru.vstu.CodeForce.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class CodeforcesAPIHandler {
    @Value("${codeforces.api.url}")
    private String apiUrl;
    @Value("${codeforces.api.key}")
    private String apiKey;
    @Value("${codeforces.api.secret}")
    private String apiSecret;

    private final RestTemplate restTemplate;

    public CodeforcesAPIHandler(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }



    public String getUserRating(String handle) {
        String methodUserRating = "user.rating";
        String url = apiUrl + methodUserRating + "?handle=" + handle;
        String params = "handle=" + handle;
        String rand = generateRandomString();
        String time = String.valueOf(System.currentTimeMillis() / 1000);
        String apiSig = generateApiSignature(methodUserRating, rand, params, time);
        url += "&apiKey=" + apiKey + "&time=" + time + "&apiSig=" + rand + apiSig;
        return restTemplate.getForObject(url, String.class);
    }
    public String getUserInfo(String handle) {
        String methodUserInfo = "user.info";
        String url = apiUrl + methodUserInfo + "?handles=" + handle;
        String params = "handles=" + handle;
        String rand = generateRandomString();
        String time = String.valueOf(System.currentTimeMillis() / 1000);
        String apiSig = generateApiSignature(methodUserInfo, rand, params, time);
        url += "&apiKey=" + apiKey + "&time=" + time + "&apiSig=" + rand + apiSig;
        return restTemplate.getForObject(url, String.class);
    }

    public User jsonToUser(String string) {
        String json = getUserInfo(string);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(json);
            JsonNode resultNode = rootNode.get("result");
            if (resultNode == null || !resultNode.isArray() || resultNode.size() == 0) {
                return null;
            }

            JsonNode userNode = resultNode.get(0);
            return objectMapper.treeToValue(userNode, User.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ContestRating> jsonToRatingList(String string) {
        String json = getUserRating(string);
        List<ContestRating> contestRatings = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(json);
            JsonNode resultNode = jsonNode.get("result");
            if (resultNode.isArray()) {
                for (JsonNode contestNode : resultNode) {
                    contestRatings.add(objectMapper.treeToValue(contestNode, ContestRating.class));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contestRatings;
    }




    private String generateApiSignature(String methodName, String rand,String params, String time) {
        String signatureData = rand + "/"
                + methodName + "?apiKey="
                + apiKey + "&"
                + params + "&time="
                + time + "#"
                + apiSecret;
        return DigestUtils.sha512Hex(signatureData);
    }

    private String generateRandomString() {
        return String.valueOf((int) ((Math.random() * (999999 - 100000)) + 100000));
    }
}
