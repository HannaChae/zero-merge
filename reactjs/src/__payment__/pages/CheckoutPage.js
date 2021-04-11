import PropTypes from "prop-types";
import React, { useState, useEffect, Fragment } from "react";
import { Link } from "react-router-dom";
import MetaTags from "react-meta-tags";
import { connect } from "react-redux";
import { BreadcrumbsItem } from "react-breadcrumbs-dynamic";
import { getDiscountPrice } from "helpers/product";
import LayoutOne from "layouts/LayoutOne";
import Breadcrumb from "wrappers/breadcrumb/Breadcrumb";
import SectionTitleTwo from "components/section-title/SectionTitleTwo";
import { PaymentRcv, PaymentPost, PaymentAPI } from "__payment__/index"

const CheckoutPage = ({ location, cartItems, currency, payments}) => {

  const [payInfo, setPayInfo] = useState([])

  // localStorage.setItem("pay", JSON.stringify(payments))

  // useEffect(()=>{
  //   localStorage.setItem("cart", JSON.stringify(cartItems))
  //   setPayment(JSON.parse(localStorage.getItem("payment")))
  // }, [])

  const { pathname } = location;
  let cartTotalPrice = 0;

  return (<>
  {localStorage.getItem("token") === null ?
  <>
  <MetaTags>
        <title>Flone | Checkout</title>
        <meta
          name="description"
          content="Checkout page of flone react minimalist eCommerce template."
        />
      </MetaTags>
      <BreadcrumbsItem to={process.env.PUBLIC_URL + "/"}>Home</BreadcrumbsItem>
      <BreadcrumbsItem to={process.env.PUBLIC_URL + pathname}>
        Checkout
      </BreadcrumbsItem>
      <LayoutOne headerTop="visible">
        {/* breadcrumb */}
        <Breadcrumb />
      <div className="container">
        {/* section title */}
        <SectionTitleTwo
          titleText="로그인 후 구매해주세요."
          subTitleText="zero-shop을 이용해주셔서 감사합니다."
          positionClass="text-center"
          spaceClass="mb-60"
        />
      </div>
        </LayoutOne>
      </>
      :
      <>
      <MetaTags>
        <title>Flone | Checkout</title>
        <meta
          name="description"
          content="Checkout page of flone react minimalist eCommerce template."
        />
      </MetaTags>
      <BreadcrumbsItem to={process.env.PUBLIC_URL + "/"}>Home</BreadcrumbsItem>
      <BreadcrumbsItem to={process.env.PUBLIC_URL + pathname}>
        Checkout
      </BreadcrumbsItem>
      <LayoutOne headerTop="visible">
        {/* breadcrumb */}
        <Breadcrumb />
        <div className="checkout-area pt-95 pb-100">
          <div className="container">
            {cartItems && cartItems.length >= 1 ? (
              <div className="row">
                <div className="col-lg-7">
                  <div className="billing-info-wrap">
                    <h3>User Info</h3>
                    <PaymentPost />
                    <h3>Billing Details</h3>
                    <PaymentRcv />
                    </div>
                </div>
                <div className="col-lg-5">
                  <div className="your-order-area">
                    <h3>Your order</h3>
                    <div className="your-order-wrap gray-bg-4">
                      <div className="your-order-product-info">
                        <div className="your-order-top">
                          <ul>
                            <li>Product</li>
                            <li>Total</li>
                          </ul>
                        </div>
                        <div className="your-order-middle">
                          <ul>
                            {cartItems.map((cartItem, key) => {
                              const discountedPrice = getDiscountPrice(
                                cartItem.prdPrice,
                                cartItem.discount
                              );
                              const finalProductPrice = (
                                cartItem.prdPrice * currency.currencyRate
                              );
                              const finalDiscountedPrice = (
                                discountedPrice * currency.currencyRate
                              );

                              discountedPrice != null
                                ? (cartTotalPrice +=
                                    finalDiscountedPrice * cartItem.quantity)
                                : (cartTotalPrice +=
                                    finalProductPrice * cartItem.quantity);
                              return (
                                <li key={key}>
                                  <span className="order-middle-left">
                                  {cartItem.prdName+` X `+cartItem.quantity}
                                  <input type="hidden" name="payInfo" value={cartItem.prdName} 
                                  readOnly onChange = { e => { setPayInfo(`${e.target.value}`)}} /> 
                                  </span>{" "}
                                  <span className="order-price">
                                    {discountedPrice !== null
                                      ? currency.currencySymbol +
                                        (
                                          finalDiscountedPrice *
                                          cartItem.quantity
                                        )
                                      : currency.currencySymbol +
                                        (
                                          finalProductPrice * cartItem.quantity
                                        )}
                                  </span>
                                </li>
                              );
                            })}
                            {/* {payments.map((payment, key) => {
                              payment.prdName
                            })} */}
                          </ul>
                        </div>
                        <div className="your-order-bottom">
                          <ul>
                            <li className="your-order-shipping">Shipping</li>
                            <li>{cartTotalPrice < 50000 ? "￦2500" : "무료배송"}
                              <input type="hidden" name="shipping" value={cartTotalPrice < 50000 ? "￦2500" : "무료배송"} readOnly /></li>
                          </ul>
                        </div>
                        <div className="your-order-total">
                          <ul>
                            <li className="order-total">Total</li>
                            <li>{cartTotalPrice < 50000 ? currency.currencySymbol + (cartTotalPrice + 2500) 
                          : currency.currencySymbol + cartTotalPrice}
                              <input type="hidden" name="payPrice" value={cartTotalPrice < 50000 ? currency.currencySymbol + (cartTotalPrice + 2500) 
                          : currency.currencySymbol + cartTotalPrice} readOnly />
                            </li>
                          </ul>
                        </div>
                      </div>
                      <div className="payment-method"></div>
                    </div>
                    <div className="place-order mt-25">
                     {/* <button className="btn-hover" type="submit" onClick= {onClickPayment}>Place Order</button> */}
                    </div>
                  </div>
                </div>
              </div>
            ) : (
              <div className="row">
                <div className="col-lg-12">
                  <div className="item-empty-area text-center">
                    <div className="item-empty-area__icon mb-30">
                      <i className="pe-7s-cash"></i>
                    </div>
                    <div className="item-empty-area__text">
                      No items found in cart to checkout <br />{" "}
                      <Link to={process.env.PUBLIC_URL + "/shop-grid-standard"}>
                        Shop Now
                      </Link>
                    </div>
                  </div>
                </div>
              </div>
            )}
          </div>
        </div>
      </LayoutOne>
      </>
      }
      </>
  );
};

CheckoutPage.propTypes = {
  cartItems: PropTypes.array,
  currency: PropTypes.object,
  location: PropTypes.object,
  payments: PropTypes.array
};

const mapStateToProps = state => {
  return {
    cartItems: state.cartData,
    currency: state.currencyData
  };
};

export default connect(mapStateToProps)(CheckoutPage);
