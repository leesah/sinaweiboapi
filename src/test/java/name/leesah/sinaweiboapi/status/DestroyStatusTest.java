package name.leesah.sinaweiboapi.status;

import android.support.annotation.NonNull;

import com.android.volley.Response;

import org.json.JSONObject;

import name.leesah.sinaweiboapi.DestroyingRequest;
import name.leesah.sinaweiboapi.DestroyingRequestTest;

import static org.mockito.Mockito.mock;

/**
 * Created by sah on 2017-04-12.
 */
public class DestroyStatusTest extends DestroyingRequestTest {

    private static final String ID_VALUE = "65535";

    @NonNull
    @Override
    protected DestroyingRequest getRequestUnderTest(String appkey, String uid, String token, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        return new DestroyStatus(appkey, token, ID_VALUE, listener, errorListener);
    }

    @Override
    @NonNull
    protected String getExpectedApiPath() {
        return DestroyStatus.API_PATH;
    }

    @Override
    @NonNull
    protected String getExpectedKeyForId() {
        return DestroyStatus.ID_KEY;
    }

    @Override
    @NonNull
    protected String getExpectedValueForId() {
        return ID_VALUE;
    }

}