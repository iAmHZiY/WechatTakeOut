package cn.takeout.service;

import cn.takeout.domain.Address;

import java.util.List;

public interface IAddsService {
    List<Address> getAddsByOpenId(String openId);
    void addAddress(Address address);
    void setAddrToFirst(String uuid,String openId);
    void deleteAddr(String uuid);
    Address getFirstAddr(String openId);
    Address getAddrByUuid(String uuid);
    List<Address> updateAddress(Address address);
}