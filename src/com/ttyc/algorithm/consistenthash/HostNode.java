package com.ttyc.algorithm.consistenthash;

public class HostNode implements Node {

    private String ip;

    private int port;

    @Override
    public String getKey() {
        return ip + ":" + port;
    }
}
