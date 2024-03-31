//「スッキリわかるサーブレット＆JSP入門」P298のコード10-14、55行目～69行目参考
//P298のコード10-13

//本棚に読書記録を追加する

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
import jakarta.servlet.http.HttpSession;

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
    
    //データベースyondaの読書状況に読書記録追加
    ReadingRecAddDAO dao = new ReadingRecAddDAO();
    boolean Rec = dao.create(readingRec);
    
    //追加できたとき
	if(Rec) {
		
		//登録済みの読書記録を取得
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")  //一行下のコードの警告対策。「ReadingRecBean」だと警告は出ないが、Listがついてると出てしまう。
		List<ReadingRecBean> recList = (List<ReadingRecBean>)session.getAttribute("readingRecList");
		
		//リストの先頭に追加。「0」で先頭にしている。
		recList.add(0, readingRec);
		
		//「readingRecList」のように、取得先と同じ名前で保存
		session.setAttribute("readingRecList", recList);
		
		response.sendRedirect("http://localhost:8080/yonda/readingRecAddResult.jsp"); 
	}
	
	//追加できなかったとき
	else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/readingRecAddFailure.jsp");
        dispatcher.forward(request, response);
    }
	
  }
}