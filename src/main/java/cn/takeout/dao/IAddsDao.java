package cn.takeout.dao;

import cn.takeout.domain.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAddsDao {
    List<Address> getAddsByOpenId(String openId);
    void addAddress(Address address);
    String getFirstAddr(String openId);
    void setAddrToSecond(String uuid);
    void setAddrToFirst(String uuid);
    void deleteAddr(String uuid);
    Address getFirstAddrDomain(String openId);
    Address getAddrByUuid(String uuid);
    void updateAddress(Address address);
}
