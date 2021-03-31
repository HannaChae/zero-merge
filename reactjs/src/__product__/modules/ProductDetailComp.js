import React from 'react'
import Layout from '../../__common__/modules/Layout'
import Breadcrumb from '../modules/Breadcrumb'
import RelatedProductSlider from "./RelatedProductSlider"
import ProductDescriptionTab from "./ProductDescriptionTab"
import ProductImageDescriptionSticky from "./ProductImageDescriptionSticky"

const ProductDetailComp = ({ product }) => {
    return (<>
    <Layout headerTop="visible">

        {/* breadcrumb */}
        <Breadcrumb />

        {/* product description with image */}
        <ProductImageDescriptionSticky
            spaceTopClass="mt-100"
            spaceBottomClass="mb-100"
            product={product}
        />

        {/* product description tab */}
        <ProductDescriptionTab
            spaceBottomClass="pb-90"
        />

        {/* related product slider */}
        <RelatedProductSlider
            spaceBottomClass="pb-95"
            category={product.ctgName}
        />

    </Layout>
    </>)
}

export default ProductDetailComp