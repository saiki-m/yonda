<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% //P366、P449参考  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>プロフィールの編集</title>
</head>

<body>
  <header>
    <jsp:include page = "header.jsp" /> 
  </header>
  <main>
	  <div class="top-container">
	  	<a href="myPage.jsp"><img src="./img/myicon.png" alt="マイページ"></a>
	  	<h3><c:out value="${account.name}" />さん</h3>
    	<a href="bookShelf.jsp" class="btn">本棚</a>
    	<a href="profile.jsp" class="btn">プロフィール</a>
	  </div>
	  
    	<h2>プロフィールの編集</h2>

	    	<form action="profile" method="post">
		        <input type="text" name="birthday" class="input-field" placeholder="生年月日">
		        <select name="gender" class="input-field" placeholder="性別">
					<option value="無回答">無回答</option>
					<option value="男">男</option>
					<option value="女">女</option>
				</select>
		        <input type="text" name="Profession" class="input-field" placeholder="職業">
		       
		        <%--「https://yuyauver98.me/template-html-prefectures/」からコピペ --%>
                <select name="prefectures" class="input-field" placeholder="在住都道府県">
                  <option value="" selected>都道府県を選択</option>
				  <option value="北海道">北海道</option>
				  <option value="青森県">青森県</option>
				  <option value="岩手県">岩手県</option>
				  <option value="宮城県">宮城県</option>
				  <option value="秋田県">秋田県</option>
				  <option value="山形県">山形県</option>
				  <option value="福島県">福島県</option>
				  <option value="茨城県">茨城県</option>
				  <option value="栃木県">栃木県</option>
				  <option value="群馬県">群馬県</option>
				  <option value="埼玉県">埼玉県</option>
				  <option value="千葉県">千葉県</option>
				  <option value="東京都">東京都</option>
				  <option value="神奈川県">神奈川県</option>
				  <option value="新潟県">新潟県</option>
				  <option value="富山県">富山県</option>
				  <option value="石川県">石川県</option>
				  <option value="福井県">福井県</option>
				  <option value="山梨県">山梨県</option>
				  <option value="長野県">長野県</option>
				  <option value="岐阜県">岐阜県</option>
				  <option value="静岡県">静岡県</option>
				  <option value="愛知県">愛知県</option>
				  <option value="三重県">三重県</option>
				  <option value="滋賀県">滋賀県</option>
				  <option value="京都府">京都府</option>
				  <option value="大阪府">大阪府</option>
				  <option value="兵庫県">兵庫県</option>
				  <option value="奈良県">奈良県</option>
				  <option value="和歌山県">和歌山県</option>
				  <option value="鳥取県">鳥取県</option>
				  <option value="島根県">島根県</option>
				  <option value="岡山県">岡山県</option>
				  <option value="広島県">広島県</option>
				  <option value="山口県">山口県</option>
				  <option value="徳島県">徳島県</option>
				  <option value="香川県">香川県</option>
				  <option value="愛媛県">愛媛県</option>
				  <option value="高知県">高知県</option>
				  <option value="福岡県">福岡県</option>
				  <option value="佐賀県">佐賀県</option>
				  <option value="長崎県">長崎県</option>
				  <option value="熊本県">熊本県</option>
				  <option value="大分県">大分県</option>
				  <option value="宮崎県">宮崎県</option>
				  <option value="鹿児島県">鹿児島県</option>
				  <option value="沖縄県">沖縄県</option>
				</select>
				
                <input type="text" name="keyword" class="input-field" placeholder="パーソナルタグ"><br>
                <input type="text" name="favorite_1" class="input-field" placeholder="好きなジャンル1位"><br>
                <input type="text" name="favorite_2" class="input-field" placeholder="好きなジャンル2位"><br>
                <input type="text" name="favorite_3" class="input-field" placeholder="好きなジャンル3位"><br>
                <input type="text" name="likeAuthor_1" class="input-field" placeholder="好きな作家1位"><br>
                <input type="text" name="likeAuthor_2" class="input-field" placeholder="好きな作家2位"><br>
                <input type="text" name="likeAuthor_3" class="input-field" placeholder="好きな作家3位"><br>
                <input type="text" name="favorite_1" class="input-field" placeholder="お気に入りの本1位"><br>
                <input type="text" name="favorite_2" class="input-field" placeholder="お気に入りの本2位"><br>
                <input type="text" name="favorite_3" class="input-field" placeholder="お気に入りの本3位"><br>
                
	        <button type="submit" class="cert-btn">保存</button>
	      	</form>
		
		<a href="logout.jsp" class="logout-btn">ログアウト</a>

</main>
</body>
</html>