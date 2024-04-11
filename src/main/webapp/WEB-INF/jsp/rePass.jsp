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
    <h1>
      <a href="index.jsp">yonda！</a>
    </h1>
    <nav>
      <ul>
        <li><a href="bbs.jsp">掲示板</a></li>
        <li><a href="hontaiNews.jsp">本屋大賞通信</a></li>
      </ul>
    </nav>
  </header>
  <main>
    <div class="cert-container">
      <h2>パスワードの再設定</h2>
      <form action="RePass" method="post">
        <input type="password" name="password" class="input-field" placeholder="新しいパスワード">
        <input type="password" name="password2" class="input-field" placeholder="新しいパスワードの確認"><br>
        <button type="submit" class="cert-btn">OK</button>
    </div>
  </main>
  </body>
</html>
