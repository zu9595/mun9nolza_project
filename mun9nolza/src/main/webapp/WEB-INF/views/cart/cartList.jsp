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
                <th scope="col">상품</th>
                <th scope="col">정가</th>
                <th scope="col">할인가</th>
                <th scope="col">수량</th>
                <th scope="col">총 금액</th>
              </tr>
            </thead>
            <tbody id="cartListTbody" class="cartListTbody">
            
            
              <tr>
                <td>
                  <div class="media">
                    <div class="d-flex">
                      <img src="img/product/single-product/cart-1.jpg" alt="" />
                    </div>
                    <div class="media-body">
                      <p>Minimalistic shop for multipurpose use</p>
                    </div>
                  </div>
                </td>
                
                <td>
                  <h5>$360.00</h5>
                </td>
                
                <td>
                  <h5>$360.00</h5>
                </td>
                
                <td>
                  <div class="product_count">
                    <span class="input-number-decrement"> <i class="ti-angle-down"></i></span>
                    <input class="input-number" type="text" value="1" min="0" max="10">
                    <span class="input-number-increment"> <i class="ti-angle-up"></i></span>
                  </div>
                </td>
                <td>
                  <h5>$720.00</h5>
                </td>
              </tr>
              
              
              
              
              <tr class="bottom_button">
                <td>
                  <a class="btn_1" href="#">선택삭제</a>
                </td>
                <td></td>
                <td>
                  <h5>상품 합산 금액</h5>
                </td>
                <td>
                  <h5>$2160.00</h5>
                </td>
              </tr>
              <tr>
                <td></td>
                <td></td>
                <td>
                  <h5>배송비</h5>
                </td>
                <td>
                  <h5>$2160.00</h5>
                </td>
              </tr>
              <tr class="shipping_area">
                <td></td>
                <td></td>
                <td>
                  <h5>총 금액</h5>
                </td>
                <td>
                  <div class="shipping_box">
                    <ul class="list">
                      
                      <li>
                        <a href="#">Free Shipping</a>
                      </li>
                      
                    </ul>
                    <h6>
                      Calculate Shipping
                      <i class="fa fa-caret-down" aria-hidden="true"></i>
                    </h6>
                    
                  </div>
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
      </div>
  </section>
  <!--================End Cart Area =================-->