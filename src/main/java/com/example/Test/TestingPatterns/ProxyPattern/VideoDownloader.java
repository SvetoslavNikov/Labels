package com.example.Test.TestingPatterns.ProxyPattern;

import java.util.HashMap;
import java.util.Map;

record Video(String videoName) {}
public interface VideoDownloader {
    Video getVideo(String videoName);
}

class RealVideoDownloader implements VideoDownloader {
    @Override
    public Video getVideo(String videoName) {
        System.out.println("Connecting to https://www.youtube.com/");
        System.out.println("Downloading Video");
        System.out.println("Retrieving Video Metadata");
        return new Video(videoName);
    }
}

class ProxyVideoDownloader implements VideoDownloader{
    private static final VideoDownloader downloader = new RealVideoDownloader();
    private static final Map<String, Video> cache = new HashMap<>();
    @Override
    public Video getVideo(String videoName) {
        if(!cache.containsKey(videoName)){
            cache.put(videoName,downloader.getVideo(videoName));
        }
        return cache.get(videoName);
    }
}

class Main {
    public static void main(final String[] arguments) {
        VideoDownloader videoDownloader = new RealVideoDownloader();
        videoDownloader.getVideo("geekific");
        videoDownloader.getVideo("geekific");
        videoDownloader.getVideo("LikeNsub");
        videoDownloader.getVideo("LikeNsub");
        videoDownloader.getVideo("geekific");
        //5 times downloaded
        System.out.println("\n"+"Proxy");

        VideoDownloader videoDownloader2 = new ProxyVideoDownloader();
        videoDownloader2.getVideo("geekific");
        videoDownloader2.getVideo("geekific");
        videoDownloader2.getVideo("LikeNsub");
        videoDownloader2.getVideo("LikeNsub");
        videoDownloader2.getVideo("geekific");
        //2 times downloaded
    }
}
