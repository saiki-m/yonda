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
    
        <h2>読書記録を追加</h2>
      <p><font color="red">追加できませんでした<br>すべての項目を入力してください</font>        
      	<form action="readingRecAdd" method="post">
	        <input type="text" name="title" class="input-field" placeholder="タイトル">
	        <input type="text" name="author" class="input-field" placeholder="作者">
	        <select name="readStatus" class="input-field" placeholder="読書状況">
				<option value="サンプル1">未登録</option>
				<option value="サンプル2">読みたい</option>
				<option value="サンプル3">積読</option>
				<option value="サンプル1">いま読んでいる</option>
				<option value="サンプル2">読み終わった</option>
				<option value="サンプル3">感想を書いた</option>
			</select><br>
	        <button type="submit" class="cert-btn">OK</button>
	     </form>
  </main>
</body>
</html>