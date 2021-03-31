import PropTypes from "prop-types"
import React from "react"
import { getIndividualCategories, getIndividualTags } from "../../__common__/modules/helpers/product"
import ShopSearch from "./ShopSearch"
import ShopCategories from "./ShopCategories"
import ShopTag from "./ShopTag"

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
