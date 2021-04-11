import PropTypes from "prop-types"
import React from 'react';
import { BreadcrumbsItem } from "react-breadcrumbs-dynamic"
import { Breadcrumb } from "__common__/index"
import LayoutOne from "layouts/LayoutOne";
import TeamMemberOne from "wrappers/team-member/TeamMemberOne";

const SuccessPage = ({location}) => {
    const { pathname } = location;

    return (<>
    <BreadcrumbsItem to={process.env.PUBLIC_URL + "/"}>Home</BreadcrumbsItem>
    <BreadcrumbsItem to={process.env.PUBLIC_URL + pathname}>PaySuccess</BreadcrumbsItem>
    <LayoutOne headerTop="visible">
    <Breadcrumb />
    {/* team member */}
    <TeamMemberOne spaceTopClass="pt-95" spaceBottomClass="pb-70" />

    </LayoutOne>
    </>

    )
}
SuccessPage.propTypes = {
    location: PropTypes.object
  }
export default SuccessPage