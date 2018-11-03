//package com.zsm.phoenix.conn;//package com.zsm;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.sun.istack.Nullable;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//
//import javax.sql.DataSource;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//
///**
// * @Author: zengsm.
// * @Description: TODO()
// * @Date:Created in 2018/9/3.
// * @Modified By:
// */
//@Configuration
//public class PhoenixConnector
//{
//    private static final Logger LOGGER = LoggerFactory.getLogger(PhoenixConnector.class);
//
//    @Autowired
//    private Environment env;
//
//    @Bean(name = "phoenixJdbcDataSource")
//    @Qualifier("phoenixJdbcDataSource")
//    public DataSource dataSource()
//    {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(env.getProperty("phoenix.url"));
//        dataSource.setDriverClassName(env.getProperty("phoenix.driver-class-name"));
//        dataSource.setUsername(env.getProperty("phoenix.username"));//phoenix的用户名默认为空
//        dataSource.setPassword(env.getProperty("phoenix.password"));//phoenix的密码默认为空
//        dataSource.setDefaultAutoCommit(Boolean.valueOf(env.getProperty("phoenix.default-auto-commit")));
//
////        Properties connectionProperties = new Properties();
////        connectionProperties.setProperty(QueryServices.MAX_MUTATION_SIZE_ATTRIB,"10000000"); //改变默认的500000
////        connectionProperties.setProperty(QueryServices.IMMUTABLE_ROWS_ATTRIB,"10000000"); // 默认是500000
////        connection = DriverManager.getConnection("jdbc:phoenix:ulvdtlchd01:2181",connectionProperties);
//
//
//        return dataSource;
//    }
//
//    @Bean(name = "phoenixJdbcTemplate")
//    public JdbcTemplate phoenixJdbcTemplate(@Qualifier("phoenixJdbcDataSource") DataSource dataSource)
//    {
//        return new JdbcTemplate(dataSource);
//    }
//
////    public static Connection conn = null;
////
////    private PhoenixConnector()
////    {
////    }
////
////    static
////    {
////        try
////        {
////            Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
////        }
////        catch (ClassNotFoundException e)
////        {
////            e.printStackTrace();
////            LOGGER.error("PhoenixDriver load error", e);
////        }
////    }
////
////    public static Connection getConnection()
////        throws SQLException
////    {
////        if (conn == null)
////        {
////            conn = DriverManager.getConnection("jdbc:phoenix:58.16.67.200,58.16.67.32,58.16.67.29,58.16.67.245,58.16.67.92:2181");
////        }
////        return conn;
////    }
////
//    public T List<T> findArticle(String keyword)
//    {
//        List<T> articleInfos = new ArrayList<>();
////        try
////        {
//            JdbcTemplate conn = phoenixJdbcTemplate;
//
////            Statement statement = conn.execute();
//            String sql = String.format(
//                "select \"0\".\"1\",\"0\".\"2\",\"0\".\"3\",\"0\".\"4\",\"0\".\"12\",\"0\".\"13\",\"0\".\"14\"," +
//                "\"0\".\"15\",\"0\".\"17\",\"0\".\"20\",\"0\".\"29\",\"0\".\"30\",\"0\".\"31\",\"0\".\"32\"," +
//                "\"0\".\"33\",\"0\".\"40\",\"0\".\"41\" from \"sentiments:ArticleData\" " +
//                "where \"12\" like '%s%%' or \"14\" like '%s%%' or \"15\" like '%s%%'", keyword,keyword, keyword);
//
////          conn.execute(sql);
//            List list = conn.query(sql, new RowMapper()
//            {
//                @Nullable
//                @Override
//                public Object mapRow(ResultSet rs, int rowNum)
//                    throws SQLException
//                {
//                    return rs;
//                }
//            });
//            articleInfos=list;
//
////            ResultSet set = statement.executeQuery(sql);
////            while (set.next())
////            {
////                ArticleInfo article = new ArticleInfo();
////
////                articleInfos.add(article);
////            }
////        }
////        catch (SQLException e)
////        {
////            e.printStackTrace();
////        }
//        return articleInfos;
//}
//
//}
