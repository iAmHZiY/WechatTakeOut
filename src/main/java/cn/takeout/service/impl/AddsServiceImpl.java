package cn.takeout.service.impl;

import cn.takeout.dao.IAddsDao;
import cn.takeout.domain.Address;
import cn.takeout.service.IAddsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("addsService")
public class AddsServiceImpl implements IAddsService {
    @Autowired
    IAddsDao addressDao;
    @Override
    public List<Address> getAddsByOpenId(String openId) {
        return addressDao.getAddsByOpenId(openId);
    }

    @Override
    public void addAddress(Address address) {
        List<Address> existAddr = addressDao.getAddsByOpenId(address.getOpenId());
        address.setUuid(UUID.randomUUID().toString());
        if(existAddr == null || existAddr.size() == 0){
            address.setTag(1);
        } else {
            address.setTag(0);
        }
        addressDao.addAddress(address);
    }

    @Override
    public void setAddrToFirst(String uuid,String openId) {
        String firstAddr = addressDao.getFirstAddr(openId); // 拿到了tag为1的uuid
        addressDao.setAddrToSecond(firstAddr);
        addressDao.setAddrToFirst(uuid);
    }

    @Override
    public void deleteAddr(String uuid) {
        addressDao.deleteAddr(uuid);
    }

    @Override
    public Address getFirstAddr(String openId) {
        return addressDao.getFirstAddrDomain(openId);
    }

    @Override
    public Address getAddrByUuid(String uuid) {
        return addressDao.getAddrByUuid(uuid);
    }

    @Override
    public List<Address> updateAddress(Address address) {
        addressDao.updateAddress(address);
        return addressDao.getAddsByOpenId(address.getOpenId());
    }
}
