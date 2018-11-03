package com.zsm.demo.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.swagger.annotations.Api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


/**
 * @Author: zengsm.
 * @Description: TODO()
 * @Date:Created in 2018/8/28.
 * @Modified By:
 */
@XmlAccessorType(XmlAccessType.FIELD)
@JacksonXmlRootElement(localName = "root")
@Api(description = "消息返回模型")
public class ResponseMsg<T>
{
    public static <T> ResponseMsg<T> generatorSuccessMsg(T data)
    {
        return generatorMsg(data, "", ResponseCode.SUCCESS.getCode());
    }

    public static <T> ResponseMsg<T> generatorSuccessMsg(T data, String message)
    {
        return generatorMsg(data, message, ResponseCode.SUCCESS.getCode());
    }

    public static <T> ResponseMsg<T> generatorFailMsg(String message, Integer code)
    {
        return generatorMsg((T)"", message,code);
    }

    public static <T> ResponseMsg<T> generatorMsg(T data, String message, Integer code)
    {
        ResponseMsg<T> msg = new ResponseMsg<>();
        msg.setData(data);
        msg.setMessage(message);
        msg.setCode(code.toString());
        return msg;
    }
    @XmlElement(name = "code")
    private String code;
    @XmlElement(name = "message")
    private String message;

    @JacksonXmlElementWrapper(localName = "datas")
    @JacksonXmlProperty(localName = "data")
    private T data;


    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }


    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }


    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }
}
