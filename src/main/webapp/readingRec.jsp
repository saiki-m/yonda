<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>yonda！</title>
</head>
<body>
  <header>
    <jsp:include page = "header.jsp" /> 
  </header>
  
  <main>
  
  	  <div class="top-container">
	  	<a href="myPage.jsp"><img src="./img/myicon.png" alt="マイページ"></a>
	  	<h3>${account.name}さん</h3>
    	<a href="bookShelf.jsp" class="btn">本棚</a>
    	<a href="profile.jsp" class="btn">プロフィール</a>
	  </div>
	  
	<h2>容疑者Xの献身</h2>

    	<table class="bookshelf-table">
		    <tr>
		        <th>タイトル</th>
		        <th>作者</th>
		        <th>読書状況</th>
		    </tr>
		    <tr>
		        <td><a href="readingRec.jsp">容疑者Xの献身</a></td>
		        <td>東野圭吾</td>
		        <td>感想を書いた</td>
		    </tr>
		</table>
		
		<a href="readingRecEdit.jsp" class="btn">編集</a>

</main>
</body>
</html>