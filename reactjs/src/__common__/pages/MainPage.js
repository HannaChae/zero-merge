import React from "react"
import MetaTags from "react-meta-tags"
import { Layout, FeatureIcon, HeroSlider, CategorySlider } from "__common__/index"

const MainPage = () => {
  const logout = () => {
    alert(`로그아웃`)
    localStorage.removeItem("user")
    localStorage.removeItem("token")
  }

  return (<>
  {localStorage.getItem("token") === null ?
    <>
      <MetaTags>
        <title>ZER0 SHOP | Home</title>
      </MetaTags>
      
      <Layout
        headerContainerClass="container-fluid"
        headerPaddingClass="header-padding-2"
        headerTop="visible"
      >
        {/* hero slider */}
        <HeroSlider />
        {/* category */}
        <CategorySlider spaceTopClass="pt-100" spaceBottomClass="pb-95" />
        {/* feature icon */}
        <FeatureIcon spaceTopClass="pt-100" spaceBottomClass="pb-60" />
      </Layout>
    </>
  :
  <>
      <button onClick={logout}>로그인 후</button>
      
      <MetaTags>
        <title>ZER0 SHOP | Home</title>
      </MetaTags>

      <Layout
        headerContainerClass="container-fluid"
        headerPaddingClass="header-padding-2"
        headerTop="visible"
      >
        {/* hero slider */}
        <HeroSlider />
        {/* category */}
        <CategorySlider spaceTopClass="pt-100" spaceBottomClass="pb-95" />
        {/* feature icon */}
        <FeatureIcon spaceTopClass="pt-100" spaceBottomClass="pb-60" />
      </Layout>
      </>}
  </>)
}

export default MainPage