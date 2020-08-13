package cn.takeout.service.impl;

import cn.takeout.constant.WechatConstant;
import cn.takeout.service.IPayService;
import cn.takeout.wxpay.sdk.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PayServiceImpl implements IPayService {
    @Override
    public Map<String, String> wxPay(String openId, String ipAddress,String orderNo) throws Exception {
        Map<String, String> paraMap = new HashMap<>();
        paraMap.put("body", "测试支付");
        paraMap.put("openid", openId);
//        paraMap.put("out_trade_no", UUID.randomUUID().toString().replaceAll("-", ""));
        paraMap.put("out_trade_no", orderNo);
        paraMap.put("spbill_create_ip", ipAddress);
        paraMap.put("total_fee", "1");
        paraMap.put("trade_type", "JSAPI");
        final String SUCCESS_NOTIFY = "https://hzycode.utools.club/WechatTakeOut/topay/success";
        boolean useSandbox = false;
        WXPayConfig config = new MyWXPayConfig();
        WXPay wxPay = new WXPay(config, SUCCESS_NOTIFY, false, useSandbox);
        Map<String, String> map = wxPay.unifiedOrder(wxPay.fillRequestData(paraMap), 15000, 15000);
        String prepayId = (String) map.get("prepay_id");
        Map<String, String> payMap = new HashMap<String, String>();
        payMap.put("appId", WechatConstant.APPID);
        payMap.put("timeStamp", WXPayUtil.getCurrentTimestamp() + "");
        payMap.put("nonceStr", WXPayUtil.generateNonceStr());
        if (useSandbox) {
            payMap.put("signType", WXPayConstants.MD5);
        } else {
            payMap.put("signType", WXPayConstants.HMACSHA256);
        }
        payMap.put("package", "prepay_id=" + prepayId);
        String paySign = null;
        if(useSandbox){
            paySign = WXPayUtil.generateSignature(payMap,WechatConstant.MCH_KEY,WXPayConstants.SignType.MD5);
        } else {
            paySign = WXPayUtil.generateSignature(payMap,WechatConstant.MCH_KEY,WXPayConstants.SignType.HMACSHA256);
        }
        payMap.put("paySign",paySign);
        return payMap;
    }
}
