package cn.takeout.wxpay.sdk;

import cn.takeout.constant.WechatConstant;
import cn.takeout.wxpay.sdk.IWXPayDomain;
import cn.takeout.wxpay.sdk.WXPayConfig;

import java.io.InputStream;

public class MyWXPayConfig extends WXPayConfig {
    @Override
    String getAppID(){
        return WechatConstant.APPID;
    }
    @Override
    String getMchID(){
        return WechatConstant.MCH_ID;
    }
    @Override
    String getKey(){
        return WechatConstant.MCH_KEY;
    }
    @Override
    InputStream getCertStream(){
        return null;
    }
    @Override
    IWXPayDomain getWXPayDomain(){
        return new IWXPayDomain() {
            @Override
            public void report(String domain, long elapsedTimeMillis, Exception ex) {
                return ;
            }

            @Override
            public DomainInfo getDomain(WXPayConfig config) {
                return new IWXPayDomain.DomainInfo(WXPayConstants.DOMAIN_API,true);
            }
        };
    }
}
