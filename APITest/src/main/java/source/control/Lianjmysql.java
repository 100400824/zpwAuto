package source.control;

import java.sql.*;

public class Lianjmysql
{

    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.99.100:3306/course";

    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&serverTimezone=UTC";


    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123123";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{

            Class.forName(JDBC_DRIVER);                               // 注册 JDBC 驱动


            System.out.println("连接数据库...");                       // 打开链接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);


            System.out.println(" 实例化Statement对象...");       // 执行查询
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT COUNT(*) FROM logincases";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println();

            // 展开结果集数据库
         /*   while(rs.next()){
                // 通过字段检索
                String mz = rs.getString("mz");
                String bz = rs.getString("bz");

                // 输出数据
                System.out.print("ID: " + sx);
                System.out.print("  ,  名字: " + mz);
                System.out.print("  , 不知: " + bz);
                System.out.print("\n");
            }*/
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();

        }catch(SQLException se)        {
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e)        {
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally                      {
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }


}
