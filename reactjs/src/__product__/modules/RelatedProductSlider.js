import PropTypes from "prop-types"
import React from "react"
import Swiper from "react-id-swiper"
import { SectionTitleTwo } from "__common__/index"
import { ProductGrid } from "__product__/index"

const RelatedProductSlider = ({ spaceBottomClass, category }) => {
  const settings = {
    loop: false,
    slidesPerView: 4,
    grabCursor: true,
    breakpoints: {
      1024: {
        slidesPerView: 4
      },
      768: {
        slidesPerView: 3
      },
      640: {
        slidesPerView: 2
      },
      320: {
        slidesPerView: 1
      }
    }
  }

  return (
    <div
      className={`related-product-area ${
        spaceBottomClass ? spaceBottomClass : ""
      }`}
    >
      <div className="container">
        <SectionTitleTwo
          titleText="Related Products"
          positionClass="text-center"
          spaceClass="mb-50"
        />
        <div className="row">
          <Swiper {...settings}>
            <ProductGrid
              category={category}
              limit={6}
              sliderClassName="swiper-slide"
            />
          </Swiper>
        </div>
      </div>
    </div>
  )
}

RelatedProductSlider.propTypes = {
  category: PropTypes.string,
  spaceBottomClass: PropTypes.string
}

export default RelatedProductSlider