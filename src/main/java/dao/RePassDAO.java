//「スッキリわかるサーブレット＆JSP入門」P392のコード13-3を参考

package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.AccountBean;

public class RePassDAO {
  // データベース接続に使用する情報
  private final String JDBC_URL = "jdbc:mysql://localhost:3306/yonda";
  private final String DB_USER = "root";
  private final String DB_PASS = "moo0921too";

  
  public void rePass(AccountBean account, AccountBean account2) {
	   
	//JDBCドライバを読み込む
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }
    //JDBCドライバが読み込めないとき実行する    
    catch (ClassNotFoundException e) {
        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }
    
    // データベースへ接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
    	
      // SELECT文を準備
      String sql = "UPDATE アカウント SET パスワード=? WHERE アカウントID=? ";
        
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      //WHERE文の?に代入
      pStmt.setString(1, account.getPassword());
      pStmt.setInt(2, account2.getAccountID());
      
      pStmt.executeUpdate();
      conn.commit();
         
    }  
      //tryの中でエラーが出たら、catchのみ実行する
    catch (SQLException e) {
      e.printStackTrace();
    }
    
    
  }
}