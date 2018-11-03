package com.zsm.phoenix.conn;

import java.sql.*;
import java.util.*;


/**
 * @Author: zengsm.
 * @Description: TODO()
 * @Date:Created in 2018/9/26.
 * @Modified By:
 */
public class Connector
{
    private static String driver = "org.apache.phoenix.jdbc.PhoenixDriver";

    private static Connection connection = null;

    private Connector()
    {

    }

    public static Connection getConnector()
        throws SQLException
    {
        if (connection == null)
        {
            connection = getConnection();
        }
        return connection;
    }

    private static Connection getConnection()
        throws SQLException
    {
        /** 连接超时修改HBase配置项
         * phoenix.query.timeoutMs
         * hbase.rpc.timeout
         * hbase.client.scanner.timeout.period
         */
        Properties props = new Properties();
        props.setProperty("phoenix.query.timeoutMs", "1200000");
        props.setProperty("hbase.rpc.timeout", "1200000");
        props.setProperty("hbase.client.scanner.timeout.period", "1200000");
        try
        {
            Class.forName(driver);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        Connection con = DriverManager.getConnection("jdbc:phoenix:hadoop2,hadoop3,hadoop4:2181", props);
        return con;
    }

    public static void connect(String sql)
        throws SQLException
    {
        Connection con = getConnector();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        //数据集合
        List<Map> result = new ArrayList<>();
        //数据元信息
        List<String> meta = new ArrayList<>();

        while (rs.next())
        {
            ResultSetMetaData metaData = rs.getMetaData();
            int length = metaData.getColumnCount();
            //表名，数据列起始游标为1
            String tableName = metaData.getTableName(1);
            for (int i = 1; i <= length; i++)
            {
                //列类型类名称
                String className = metaData.getColumnClassName(i);
                //列名称
                String columnName = metaData.getColumnName(i);
                //列类型
                int type = metaData.getColumnType(i);
                String typeName = metaData.getColumnTypeName(i);
                meta.add(columnName);
            }
            int index = 0;
            do
            {
                String colName = meta.get(index);
                index++;
                String string = rs.getString(index);
                String name = rs.getCursorName();
                Object object = rs.getObject(index);
                SQLXML sqlxml = rs.getSQLXML(index);
                int row = rs.getRow();
                result.add(new HashMap<String, String>() {{put(colName, string);}});
            }
            while (rs.isAfterLast());

        }
        stmt.close();
        con.close();
    }

}
