import PropTypes from "prop-types"
import React from "react"
import { Link } from "react-router-dom"
import { useToasts } from "react-toast-notifications"
import MetaTags from "react-meta-tags"
import { BreadcrumbsItem } from "react-breadcrumbs-dynamic"
import { connect } from "react-redux"
import { Layout, Breadcrumb } from "__common__/index"
import { addToCart } from "redux/actions/cartActions"
import { addToWishlist, deleteFromWishlist, deleteAllFromWishlist } from "redux/actions/wishlistActions"

const WishlistPage = ({
  location,
  cartItems,
  currency,
  addToCart,
  wishlistItems,
  deleteFromWishlist,
  deleteAllFromWishlist
}) => {
  const { pathname } = location
  const { addToast } = useToasts()

  return (<>
    <MetaTags>
      <title>ZER0 SHOP | Wishlist</title>
    </MetaTags>

    <BreadcrumbsItem to={process.env.PUBLIC_URL + "/"}>Home</BreadcrumbsItem>
    <BreadcrumbsItem to={process.env.PUBLIC_URL + pathname}>Wishlist</BreadcrumbsItem>

    <Layout headerTop="visible">
      {/* breadcrumb */}
      <Breadcrumb />
      <div className="cart-main-area pt-90 pb-100">
        <div className="container">
          {wishlistItems && wishlistItems.length >= 1 ? (
            <>
              <h3 className="cart-page-title">Your wishlist items</h3>
              <div className="row">
                <div className="col-12">
                  <div className="table-content table-responsive cart-table-content">
                    <table>
                      <thead>
                        <tr>
                          <th>Image</th>
                          <th>Product Name</th>
                          <th>Unit Price</th>
                          <th>Add To Cart</th>
                          <th>action</th>
                        </tr>
                      </thead>
                      <tbody>
                        {wishlistItems.map((wishlistItem, key) => {
                          const finalProductPrice = (
                            wishlistItem.prdPrice * currency.currencyRate
                          )
                          const cartItem = cartItems.filter(
                            item => item.prdNo === wishlistItem.prdNo
                          )[0]
                          return (
                            <tr key={key}>
                              <td className="product-thumbnail">
                                <Link
                                  to={
                                    process.env.PUBLIC_URL +
                                    "/product-detail/" +
                                    wishlistItem.prdNo
                                  }
                                >
                                  <img
                                    className="img-fluid"
                                    src={
                                      process.env.PUBLIC_URL +
                                      wishlistItem.prdImg
                                    }
                                    alt=""
                                  />
                                </Link>
                              </td>

                              <td className="product-name text-center">
                                <Link
                                  to={
                                    process.env.PUBLIC_URL +
                                    "/product-detail/" +
                                    wishlistItem.prdNo
                                  }
                                >
                                  {wishlistItem.prdName}
                                </Link>
                              </td>

                              <td className="product-price-cart">
                                <span className="amount">
                                  {currency.currencySymbol +
                                    finalProductPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")}
                                  </span>
                              </td>

                              <td className="product-wishlist-cart">
                                {wishlistItem.prdInv &&
                                  wishlistItem.prdInv > 0 ? (
                                  <button
                                    onClick={() =>
                                      addToCart(wishlistItem, addToast)
                                    }
                                    className={
                                      cartItem !== undefined &&
                                      cartItem.quantity > 0
                                        ? "active"
                                        : ""
                                    }
                                    disabled={
                                      cartItem !== undefined &&
                                      cartItem.quantity > 0
                                    }
                                    title={
                                      wishlistItem !== undefined
                                        ? "Added to cart"
                                        : "Add to cart"
                                    }
                                  >
                                    {cartItem !== undefined &&
                                    cartItem.quantity > 0
                                      ? "Added"
                                      : "Add to cart"}
                                  </button>
                                ) : (
                                  <button disabled className="active">
                                    Out of stock
                                  </button>
                                )}
                              </td>

                              <td className="product-remove">
                                <button
                                  onClick={() =>
                                    deleteFromWishlist(wishlistItem, addToast)
                                  }
                                >
                                  <i className="fa fa-times"></i>
                                </button>
                              </td>
                            </tr>
                          )
                        })}
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>

              <div className="row">
                <div className="col-lg-12">
                  <div className="cart-shiping-update-wrapper">
                    <div className="cart-shiping-update">
                      <Link
                        to={process.env.PUBLIC_URL + "/product-all"}
                      >
                        Continue Shopping
                      </Link>
                    </div>
                    <div className="cart-clear">
                      <button onClick={() => deleteAllFromWishlist(addToast)}>
                        Clear Wishlist
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </>
          ) : (
            <div className="row">
              <div className="col-lg-12">
                <div className="item-empty-area text-center">
                  <div className="item-empty-area__icon mb-30">
                    <i className="pe-7s-like"></i>
                  </div>
                  <div className="item-empty-area__text">
                    No items found in wishlist <br />{" "}
                    <Link to={process.env.PUBLIC_URL + "/product-all"}>
                      Add Items
                    </Link>
                  </div>
                </div>
              </div>
            </div>
          )}
        </div>
      </div>
    </Layout>
  </>)
}

WishlistPage.propTypes = {
  addToCart: PropTypes.func,
  cartItems: PropTypes.array,
  currency: PropTypes.object,
  location: PropTypes.object,
  deleteAllFromWishlist: PropTypes.func,
  deleteFromWishlist: PropTypes.func,
  wishlistItems: PropTypes.array
}

const mapStateToProps = state => {
  return {
    cartItems: state.cartData,
    wishlistItems: state.wishlistData,
    currency: state.currencyData
  }
}

const mapDispatchToProps = dispatch => {
  return {
    addToCart: (item, addToast, quantityCount) => {
      dispatch(addToCart(item, addToast, quantityCount))
    },
    addToWishlist: (item, addToast, quantityCount) => {
      dispatch(addToWishlist(item, addToast, quantityCount))
    },
    deleteFromWishlist: (item, addToast, quantityCount) => {
      dispatch(deleteFromWishlist(item, addToast, quantityCount))
    },
    deleteAllFromWishlist: addToast => {
      dispatch(deleteAllFromWishlist(addToast))
    }
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(WishlistPage)
