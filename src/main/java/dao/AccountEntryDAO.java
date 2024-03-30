//「スッキリわかるサーブレット＆JSP入門」コード13-3、コード13-5～13-9を参考

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.AccountBean;

public class AccountEntryDAO {
  // データベース接続に使用する情報
  private final String JDBC_URL = "jdbc:mysql://localhost:3306/yonda";
  private final String DB_USER = "root";
  private final String DB_PASS = "moo0921too";

  
  public boolean create(AccountBean account) {
	  
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
      String sql = "INSERT INTO アカウント(アカウント名, パスワード, メールアドレス, 秘密の質問, プロフィールID)\r\n"
      		        + "VALUES (?, ?, ?, ?, 1)";
        
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      //WHERE文の?に代入
      pStmt.setString(1, account.getName());
      pStmt.setString(2, account.getPassword());
      pStmt.setString(3, account.getMailAd());
      pStmt.setString(4, account.getSecret_q());

      // INSERT文を実行（resultには追加された行数が代入される）
      int result = pStmt.executeUpdate();
      if (result != 1) {
        return false;
      }
	      
    }  
      //try文の中でエラーが出たとき実行する
    catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    
    //できたとき
    return true;
  }
}