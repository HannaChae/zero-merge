import PropTypes from "prop-types"
import React, { Fragment } from "react"
import MetaTags from "react-meta-tags"
import { BreadcrumbsItem } from "react-breadcrumbs-dynamic"
import { connect } from "react-redux"
import ProductAddComp from '../modules/ProductAddComp'
import Layout from "../../__common__/modules/Layout"
import Breadcrumb from "../modules/Breadcrumb"

const ProductAddPage = ({ location }) => {
  const { pathname } = location

  return (
    <Fragment>
      <MetaTags>
        <title>ZER0 SHOP | Product Add Page</title>
      </MetaTags>

      <BreadcrumbsItem to={process.env.PUBLIC_URL + "/"}>Home</BreadcrumbsItem>
      <BreadcrumbsItem to={process.env.PUBLIC_URL + pathname}>Add Product</BreadcrumbsItem>
      <Layout headerTop="visible">
        {/* breadcrumb */}
        <Breadcrumb />

        {/* Add product component */}
        <ProductAddComp />
        
      </Layout>
    </Fragment>
  )
}

ProductAddPage.propTypes = {
  location: PropTypes.object,
  product: PropTypes.object
}

const mapStateToProps = (state, ownProps) => {
  const itemId = ownProps.match.params.id
  return {
    product: state.productData.products.filter(
      single => single.id === itemId
    )[0]
  }
}

export default connect(mapStateToProps)(ProductAddPage)