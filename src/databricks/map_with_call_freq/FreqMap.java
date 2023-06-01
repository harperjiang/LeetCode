package databricks.map_with_call_freq;

import java.util.HashMap;
import java.util.Map;

public class FreqMap {

    HitCounter getCounter = new HitCounter();
    HitCounter putCounter = new HitCounter();
    Map<String,String> data = new HashMap<>();

    long timestamp() {
        return System.currentTimeMillis()/1000;
    }

    public String put(String key, String value) {
        data.put(key,value);
        putCounter.hit(timestamp());
        return value;
    }
    public String get(String key) {
        getCounter.hit(timestamp());
        return data.get(key);
    }
    // These methods require returning the frequency of calls to the above functions in the last 5 minutes.
    public int measurePutLoad() {
        return putCounter.getHit(timestamp())/300;
    }
    public int measureGetLoad() {
        return getCounter.getHit(timestamp())/300;
    }
}
