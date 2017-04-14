package name.leesah.sinaweiboapi;

import android.net.Uri;

import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by sah on 2017-04-12.
 */

public class WeiboRequest extends JsonObjectRequest {

    static final String LISTING_REQUEST = "LISTING";
    static final String DESTROYING_REQUEST = "DESTROYING";

    public WeiboRequest(int method, String apiPath, String appkey, String uid, String token, Map<String, String> queryParameters, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(method, url(apiPath, appkey, uid, token, queryParameters), null, listener, errorListener);
    }

    private static String url(String apiPath, String appkey, String uid, String token, Map<String, String> queryParameters) {
        Uri.Builder builder = new Uri.Builder()
                .scheme("https")
                .authority("api.weibo.com")
                .path("2")
                .appendEncodedPath(apiPath)
                .appendQueryParameter("source", appkey)
                .appendQueryParameter("access_token", token);
        if (uid != null)
            builder.appendQueryParameter("uid", uid);

        for (Map.Entry<String, String> entry : queryParameters.entrySet())
            builder.appendQueryParameter(entry.getKey(), entry.getValue());

        return builder.toString();
    }

    protected String tag() {
        return getClass().getSimpleName();
    }
}
