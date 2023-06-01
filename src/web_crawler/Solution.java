package web_crawler;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {

    String base;
    ConcurrentHashMap<String,String> result = new ConcurrentHashMap<>();
    LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
    HtmlParser parser;
    AtomicInteger counter = new AtomicInteger(0);
    ExecutorService threadpool = Executors.newFixedThreadPool(10);

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        parser = htmlParser;
        int firstpath = startUrl.indexOf("/", 7);
        if(firstpath == -1) {
            base = startUrl;
        } else {
            base = startUrl.substring(0, firstpath);
        }

        result.put(startUrl, "");
        counter.incrementAndGet();
        queue.add(startUrl);

        for(int i = 0 ; i < 10;i++){
            threadpool.submit(new Crawler());
        }

        while(counter.get()>0) {
            try {Thread.sleep(100);} catch(Exception e) {throw new RuntimeException(e);}
        }
        threadpool.shutdownNow();
        return new ArrayList<>(result.keySet());

    }

    class Crawler implements Runnable {

        public void run() {
            while(counter.get() > 0) {
                String url = queue.poll();
                if(url == null) continue;
                List<String> candis = parser.getUrls(url);
                for(String l: candis) {
                    if(l.startsWith(base) && !result.containsKey(l)) {
                        result.put(l, "");
                        queue.add(l);
                        counter.incrementAndGet();
                    }
                }
                counter.decrementAndGet();
            }
        }
    }

    public static void main(String[] args) {
        new Solution().crawl("http://abcd/", new HtmlParser());
    }
}