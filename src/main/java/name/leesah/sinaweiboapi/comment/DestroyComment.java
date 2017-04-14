package name.leesah.sinaweiboapi.comment;

import com.android.volley.Response;

import org.json.JSONObject;

import java.util.Map;

import name.leesah.sinaweiboapi.DestroyingRequest;

import static java.util.Collections.singletonMap;

/**
 * Created by sah on 2017-04-12.
 */

public class DestroyComment extends DestroyingRequest {
    static final String API_PATH = "comments/destroy_batch.json";
    static final String ID_KEY = "cids";

    public DestroyComment(String appkey, String token, String id, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(API_PATH, appkey, token, asMap(id), listener, errorListener);
    }

    private static Map<String, String> asMap(String id) {
        return singletonMap(ID_KEY, id);
    }

}
