// Copyright 2011 Google Inc. All Rights Reserved.

package name.leesah.sinaweiboapi.tools;

import com.android.volley.Cache;

import org.json.JSONObject;

import java.util.Random;

public class CacheTestUtils {

    private static Cache.Entry makeRandomCacheEntry(
            byte[] data, boolean isExpired, boolean needsRefresh) {
        Random random = new Random();
        Cache.Entry entry = new Cache.Entry();
        if (data != null) {
            entry.data = data;
        } else {
            entry.data = new byte[random.nextInt(1024)];
        }
        entry.etag = String.valueOf(random.nextLong());
        entry.lastModified = random.nextLong();
        entry.ttl = isExpired ? 0 : Long.MAX_VALUE;
        entry.softTtl = needsRefresh ? 0 : Long.MAX_VALUE;
        return entry;
    }

    public static Cache.Entry makeRandomCacheEntry(JSONObject data) {
        return makeRandomCacheEntry(data.toString().getBytes(), false, false);
    }
}
