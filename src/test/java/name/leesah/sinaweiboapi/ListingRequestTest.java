package name.leesah.sinaweiboapi;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.android.volley.Cache;
import com.android.volley.ExecutorDelivery;
import com.android.volley.RequestQueue;
import com.android.volley.Response;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.RobolectricTestRunner;

import name.leesah.sinaweiboapi.tools.CacheTestUtils;
import name.leesah.sinaweiboapi.tools.UniversalListener;

import static com.android.volley.Request.Method.GET;
import static name.leesah.sinaweiboapi.tools.CacheTestUtils.makeRandomCacheEntry;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by sah on 2017-04-12.
 */
@RunWith(RobolectricTestRunner.class)
public abstract class ListingRequestTest {
    private static final String APPKEY = "foo";
    private static final String UID = "bar";
    private static final String TOKEN = "baz";
    private ListingRequest request;
    private ExecutorDelivery delivery;
    private Response<JSONObject> successResponse;
    @Mock
    private RequestQueue requestQueue;
    @Mock
    private UniversalListener universalListener;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        delivery = new ExecutorDelivery(Runnable::run);

        JSONObject data = new JSONObject("{\"key\":\"value\"}");
        Cache.Entry cacheEntry = makeRandomCacheEntry(data);
        successResponse = Response.success(data, cacheEntry);

        request = getRequestUnderTest(APPKEY, UID, TOKEN, universalListener, universalListener);
        request.setRequestQueue(requestQueue);

    }

    @Test
    public void method() throws Exception {
        assertThat(request.getMethod(), Matchers.is(GET));
    }

    @Test
    public void urlQueryParameters() throws Exception {
        Uri uri = Uri.parse(request.getUrl());
        assertThat(uri.getQueryParameter("source"), is(equalTo(APPKEY)));
        assertThat(uri.getQueryParameter("uid"), is(equalTo(UID)));
        assertThat(uri.getQueryParameter("access_token"), is(equalTo(TOKEN)));
    }

    @Test
    public void urlPath() throws Exception {
        Uri uri = Uri.parse(request.getUrl());
        assertThat(uri.getPath(), endsWith(getExpectedApiPathSuffix()));
    }

    @Test
    public void payload() throws Exception {
        assertThat(request.getBody(), is(nullValue()));
    }

    @Test
    public void setRequestQueue() throws Exception {
    }

    @Test
    public void deliverSuccessResponse() throws Exception {
        delivery.postResponse(request, successResponse);
        verify(universalListener).onResponse(same(successResponse.result));
    }

    @NonNull
    protected abstract ListingRequest getRequestUnderTest(String appkey, String uid, String token, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener);

    @NonNull
    protected abstract String getExpectedApiPathSuffix();

}