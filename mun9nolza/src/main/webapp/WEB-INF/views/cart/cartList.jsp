<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script src="js/cartjs/cart.js"></script>

    <!--================Cart Area =================-->
  <section class="cart_area padding_top">
    <div class="container">
      <div class="cart_inner">
        <div class="table-responsive">
          <table class="table">
            <thead>
              <tr>
              	<th></th>
                <th scope="col">상품</th>
                <th scope="col">정가</th>
                <th scope="col">할인가</th>
                <th scope="col">수량</th>
                <th scope="col">총 금액</th>
              </tr>
            </thead>
            <tbody id="cartListTbody" class="cartListTbody">
              
              
              <tr>
              	<td><input type="checkbox" id="f-option" name="selector"></td>
                <td><a class="btn_1" href="#">선택 삭제</a></td>
                <td></td>
                <td>
                	<ul>
                		<li><h7>배송비</h7></li>
                		<li><h5>총 금액</h5></li>
                	</ul>                  
                </td>
                <td>
                	<td>
                	<ul>
                		<li><h7>$21.00</h7></li>
                		<li><h5>$2160.00</h5></li>
                	</ul>                  
                </td>
                  
                </td>
              </tr>  
            </tbody>
          </table>
          
          <div class="checkout_btn_inner float-right">
            <a class="btn_1" href="#">쇼핑 계속하기</a>
            <a class="btn_1 checkout_btn_1" href="#">주문하기</a>
          </div>
        </div>
      </div>
  </section>
  <!--================End Cart Area =================-->