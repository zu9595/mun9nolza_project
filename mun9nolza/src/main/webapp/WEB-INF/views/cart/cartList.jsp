<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script> let userId = `${userId}`</script>
<script src="js/cartjs/cart.js"></script>

    <!--================Cart Area =================-->
  <section class="cart_area padding_top">
    <div class="container">
      <div class="cart_inner">
        <div class="table-responsive">
          <table class="table">
            <thead>
              <tr>
              	<th><input type="checkbox" id="f-option" name="selector" class="allCheck"></th>
                <th scope="col">상품</th>
                <th scope="col">정가</th>
                <th scope="col">할인가</th>
                <th scope="col">수량</th>
                <th scope="col">금액</th>
              </tr>
            </thead>
            <tbody id="cartListTbody" class="cartListTbody">
              <tr>
              	<td></td>
                <td></td>
                <td></td>
                <td>
                	<ul>
                		<li><h6>배송비</h6></li>
                		<li><h5>결제금액</h5></li>
                	</ul>                  
                </td>
                <td>
                	<td>
                	<ul>
                		<li><span class="delieveryFee"></span></li>
                		<li><span class="total"></span> 원</li>
                	</ul>                  
                </td>
                
              </tr>  
            </tbody>
          </table>
          
          <div class="checkout_btn_inner float-left">
          	<a class="btn_1" href="#" id="delChecked">선택 삭제</a>
          </div>
          <div class="checkout_btn_inner float-right">
            <a class="btn_1" href="#">쇼핑 계속하기</a>
            <a class="btn_1 checkout_btn_1" href="orderDetailForm.do">주문하기</a>
          </div>
        </div>
      </div>
     </div>
  </section>
  <!--================End Cart Area =================-->