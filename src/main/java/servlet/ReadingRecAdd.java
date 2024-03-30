//「スッキリわかるサーブレット＆JSP入門」P298のコード10-14、55行目～69行目参考

package servlet;

import java.io.IOException;
import java.util.List;

import beans.ReadingRecBean;
import dao.ReadingRecAddDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ReadingRecAdd")
public class ReadingRecAdd extends HttpServlet {
  private static final long serialVersionUID = 1L; 

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // リクエストパラメータを取得
    request.setCharacterEncoding("UTF-8");
    String title = request.getParameter("title");
    String author = request.getParameter("author");
    String readStatus = request.getParameter("readStatus");
    
    //入力情報をインスタンスに保存
    ReadingRecBean readingRec = new ReadingRecBean(title, author, readStatus);
    
    ReadingRecAddDAO dao = new ReadingRecAddDAO();
    boolean Rec = dao.create(readingRec);
    
    //追加できたとき
	if(Rec) {
		
		List<ReadingRecBean> readingRecList = dao.findAll();
		System.out.println(readingRecList);
		
		response.sendRedirect("http://localhost:8080/yonda/readingRecAddResult.jsp"); 
	}
	
	//追加できなかったとき
	else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/readingRecAddFailure.jsp");
        dispatcher.forward(request, response);
    }
	
  }
}