package name.leesah.sinaweiboapi;

import com.android.volley.Response;

import org.json.JSONObject;

import java.util.Collections;

import static java.util.Collections.emptyMap;

/**
 * Created by sah on 2017-04-12.
 */

public abstract class ListingRequest extends WeiboRequest {

    protected ListingRequest(String apiPath, String appkey, String uid, String token, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(Method.GET, apiPath, appkey, uid, token, emptyMap(), listener, errorListener);
        setTag(LISTING_REQUEST);
    }

    @Override
    public boolean equals(Object that) {
        return this == that || that instanceof ListingRequest && this.getUrl().equals(((ListingRequest) that).getUrl());
    }
}
