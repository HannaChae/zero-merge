import PropTypes from "prop-types"
import React from "react"

const SectionTitle = ({ titleText, spaceBottomClass }) => {
  return (
    <div
      className={`section-title-3 ${spaceBottomClass ? spaceBottomClass : ""}`}
    >
      <h4>{titleText}</h4>
    </div>
  )
}

SectionTitle.propTypes = {
  spaceBottomClass: PropTypes.string,
  titleText: PropTypes.string
}

export default SectionTitle
