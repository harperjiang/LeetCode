package web_crawler;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class HtmlParser {

    Map<String, List<String>> urls= Map.of(
      "http://abcd/", List.of("http://abcd/1","http://abcd/2","http://abcd/3"),
            "http://abcd/1", List.of("http://abcd/4","http://abcd/5"),
            "http://abcd/2", List.of("http://abcd/5"),
            "http://abcd/3", List.of("http://abcd/3")
    );

    public List<String> getUrls(String url) {
        return urls.getOrDefault(url, Collections.emptyList());
    }
}
