package cn.takeout.service;


import java.util.Map;

public interface IPayService {
    public Map<String,String> wxPay(String openId,String ipAddress,String uuid) throws Exception;
}
