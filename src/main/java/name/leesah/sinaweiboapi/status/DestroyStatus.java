package name.leesah.sinaweiboapi.status;

import com.android.volley.Response;

import org.json.JSONObject;

import java.util.Map;

import name.leesah.sinaweiboapi.DestroyingRequest;

import static java.util.Collections.singletonMap;

/**
 * Created by sah on 2017-04-12.
 */

public class DestroyStatus extends DestroyingRequest {
    static final String API_PATH = "statuses/destroy.json";
    static final String ID_KEY = "id";

    public DestroyStatus(String appkey, String token, String id, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(API_PATH, appkey, token, asMap(id), listener, errorListener);
    }

    private static Map<String, String> asMap(String id) {
        return singletonMap(ID_KEY, id);
    }

}
