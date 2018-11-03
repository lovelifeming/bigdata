package com.zsm.demo.model;

import com.zsm.demo.utils.SensitiveInfo;
import com.zsm.demo.utils.SensitiveType;


/**
 * 测试对象
 *
 * @Author: zengsm.
 * @Description: TODO()
 * @Date:Created in 2018/8/30.
 * @Modified By:
 */
public class UserName
{
    private String name;

    @SensitiveInfo(value = SensitiveType.ID_CARD)
    private String IdCard;

    @SensitiveInfo(value = SensitiveType.ADDRESS)
    private String address;

    @SensitiveInfo(value = SensitiveType.MOBILE_PHONE)
    private String phone;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getIdCard()
    {
        return IdCard;
    }

    public void setIdCard(String idCard)
    {
        IdCard = idCard;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

//    public String toString()
//    {
//        return JSONObject.toJSONString(toString(true));
//    }
//
//    public UserName toString(boolean flag)
//    {
//        SensitiveToString sensitive = new SensitiveToString(this, ToStringStyle.SHORT_PREFIX_STYLE, flag);
//        return (UserName)JSONObject.parse(sensitive.toString());
//    }

}
