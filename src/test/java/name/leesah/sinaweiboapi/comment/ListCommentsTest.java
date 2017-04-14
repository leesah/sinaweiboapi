package name.leesah.sinaweiboapi.comment;

import android.support.annotation.NonNull;

import com.android.volley.Response;

import org.json.JSONObject;

import name.leesah.sinaweiboapi.ListingRequest;
import name.leesah.sinaweiboapi.ListingRequestTest;
import name.leesah.sinaweiboapi.friendship.ListFriendships;

/**
 * Created by sah on 2017-04-14.
 */
public class ListCommentsTest extends ListingRequestTest {

    @NonNull
    @Override
    protected ListingRequest getRequestUnderTest(String appkey, String uid, String token, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        return new ListComments(appkey, uid, token, listener, errorListener);
    }

    @NonNull
    @Override
    protected String getExpectedApiPathSuffix() {
        return ListComments.API_PATH;
    }

}