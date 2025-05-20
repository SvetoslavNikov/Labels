package com.example.Test.TestingPatterns.ProxyPattern;

import java.util.ArrayList;
import java.util.List;

class Test {
    public static void main(String[] args){
        Internet i = new RealInternet();
        i.connectTo("google.com");
    }
}
public interface Internet {
    void connectTo(String host);
}

class RealInternet implements Internet{
    @Override
    public void connectTo(String host) {
        //what if we have a multiple users of this that have diff bans.
        //We need something in between?
//        if("banned.com".equals(host)){
//            return;
//        }
        System.out.println("Connected to: " + host);
    }
}

class ProxyInternet implements Internet{
    private static final Internet internet = new RealInternet();
    private static final List<String> bans = new ArrayList<>();

    static{
        bans.add("banned.com");
        bans.add("excalidraw.com");
    }

    @Override
    public void connectTo(String host) {
        if(bans.contains(host)){
            System.out.println("Sorry");
            return;
        }
        internet.connectTo(host);
    }
}

