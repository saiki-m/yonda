//「スッキリわかるサーブレット＆JSP入門」コード13-3、コード13-5～13-9を参考

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.ReadingRecBean;

public class ReadingRecAddDAO {
  // データベース接続に使用する情報
  private final String JDBC_URL = "jdbc:mysql://localhost:3306/yonda";
  private final String DB_USER = "root";
  private final String DB_PASS = "moo0921too";

  
  public boolean create(ReadingRecBean readingRec) {
	  
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
      String sql = "INSERT INTO 読書状況(タイトル, 作者, 読書状況)"
    		     + "VALUES (?, ?, ?)";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      //WHERE文の?に代入
      pStmt.setString(1, readingRec.getTitle());
      pStmt.setString(2, readingRec.getAuthor());
      pStmt.setString(3, readingRec.getReadStatus());
      
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
  
  public List<ReadingRecBean> findAll() {
	    List<ReadingRecBean> readingRecList = new ArrayList<>();
  
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
	        String sql = "SELECT タイトル, 作者, 読書状況 FROM 読書状況";
	        PreparedStatement pStmt = conn.prepareStatement(sql);

	        // SELECTを実行し、結果表を取得
	        ResultSet rs = pStmt.executeQuery();

	        // 結果表に格納されたレコードの内容を
	        // readingRec2インスタンスに設定し、readingRecListインスタンスに追加
	        while (rs.next()) {
	          String title = rs.getString("タイトル");
	          String author = rs.getString("作者");
	          String readStatus = rs.getString("読書状況");
	          ReadingRecBean readingRec2 = new ReadingRecBean(title, author, readStatus);
	          readingRecList.add(readingRec2);
	        }
	    }   catch (SQLException e) {
	          e.printStackTrace();
	          return null;
	        }
   return readingRecList;
          
  }   
	    
	    
  
}