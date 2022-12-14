package org.toyproject.DB;

import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.*;

public class JDBCDriverMgr {

    private static Connection conn;

    private JDBCDriverMgr(){ }

    public static Connection getConnection(){
        if(conn == null){
            try{
                DriverManager.registerDriver(new org.h2.Driver());
                conn = DriverManager.getConnection("jdbc:h2:~/JDBC,DB_CLOSE_DELAY=-1","sa2","");
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return conn;
    }

    public void close(Connection conn, PreparedStatement stmt, ResultSet rs){
        try{
            if (rs != null){
                rs.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        try {
            if (stmt != null){
                stmt.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        try {
            if(conn != null){
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
