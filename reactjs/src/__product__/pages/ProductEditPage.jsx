import PropTypes from "prop-types"
import React, { Fragment } from "react"
import MetaTags from "react-meta-tags"
import { BreadcrumbsItem } from "react-breadcrumbs-dynamic"
import { connect } from "react-redux"
import Layout from '../../__common__/modules/Layout'
import Breadcrumb from '../modules/Breadcrumb'
import ProductEditComp from '../modules/ProductEditComp'

const ProductEditPage = ({ location }) => {
  const { pathname } = location

  return (
    <Fragment>
      <MetaTags>
          <title>ZER0 SHOP | Product Edit Page</title>
      </MetaTags>

      <BreadcrumbsItem to={process.env.PUBLIC_URL + "/"}>Home</BreadcrumbsItem>
      <BreadcrumbsItem to={process.env.PUBLIC_URL + pathname}>Edit Product</BreadcrumbsItem>
      
      <Layout headerTop="visible">
        {/* breadcrumb */}
        <Breadcrumb />
        
        {/* Edit Product Component */}
        <ProductEditComp />
        
      </Layout>

    </Fragment>)
}

ProductEditPage.propTypes = {
  location: PropTypes.object,
  product: PropTypes.object
}

export default ProductEditPage