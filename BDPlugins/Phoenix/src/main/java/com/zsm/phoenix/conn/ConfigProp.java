package com.zsm.phoenix.conn;

import java.io.IOException;
import java.util.Properties;


/**
 * @Author: zengsm.
 * @Description: TODO()
 * @Date:Created in 2018/9/26.
 * @Modified By:
 */
public class ConfigProp
{
    public static Properties p = new Properties();

    static
    {
        try
        {
            p.load(ClassLoader.getSystemResourceAsStream("phoenix.properties"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static String getDriver()
        throws IOException
    {
        p.load(ClassLoader.getSystemResourceAsStream("phoenix.properties"));
        return p.getProperty("phoenix.driver");
    }

    public static String getUrl()
    {
        return p.getProperty("phoenix.url");
    }

    public static String getUserName()
    {
        return p.getProperty("phoenix.user");
    }

    public static String getPassWord()
    {
        return p.getProperty("phoenix.password");
    }
}
