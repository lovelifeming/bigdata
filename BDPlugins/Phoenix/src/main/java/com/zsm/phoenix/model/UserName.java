package com.zsm.phoenix.model;

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

    private String IdCard;

    private String address;

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

    @Override
    public String toString()
    {
        return "UserName{" +
               "name='" + name + '\'' +
               ", IdCard='" + IdCard + '\'' +
               ", address='" + address + '\'' +
               ", phone='" + phone + '\'' +
               '}';
    }
}
