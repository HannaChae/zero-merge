import PropTypes from "prop-types"
import React from 'react';
import { BreadcrumbsItem } from "react-breadcrumbs-dynamic"
import { Breadcrumb } from "__common__/index"
import LayoutOne from "layouts/LayoutOne";
import TeamMemberOne from "wrappers/team-member/TeamMemberOne";
import {PaymentAPI} from "__payment__/index"

const PaymentPage = ({location}) => {
    const { pathname } = location;

    return (<>
    <BreadcrumbsItem to={process.env.PUBLIC_URL + "/"}>Home</BreadcrumbsItem>
    <BreadcrumbsItem to={process.env.PUBLIC_URL + pathname}>PaymentPage</BreadcrumbsItem>
    <LayoutOne headerTop="visible">
    <Breadcrumb />
    <PaymentAPI />
    {/* team member */}
    <TeamMemberOne spaceTopClass="pt-95" spaceBottomClass="pb-70" />

    </LayoutOne>
    </>

    )
}
PaymentPage.propTypes = {
    location: PropTypes.object
  }
export default PaymentPage