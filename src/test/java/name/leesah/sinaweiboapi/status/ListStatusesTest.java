package name.leesah.sinaweiboapi.status;

import android.support.annotation.NonNull;

import com.android.volley.Response;

import org.json.JSONObject;

import name.leesah.sinaweiboapi.ListingRequest;
import name.leesah.sinaweiboapi.ListingRequestTest;

/**
 * Created by sah on 2017-04-12.
 */
public class ListStatusesTest extends ListingRequestTest {

    @Override
    @NonNull
    protected ListingRequest getRequestUnderTest(String appkey, String uid, String token, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        return new ListStatuses(appkey, uid, token, listener, errorListener);
    }

    @Override
    @NonNull
    protected String getExpectedApiPathSuffix() {
        return ListStatuses.API_PATH;
    }

}