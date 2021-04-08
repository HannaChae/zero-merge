import PropTypes from "prop-types"
import React from "react"
import { Header, Footer } from "__common__/index"

const Layout = ({
  children,
  headerContainerClass,
  headerTop,
  headerPaddingClass,
  headerPositionClass
}) => {
  return (<>
    <Header
      layout={headerContainerClass}
      top={headerTop}
      headerPaddingClass={headerPaddingClass}
      headerPositionClass={headerPositionClass}
    />
    {children}
    <Footer
      backgroundColorClass="bg-gray"
      spaceTopClass="pt-100"
      spaceBottomClass="pb-70"
    />
  </>)
}

Layout.propTypes = {
  children: PropTypes.any,
  headerContainerClass: PropTypes.string,
  headerPaddingClass: PropTypes.string,
  headerPositionClass: PropTypes.string,
  headerTop: PropTypes.string
}

export default Layout