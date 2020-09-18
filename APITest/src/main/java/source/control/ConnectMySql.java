package source.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectMySql {
    private static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/course";
            String user = "root";
            String pass = "123123";
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        String sql = "select * from logincases";
        PreparedStatement stmt;
        List<Map<String ,Object>> requestMapList = new ArrayList<Map<String, Object>>();
        try {
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData data = rs.getMetaData();
            while (rs.next()) {
                Map<String ,Object> requestMap = new HashMap<String, Object>();
                for (int i = 1; i <= data.getColumnCount(); i++) {
                    //获得指定列的列名
                    String columnName = data.getColumnName(i);
                    //获得指定列的列值
                    String columnValue = rs.getString(i);
                    //获得指定列的数据类型名
                    String columnTypeName=data.getColumnTypeName(i);
/*                    System.out.println("获得列" + i + "的字段名称:" + columnName);
                    System.out.println("获得列" + i + "的字段值:" + columnValue);
                    System.out.println("获得列"+i+"的数据类型名:"+columnTypeName);
                    System.out.println("==============");*/
                    if (columnTypeName.equals("INT")) {
                        requestMap.put(columnName,Integer.parseInt(columnValue));
                    }else {
                        requestMap.put(columnName, columnValue);
                    }
                }
                requestMapList.add(requestMap);
            }
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
        }
        System.out.println(requestMapList);
        System.out.println(requestMapList.size());
        System.out.println(requestMapList.get(0).keySet());
        for (String requestName : requestMapList.get(0).keySet()) {
            System.out.println(requestName);
            System.out.println(requestMapList.get(0).get(requestName));
            System.out.println("----------------------------------------");
        }
    }
}
