import React, { Suspense, lazy, useEffect } from "react"
import ScrollToTop from "helpers/scroll-top"
import { BrowserRouter as Router, Switch, Route } from "react-router-dom"
import { ToastProvider } from "react-toast-notifications"
import { multilanguage, loadLanguages } from "redux-multilanguage"
import { connect } from "react-redux"
import { BreadcrumbsProvider } from "react-breadcrumbs-dynamic"
import { MainPage, NotFoundPage } from "__common__/index"
import { LoginRegisterPage, AdminPage, UserListPage } from "__user__/index"
import { ProductAddPage, ProductListPage, CategoryListPage, ProductDetailPage, ProductEditPage, CartPage, WishlistPage } from "__product__/index"
import { BlogWritePage, BlogListPage, BlogDetailPage, BlogUpdatePage } from "__board__/index"
import { MyAccountPage, CheckoutPage, SuccessPage, PaymentPage} from "__payment__/index"

const About = lazy(() => import("pages/other/About"))
const Contact = lazy(() => import("pages/other/Contact"))

const App = (props) => {
  useEffect(() => {
    props.dispatch(
      loadLanguages({
        languages: {
          en: require("__common__/modules/english.json"),
        }
      })
    )
  })

  return (
    <ToastProvider placement="bottom-left">
      <BreadcrumbsProvider>
        <Router>
          <ScrollToTop>
            <Suspense
              fallback={
                <div className="flone-preloader-wrapper">
                  <div className="flone-preloader">
                    <span></span>
                    <span></span>
                  </div>
                </div>
              }
            >
              <Switch>
                <Route
                  exact
                  path={process.env.PUBLIC_URL + "/"}
                  component={MainPage}
                />

                {/* Homepages */}
                <Route
                  path={process.env.PUBLIC_URL + "/main"}
                  component={MainPage}
                />

                {/* Shop pages */}
                <Route
                  path={process.env.PUBLIC_URL + "/product-all"}
                  component={ProductListPage}
                />
                <Route
                  path={process.env.PUBLIC_URL + "/category/:id"}
                  render={(routeProps) => (
                    <CategoryListPage {...routeProps} key={routeProps.match.params.id} />
                  )}
                />
                <Route
                  path={process.env.PUBLIC_URL + "/category/:id"}
                  component={CategoryListPage}
                />

                {/* Shop product pages */}
                <Route
                  path={process.env.PUBLIC_URL + "/product-detail/:id"}
                  render={(routeProps) => (
                    <ProductDetailPage {...routeProps} key={routeProps.match.params.id} />
                  )}
                />
                <Route
                  path={process.env.PUBLIC_URL + "/product-detail/:id"}
                  component={ProductDetailPage}
                />
                <Route
                  path={process.env.PUBLIC_URL + "/product-add"}
                  component={ProductAddPage}
                />
                <Route
                  path={process.env.PUBLIC_URL + "/product-edit/:id"}
                  render={(routeProps) => (
                    <ProductEditPage {...routeProps} key={routeProps.match.params.id} />
                  )}
                />
                <Route
                  path={process.env.PUBLIC_URL + "/product-edit/:id"}
                  component={ProductEditPage}
                />

                {/* Blog pages */}
                <Route
                  path={process.env.PUBLIC_URL + "/blog-detail/:id"}
                  render={(routeProps) => (
                    <BlogDetailPage {...routeProps} key={routeProps.match.params.id} />
                  )}
                />
                <Route
                  path={process.env.PUBLIC_URL + "/blog-detail/:id"}
                  component={BlogDetailPage}
                />
                <Route
                  path={process.env.PUBLIC_URL + "/blog-all"}
                  component={BlogListPage}
                />
                <Route
                  path={process.env.PUBLIC_URL + "/blog-update/:id"}
                  render={(routeProps) => (
                    <BlogUpdatePage {...routeProps} key={routeProps.match.params.id} />
                  )}
                />
                <Route
                  path={process.env.PUBLIC_URL + "/blog-update/:id"}
                  component={BlogUpdatePage}
                />
                <Route
                  path={process.env.PUBLIC_URL + "/blog-write"}
                  component={BlogWritePage}
                />

                {/* Other pages */}
                <Route
                  path={process.env.PUBLIC_URL + "/cart"}
                  component={CartPage}
                />
                <Route
                  path={process.env.PUBLIC_URL + "/wishlist"}
                  component={WishlistPage}
                />
                <Route
                  path={process.env.PUBLIC_URL + "/checkout"}
                  component={CheckoutPage}
                />
                <Route
                  path={process.env.PUBLIC_URL + "/pay-success"}
                  component={SuccessPage}
                />
                <Route
                  path={process.env.PUBLIC_URL + "/pay-progress"}
                  component={PaymentPage}
                />
                <Route
                  path={process.env.PUBLIC_URL + "/contact"}
                  component={Contact}
                />
                <Route
                  path={process.env.PUBLIC_URL + "/admin"}
                  component={AdminPage}
                />
                <Route
                  path={process.env.PUBLIC_URL + "/user-list"}
                  component={UserListPage}
                />
                <Route
                  path={process.env.PUBLIC_URL + "/login-register"}
                  component={LoginRegisterPage}
                />
                <Route
                  path={process.env.PUBLIC_URL + "/my-account"}
                  component={MyAccountPage}
                />
                <Route
                  path={process.env.PUBLIC_URL + "/about"}
                  component={About}
                />
                <Route
                  path={process.env.PUBLIC_URL + "/not-found"}
                  component={NotFoundPage}
                />

                <Route exact component={NotFoundPage} />
              </Switch>
            </Suspense>
          </ScrollToTop>
        </Router>
      </BreadcrumbsProvider>
    </ToastProvider>
  )
}

export default connect()(multilanguage(App));