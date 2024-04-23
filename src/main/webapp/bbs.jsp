<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>掲示板</title>
</head>
<body>
  <header>
    <jsp:include page = "header.jsp" /> 
  </header>
  <main>
    <h2>掲示板</h2>
		<div class="sortSearch-container">
			<div class="sortSearch-btn">並べ替え</div>
			<input type="text" class="search-box" placeholder="キーワードを入力">
			<div class="sortSearch-btn">検索</div>
		</div>
      <div class="bbs-container">
	      <div class="bbs-content">
	      	<div class="top-area">189</div>
	      	<div class="bottom-area">うろおぼえのあの本、いっしょに探してください</div>
	      </div>
	      
	      <div class="bbs-content">
	      	<div class="top-area">204</div>
	      	<div class="bottom-area">自分を作った小説5選</div>
	      </div>
	      
	      <div class="bbs-content">
	      	<div class="top-area">511</div>
	      	<div class="bottom-area">名作を140字で紹介</div>
	      </div>
	      
	      <div class="bbs-content">
	      	<div class="top-area">61</div>
	      	<div class="bottom-area">ドストエフスキー占い</div>
	      </div>
	      
	      <div class="bbs-content">
	      	<div class="top-area">88</div>
	      	<div class="bottom-area">夢野久作沼</div>
	      </div>
	      
	      <div class="bbs-content">
	      	<div class="top-area">685</div>
	      	<div class="bottom-area">【求】本棚収納アイデア</div>
	      </div>	      
	      
	      <div class="bbs-content">
	      	<div class="top-area">167</div>
	      	<div class="bottom-area">積読何冊あります？</div>
	      </div>	      
	      
	      <div class="bbs-content">
	      	<div class="top-area">345</div>
	      	<div class="bottom-area">仕事がつらい時に読む本</div>
	      </div>	      
	      
	      <div class="bbs-content">
	      	<div class="top-area">109</div>
	      	<div class="bottom-area">ペットに好きな登場人物の名前を付けたことありますか。</div>
	      </div>
	      
	      <div class="bbs-content">
	      	<div class="top-area">412</div>
	      	<div class="bottom-area">電子派？紙派？</div>
	      </div>	      
	      
	      <div class="bbs-content">
	      	<div class="top-area">82</div>
	      	<div class="bottom-area">絶版作品取引所</div>
	      </div>	      
	      
	      <div class="bbs-content">
	      	<div class="top-area">261</div>
	      	<div class="bottom-area">春休みにおすすめの作品</div>
	      </div>	      
	      
      </div>
  </main>
  </body>
</html>
