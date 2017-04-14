package name.leesah.sinaweiboapi.status;

import com.android.volley.Response;

import org.json.JSONObject;

import name.leesah.sinaweiboapi.ListingRequest;


/**
 * Created by sah on 2017-04-12.
 */

public class ListStatuses extends ListingRequest {
    static final String API_PATH = "statuses/user_timeline/ids.json";

    public ListStatuses(String appkey, String uid, String token, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(API_PATH, appkey, uid, token, listener, errorListener);
    }

}
