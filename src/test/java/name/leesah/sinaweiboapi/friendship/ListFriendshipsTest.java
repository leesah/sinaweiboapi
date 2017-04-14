package name.leesah.sinaweiboapi.friendship;

import android.support.annotation.NonNull;

import com.android.volley.Response;

import org.json.JSONObject;

import name.leesah.sinaweiboapi.ListingRequest;
import name.leesah.sinaweiboapi.ListingRequestTest;

/**
 * Created by sah on 2017-04-14.
 */
public class ListFriendshipsTest extends ListingRequestTest {

    @NonNull
    @Override
    protected ListingRequest getRequestUnderTest(String appkey, String uid, String token, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        return new ListFriendships(appkey, uid, token, listener, errorListener);
    }

    @NonNull
    @Override
    protected String getExpectedApiPathSuffix() {
        return ListFriendships.API_PATH;
    }
}