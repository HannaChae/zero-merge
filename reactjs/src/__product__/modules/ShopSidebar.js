import PropTypes from "prop-types"
import React from "react"
import { getIndividualCategories, getIndividualTags } from "helpers/product"
import { ShopCategories, ShopSearch, ShopTag } from "__product__/index"

const ShopSidebar = ({ products, getSortParams, sideSpaceClass }) => {
  const uniqueCategories = getIndividualCategories(products)
  const uniqueTags = getIndividualTags(products)

  return (
    <div className={`sidebar-style ${sideSpaceClass ? sideSpaceClass : ""}`}>
      {/* shop search */}
      <ShopSearch />

      {/* filter by categories */}
      <ShopCategories
        categories={uniqueCategories}
        getSortParams={getSortParams}
      />

      {/* filter by tag */}
      <ShopTag tags={uniqueTags} getSortParams={getSortParams} />
    </div>
  )
}

ShopSidebar.propTypes = {
  getSortParams: PropTypes.func,
  products: PropTypes.array,
  sideSpaceClass: PropTypes.string
}

export default ShopSidebar