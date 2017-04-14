package name.leesah.sinaweiboapi.friendship;

import com.android.volley.Response;

import org.json.JSONObject;

import name.leesah.sinaweiboapi.ListingRequest;

/**
 * Created by sah on 2017-04-12.
 */

public class ListFriendships extends ListingRequest {
    static final String API_PATH = "friendships/friends/ids.json";

    public ListFriendships(String appkey, String uid, String token, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(API_PATH, appkey, uid, token, listener, errorListener);
    }

}
