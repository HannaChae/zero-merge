import PropTypes from "prop-types"
import React from "react"
import MetaTags from "react-meta-tags"
import { BreadcrumbsItem } from "react-breadcrumbs-dynamic"
import { Layout, Breadcrumb } from "__common__/index"
import { BlogPagination, BlogPostList } from "__board__/index"

const BlogListPage = ({ location }) => {
  const { pathname } = location

  return (<>
    <MetaTags>
      <title>Flone | Blog</title>
    </MetaTags>

    <BreadcrumbsItem to={process.env.PUBLIC_URL + "/"}>Home</BreadcrumbsItem>
    <BreadcrumbsItem to={process.env.PUBLIC_URL + pathname}>Blog</BreadcrumbsItem>

    <Layout headerTop="visible">
      {/* breadcrumb */}
      <Breadcrumb />
      <div className="blog-area pt-100 pb-100 blog-no-sidebar">
        <div className="container">
          <div className="row">
            <div className="col-lg-12">
              <div className="mr-20">
                <div className="row">
                  {/* blog posts */}
                  <BlogPostList />
                </div>

                {/* blog pagination */}
                <BlogPagination />
              </div>
            </div>
          </div>
        </div>
      </div>
    </Layout>
  </>)
}

BlogListPage.propTypes = {
  location: PropTypes.object
}

export default BlogListPage