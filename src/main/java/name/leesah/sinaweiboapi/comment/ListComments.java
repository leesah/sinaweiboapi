package name.leesah.sinaweiboapi.comment;

import com.android.volley.Response;

import org.json.JSONObject;

import name.leesah.sinaweiboapi.ListingRequest;


/**
 * Created by sah on 2017-04-12.
 */

public class ListComments extends ListingRequest {
    static final String API_PATH = "comments/by_me.json";

    public ListComments(String appkey, String uid, String token, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(API_PATH, appkey, uid, token, listener, errorListener);
    }

}
