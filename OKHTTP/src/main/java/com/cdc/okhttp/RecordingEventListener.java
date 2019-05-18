package com.cdc.okhttp;

import okhttp3.*;

import javax.annotation.Nullable;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.logging.Logger;

public class RecordingEventListener extends EventListener {

    @Override
    public void callStart(Call call) {
        super.callStart(call);
        LogUtil.w("callStart");
    }

    @Override
    public void callEnd(Call call) {
        super.callEnd(call);
        LogUtil.w("callEnd");
    }

    @Override
    public void callFailed(Call call, IOException ioe) {
        super.callFailed(call, ioe);
        LogUtil.w("callFailed");
    }

    @Override
    public void dnsStart(Call call, String domainName) {
        super.dnsStart(call, domainName);
        LogUtil.w("dnsStart");
    }

    @Override
    public void dnsEnd(Call call, String domainName, List<InetAddress> inetAddressList) {
        super.dnsEnd(call, domainName, inetAddressList);
        LogUtil.w("dnsEnd");
    }

    @Override
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        LogUtil.w("connectStart");
    }

    @Override
    public void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        LogUtil.w("secureConnectStart");
    }

    @Override
    public void secureConnectEnd(Call call, @Nullable Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        LogUtil.w("secureConnectEnd");
    }

    @Override
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        LogUtil.w("connectEnd");
    }

    @Override
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol, IOException ioe) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, ioe);
        LogUtil.w("connectFailed");
    }

    @Override
    public void connectionAcquired(Call call, Connection connection) {
        super.connectionAcquired(call, connection);
        LogUtil.w("connectionAcquired");
    }

    @Override
    public void connectionReleased(Call call, Connection connection) {
        super.connectionReleased(call, connection);
        LogUtil.w("connectionReleased");
    }

    @Override
    public void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        LogUtil.w("requestHeadersStart");

    }

    @Override
    public void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        LogUtil.w("requestHeadersEnd");
    }

    @Override
    public void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        LogUtil.w("requestBodyStart");
    }

    @Override
    public void requestBodyEnd(Call call, long byteCount) {
        super.requestBodyEnd(call, byteCount);
        LogUtil.w("requestBodyEnd");
    }

    @Override
    public void requestFailed(Call call, IOException ioe) {
        super.requestFailed(call, ioe);
        LogUtil.w("requestFailed");
    }

    @Override
    public void responseHeadersStart(Call call) {
        super.responseHeadersStart(call);
        LogUtil.w("responseHeadersStart");
    }

    @Override
    public void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
        LogUtil.w("responseHeadersEnd");
    }

    @Override
    public void responseBodyStart(Call call) {
        super.responseBodyStart(call);
        LogUtil.w("responseBodyStart");
    }

    @Override
    public void responseBodyEnd(Call call, long byteCount) {
        super.responseBodyEnd(call, byteCount);
        LogUtil.w("responseBodyEnd");
    }

    @Override
    public void responseFailed(Call call, IOException ioe) {
        super.responseFailed(call, ioe);
        LogUtil.w("responseFailed");
    }
}
