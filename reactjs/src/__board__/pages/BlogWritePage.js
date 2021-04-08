import PropTypes from "prop-types"
import React from "react"
import MetaTags from "react-meta-tags"
import { BreadcrumbsItem } from "react-breadcrumbs-dynamic"
import { Layout, Breadcrumb } from "__common__/index"
import { BlogPostWrite } from "__board__/index"

const BlogWritePage = ({ location }) => {
  const { pathname } = location

  return (<>
    <MetaTags>
      <title>Flone | Blog Post</title>
    </MetaTags>

    <BreadcrumbsItem to={process.env.PUBLIC_URL + "/"}>Home</BreadcrumbsItem>
    <BreadcrumbsItem to={process.env.PUBLIC_URL + pathname}>Blog Post</BreadcrumbsItem>
    
    <Layout headerTop="visible">
      {/* breadcrumb */}
      <Breadcrumb />
      <div className="blog-area pt-100 pb-100">
        <div className="container">
          <div className="row flex-row-reverse">
            <div className="col-lg-9">
              <div className="blog-details-wrapper ml-20">
                {/* blog post */}
                <BlogPostWrite />
              </div>
            </div>
          </div>
        </div>
      </div>
    </Layout>
  </>)
}

BlogWritePage.propTypes = {
  location: PropTypes.object
}

export default BlogWritePage