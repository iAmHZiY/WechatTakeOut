package cn.takeout.controller;

import cn.takeout.domain.Address;
import cn.takeout.service.IAddsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/address", produces = "application/json")
public class AddressController {
    @Autowired
    IAddsService addsService;

    @ResponseBody
    @RequestMapping("/getAddsByOpenId")
    List<Address> getAddresses(String openId) {
        List<Address> addsByOpenId = addsService.getAddsByOpenId(openId);
        return addsByOpenId;
    }

    @RequestMapping("/addAddress")
    @ResponseBody
    List<Address> addAddress(Address address) {
        addsService.addAddress(address);
        return addsService.getAddsByOpenId(address.getOpenId());
    }

    @RequestMapping("/updateAddress")
    @ResponseBody
    List<Address> updateAddress(Address address) {
        List<Address> addresses = addsService.updateAddress(address);
        return addresses;
    }

    @RequestMapping("/setFirst")
    @ResponseBody
    List<Address> setFirst(String uuid, String openId) {
        addsService.setAddrToFirst(uuid, openId);
        return addsService.getAddsByOpenId(openId);
    }

    @RequestMapping("/deleteAddress")
    @ResponseBody
    List<Address> deleteAddress(String openId,String uuid) {
        addsService.deleteAddr(uuid);
        return addsService.getAddsByOpenId(openId);
    }

    @RequestMapping("/getFirstAddress")
    @ResponseBody
    Address getFirstAddress(String openId) {
        return addsService.getFirstAddr(openId);
    }

    @RequestMapping("/getAddressByUuid")
    @ResponseBody
    Address getAddressByUuid(String uuid) {
        return addsService.getAddrByUuid(uuid);
    }
}
