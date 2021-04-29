// https://leetcode-cn.com/leetbook/read/design-patterns/9e5eht/
package StructuralPatterns;

interface IHttp {
    void request(String sendData);

    void onSuccess(String receivedData);
}

class HttpUtil implements IHttp {
    public void request(String sendData) {
        System.out.println("网络请求中...");
    }

    public void onSuccess(String receivedData) {
        System.out.println("网络请求完成");
    }
}

class HttpProxy implements IHttp {
    private final HttpUtil httpUtil;

    public HttpProxy(HttpUtil httpUtil) {
        this.httpUtil = httpUtil;
    }

    public void request(String sendData) {
        System.out.println("发送数据:" + sendData);
        httpUtil.request(sendData);
    }

    public void onSuccess(String receivedData) {
        System.out.println("收到数据:" + receivedData);
        httpUtil.onSuccess(receivedData);
    }
}

public class Proxy {
    public static void main(String[] args) {
        HttpProxy httpProxy = new HttpProxy(new HttpUtil());
        httpProxy.request("request data");
        httpProxy.onSuccess("received data");
    }
}
