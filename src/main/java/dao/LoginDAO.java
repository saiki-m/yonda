//「スッキリわかるサーブレット＆JSP入門」P392のコード13-3を参考

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.AccountBean;

public class LoginDAO {
  // データベース接続に使用する情報
  private final String JDBC_URL = "jdbc:mysql://localhost:3306/yonda";
  private final String DB_USER = "root";
  private final String DB_PASS = "moo0921too";

  
//６５行目の「return accountID」ができるよう初期設定しておく。
  AccountBean accountID = null;
  
  
  public AccountBean findAccountID(AccountBean account) {
	  
	  
    //JDBCドライバを読み込む
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }
    //JDBCドライバが読み込めない（try文の中でエラーが出た）とき実行する    
    catch (ClassNotFoundException e) {
        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }
    
    // データベースへ接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
    	
      // SELECT文を準備。
      // アカウントテーブルからアカウント名が一致し、パスワードも一致するアカウントIDを表示。
      String sql = "SELECT アカウントID FROM アカウント WHERE アカウント名=? AND パスワード=?";
        
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      //WHERE文の?に代入
      pStmt.setString(1, account.getName());
      pStmt.setString(2, account.getPassword());

      
      // SELECTを実行し、結果表を取得
      ResultSet rs = pStmt.executeQuery();
      
	      // 結果表にあるアカウントIDをaccountIDインスタンスに保存。
	      while (rs.next()) {
	        int ID = rs.getInt("アカウントID");
	          accountID = new AccountBean(ID);
	      }
	      
    }  
      //tryの中でエラーが出たら、catchのみ実行する
    catch (SQLException e) {
      e.printStackTrace();
    return null;   //Login.javaの35行目、dao.findAccountID(account)にnullが入る。
    }                
    
  //アカウントIDを取得できたとき
  return accountID;   //accountIDインスタンスにアカウントIDが入っている状態。
                          
  }
}