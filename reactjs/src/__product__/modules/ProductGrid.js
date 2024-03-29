import PropTypes from "prop-types"
import React, { useState, useEffect } from "react"
import { connect } from "react-redux"
import { getProducts } from "helpers/product"
import { addToCart } from "redux/actions/cartActions"
import { addToWishlist } from "redux/actions/wishlistActions"
import { ProductGridSingle } from "__product__/index"
import axios from "axios"

const ProductGrid = ({
  currency,
  addToCart,
  addToWishlist,
  cartItems,
  wishlistItems,
  sliderClassName,
  spaceBottomClass
}) => {
  const [products, setProducts] = useState([])
  
  useEffect(() => {
    axios.get('http://localhost:8080/products/category/' + localStorage.getItem(`ctgName`), )
    .then((res) => {
      console.log(`제품 카테고리 조회 성공`)
      setProducts(res.data)
    })
    .catch((err) => {
      console.log(`제품 카테고리 조회 실패` + err)
      throw err
    })
  }, [])

  return (<>
    {products.map(product => {
      return (
        <ProductGridSingle
          sliderClassName={sliderClassName}
          spaceBottomClass={spaceBottomClass}
          product={product}
          currency={currency}
          addToCart={addToCart}
          addToWishlist={addToWishlist}
          cartItem={
            cartItems.filter(cartItem => cartItem.prdNo === product.prdNo)[0]
          }
          wishlistItem={
            wishlistItems.filter(
              wishlistItem => wishlistItem.prdNo === product.prdNo
            )[0]
          }
          key={product.prdNo}
        />
      )}
    )}
  </>)
}

ProductGrid.propTypes = {
  addToCart: PropTypes.func,
  addToWishlist: PropTypes.func,
  cartItems: PropTypes.array,
  currency: PropTypes.object,
  products: PropTypes.array,
  sliderClassName: PropTypes.string,
  spaceBottomClass: PropTypes.string,
  wishlistItems: PropTypes.array
}

const mapStateToProps = (state, ownProps) => {
  return {
    products: getProducts(
      ownProps.category,
      ownProps.type,
      ownProps.limit
    ),
    currency: state.currencyData,
    cartItems: state.cartData,
    wishlistItems: state.wishlistData,
  }
}

const mapDispatchToProps = dispatch => {
  return {
    addToCart: (
      item,
      addToast,
      quantityCount,
      selectedProductColor,
      selectedProductSize
    ) => {
      dispatch(
        addToCart(
          item,
          addToast,
          quantityCount,
          selectedProductColor,
          selectedProductSize
        )
      )
    },
    addToWishlist: (item, addToast) => {
      dispatch(addToWishlist(item, addToast))
    },
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(ProductGrid)