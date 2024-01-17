<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- product_list part start-->
<section class="product_list best_seller section_padding">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-12">
                <div class="section_tittle text-center">
                    <h2>Best</h2>
                </div>
            </div>
        </div>
        <div class="row align-items-center justify-content-between">
            <div class="col-lg-12">
                <div class="best_product_slider owl-carousel">
                    <div class="single_product_item">
                        <img src="img/product/product_1.png" alt="">
                        <div class="single_product_text">
                            <h4>Quartz Belt Watch</h4>
                            <h3>$150.00</h3>
                        </div>
                    </div>
                    <div class="single_product_item">
                        <img src="img/product/product_2.png" alt="">
                        <div class="single_product_text">
                            <h4>Quartz Belt Watch</h4>
                            <h3>$150.00</h3>
                        </div>
                    </div>
                    <div class="single_product_item">
                        <img src="img/product/product_3.png" alt="">
                        <div class="single_product_text">
                            <h4>Quartz Belt Watch</h4>
                            <h3>$150.00</h3>
                        </div>
                    </div>
                    <div class="single_product_item">
                        <img src="img/product/product_4.png" alt="">
                        <div class="single_product_text">
                            <h4>Quartz Belt Watch</h4>
                            <h3>$150.00</h3>
                        </div>
                    </div>
                    <div class="single_product_item">
                        <img src="img/product/product_5.png" alt="">
                        <div class="single_product_text">
                            <h4>Quartz Belt Watch</h4>
                            <h3>$150.00</h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- product_list part start-->

<section class="feature_part padding_top">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-8">
                <div class="section_tittle text-center">
                    <h2>Featured Category</h2>
                </div>
            </div>
        </div>
        <div class="row align-items-center justify-content-between">
            <div class="col-lg-7 col-sm-6">
                <div class="single_feature_post_text">
                    <p>Premium Quality</p>
                    <h3>Latest foam Sofa</h3>
                    <a href="#" class="feature_btn">EXPLORE NOW <i class="fas fa-play"></i></a>
                    <img src="img/feature/feature_1.png" alt="">
                </div>
            </div>
            <div class="col-lg-5 col-sm-6">
                <div class="single_feature_post_text">
                    <p>Premium Quality</p>
                    <h3>Latest foam Sofa</h3>
                    <a href="#" class="feature_btn">EXPLORE NOW <i class="fas fa-play"></i></a>
                    <img src="img/feature/feature_2.png" alt="">
                </div>
            </div>
            <div class="col-lg-5 col-sm-6">
                <div class="single_feature_post_text">
                    <p>Premium Quality</p>
                    <h3>Latest foam Sofa</h3>
                    <a href="#" class="feature_btn">EXPLORE NOW <i class="fas fa-play"></i></a>
                    <img src="img/feature/feature_3.png" alt="">
                </div>
            </div>
            <div class="col-lg-7 col-sm-6">
                <div class="single_feature_post_text">
                    <p>Premium Quality</p>
                    <h3>Latest foam Sofa</h3>
                    <a href="#" class="feature_btn">EXPLORE NOW <i class="fas fa-play"></i></a>
                    <img src="img/feature/feature_4.png" alt="">
                </div>
            </div>
        </div>
    </div>
</section>
<!-- upcoming_event part start-->

<!-- product_list start-->
<section class="product_list section_padding">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-12">
                <div class="section_tittle text-center">
                    <h2>할인상품</h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="product_list_slider owl-carousel">
                    <!-- 할인 상품 목록 1-->
                    <div class="single_product_list_slider">
                        <div class="row align-items-center justify-content-between prodiscountlist1">
                            <!-- 상품 단건 1-->
                            <!-- <div class="col-lg-3 col-sm-6">
                                <div class="single_product_item">
                                    <img src="img/product/product_8.png" alt="">
                                    <div class="single_product_text">
                                        <h4>Quartz Belt Watch</h4>
                                        <h3>$150.00</h3>
                                        <a href="#" class="add_cart">+ add to cart<i class="ti-heart"></i></a>
                                    </div>
                                </div>
                            </div> -->
                            <!-- 상품 단건 1 end-->
                        </div>
                    </div>
                    <!-- 할인 상품 목록 1 end-->
                    <!-- 할인 상품 목록 2 -->
                    <div class="single_product_list_slider">
                        <div class="row align-items-center justify-content-between prodiscountlist2">
                            <!-- 상품 단건 2-->
                            <!-- <div class="col-lg-3 col-sm-6">
                                <div class="single_product_item">
                                    <img src="img/product/product_8.png" alt="">
                                    <div class="single_product_text">
                                        <h4>Quartz Belt Watch</h4>
                                        <h3>$150.00</h3>
                                        <a href="#" class="add_cart">+ add to cart<i class="ti-heart"></i></a>
                                    </div>
                                </div>
                            </div> -->
                            <!-- 상품 단건 2 end-->
                        </div>
                    </div>
                    <!-- 할인 상품 목록 2 end-->
                </div>
            </div>
        </div>
    </div>
</section>
<!-- product_list part start-->
<script>
    let Dcntlist1 = document.querySelector('.prodiscountlist1');
    let Dcntlist2 = document.querySelector('.prodiscountlist2');
    showList('y');
    
    //Ajax호출.
    function showList(saleyn){
        fetch('productPagingList.do?saleyn=' + saleyn)
		.then(str => str.json())
		.then(result => {
            console.log("ajax 호출");
            let ul = '';
            result.list.forEach(product => {
                for(let i = 1; i < 16; i++){
                    let li = makeLi(product);
                    ul += li;
                    if(i = 8){
                        Dcntlist1.insertAdjacentHTML('afterbegin',ul);
                        ul = '';
                    } else if(i = 16){
                        Dcntlist2.insertAdjacentHTML('afterbegin',ul);
                        ul = '';
                    }
                }
            })
		})
		.catch(reject => console.log(reject));
	} // end of showList.

    function makeLi(product = {}){
        console.log(product);
        // <div class="col-lg-3 col-sm-6">
        //                         <div class="single_product_item">
        //                             <img src="img/product/product_8.png" alt="">
        //                             <div class="single_product_text">
        //                                 <h4>Quartz Belt Watch</h4>
        //                                 <h3>$150.00</h3>
        //                                 <a href="#" class="add_cart">+ add to cart<i class="ti-heart"></i></a>
        //                             </div>
        //                         </div>
        //                     </div>
    }
</script>
