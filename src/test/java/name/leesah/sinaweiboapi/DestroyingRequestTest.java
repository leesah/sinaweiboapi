package name.leesah.sinaweiboapi;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.android.volley.Response;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.RobolectricTestRunner;

import name.leesah.sinaweiboapi.tools.UniversalListener;

import static android.net.Uri.parse;
import static com.android.volley.Request.Method.POST;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by sah on 2017-04-12.
 */
@RunWith(RobolectricTestRunner.class)
public abstract class DestroyingRequestTest {
    private static final String APPKEY = "foo";
    private static final String UID = "bar";
    private static final String TOKEN = "baz";
    private DestroyingRequest request;
    @Mock
    private UniversalListener universalListener;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        request = getRequestUnderTest(APPKEY, UID, TOKEN, universalListener, universalListener);
    }

    @NonNull
    protected abstract DestroyingRequest getRequestUnderTest(String appkey, String uid, String token, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener);

    @Test
    public void method() throws Exception {
        assertThat(request.getMethod(), Matchers.is(POST));
    }

    @Test
    public void urlQuery() throws Exception {
        Uri uri = parse(request.getUrl());
        assertThat(uri.getQueryParameter("source"), is(equalTo(APPKEY)));
        assertThat(uri.getQueryParameter("access_token"), is(equalTo(TOKEN)));
    }

    @Test
    public void urlPath() throws Exception {
        assertThat(parse(request.getUrl()).getPath(), endsWith(getExpectedApiPath()));
    }

    @Test
    public void itemId() throws Exception {
        String valueInUri = parse(request.getUrl()).getQueryParameter(getExpectedKeyForId());
        assertThat(valueInUri, is(equalTo(getExpectedValueForId())));
    }

    @NonNull
    protected abstract String getExpectedApiPath();

    @NonNull
    protected abstract String getExpectedKeyForId();

    @NonNull
    protected abstract String getExpectedValueForId();

}