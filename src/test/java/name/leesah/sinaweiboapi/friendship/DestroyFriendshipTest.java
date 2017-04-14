package name.leesah.sinaweiboapi.friendship;

import android.support.annotation.NonNull;

import com.android.volley.Response;

import org.json.JSONObject;

import name.leesah.sinaweiboapi.DestroyingRequest;
import name.leesah.sinaweiboapi.DestroyingRequestTest;

import static org.mockito.Mockito.mock;

/**
 * Created by sah on 2017-04-14.
 */
public class DestroyFriendshipTest extends DestroyingRequestTest {

    private static final String ID_VALUE = "65535";

    @NonNull
    @Override
    protected DestroyingRequest getRequestUnderTest(String appkey, String uid, String token, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        return new DestroyFriendship(appkey, token, ID_VALUE, listener, errorListener);
    }

    @NonNull
    @Override
    protected String getExpectedApiPath() {
        return DestroyFriendship.API_PATH;
    }

    @NonNull
    @Override
    protected String getExpectedKeyForId() {
        return DestroyFriendship.ID_KEY;
    }

    @NonNull
    @Override
    protected String getExpectedValueForId() {
        return ID_VALUE;
    }
}