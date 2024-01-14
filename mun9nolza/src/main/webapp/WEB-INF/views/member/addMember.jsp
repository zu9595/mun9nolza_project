<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
        <html lang="ko">

        <head>
          <meta charset="UTF-8">
          <meta http-equiv="X-UA-Compatible" content="IE=edge">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <title>회원가입</title>

          <!-- Bootstrap CSS -->
          <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
          <!-- 상대경로로 이동 -> 파일위치에서 폴더에서 나가주고 폴더를 들어가야함 -->
          <link rel="stylesheet" href="../../css/membercss/signUp.css">
        </head>

        <body>
          <div class="container">
            <div class="input-form-backgroud row">
              <div class="input-form col-md-5 mx-auto">
                <div class="img-logo">
                  <a href="http://localhost/mun9nolza/">
                    <img src="http://localhost/mun9nolza/img/logo.png" alt="logo">
                  </a>
                </div>
                <!-- 서버로 정보전송 -->
                <form action="addMember.do" class="validation-form" novalidate>
                  <!-- <div class="row"> -->

                    <div class="col-xs-12 col-md-6 mb-3" style="margin-left:15px;">
                      <br>
                      <label for="id" style="margin-top: 5px;">아이디</label>
                      <input type="text" class="form-control" required style="width: 380px;" id="id">
                      <label for="pw" style="margin-top: 5px;">비밀번호</label>
                      <input type="password" class="form-control" required style="width: 380px;" id="pw">
                      <label for="pwCheck" style="margin-top: 5px;">비밀번호 확인</label>
                      <input type="password" class="form-control" required style="width: 380px;" id="pwCheck">
                      <br>
                      <label for="name" style="margin-top: 5px;">이름</label>
                      <input type="text" class="form-control" required style="width: 380px;" id="name">
                      <label for="birth" style="margin-top: 5px;">생년월일</label>
                      <input type="text" class="form-control" placeholder="8자리" required style="width: 380px;"
                        id="birth">
                      <br>
                      <label for="gender" style="margin-top: 5px;" >성별</label>
                      <br>
                      <div class="genderBox">
                      <label for="male">남성</label>
                      <input type='radio' name='gender' value='male' id="male"/>
                      <label for="female">여성</label>
                      <input type='radio' name='gender' value='female' id="female" />
                      </div>

                      <label for="phone" required style="margin-top: 20px;">휴대전화</label>
                        <select class="form-control" style="width: 100px;">
                          <option value="010" selected>010</option>
                          <option value="011">011</option>
                          <option value="016">016</option>
                          <option value="017">017</option>
                          <option value="018">018</option>
                          <option value="019">019</option>
                        </select>
                        <span> - </span>
                        <input type="tel" class="form-control" id="phone1" style="width: 100px;">
                        <span> - </span>
                        <input type="tel" class="form-control" id="phone2" style="width: 100px;">
                        <br>
                        <label for="email">이메일</label>
                        <input type="email" class="form-control" style="width: 380px;" placeholder="you@mun9nolza.com" id="email">
                    </div>
                  <!-- </div> -->
              <br>
            
            <hr class="mb-4">
            <div class="custom-control custom-checkbox">
              <input type="checkbox" class="custom-control-input" id="aggrement" required>
              <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
            </div>
            <div class="mb-4"></div>
            <button type="submit" class="btn btn-primary btn-lg btn-block" >회원가입</button>
            </form>
          </div>
          </div>
          <footer class="my-3 text-center text-small">
          </footer>
          </div>

</body>
</html>