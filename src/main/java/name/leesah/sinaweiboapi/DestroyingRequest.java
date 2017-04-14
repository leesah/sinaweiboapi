package name.leesah.sinaweiboapi;

import android.util.Log;

import com.android.volley.Response;

import org.json.JSONObject;

import java.util.Map;

import static java.lang.String.format;

/**
 * Created by sah on 2017-04-12.
 */

public abstract class DestroyingRequest extends WeiboRequest {

    protected DestroyingRequest(String apiPath, String appkey, String token, Map<String, String> queryParameters, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(Method.POST, apiPath, appkey, null, token, queryParameters, listener, errorListener);
        setTag(DESTROYING_REQUEST);
    }
}
