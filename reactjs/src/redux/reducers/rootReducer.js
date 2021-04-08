import currencyReducer from "redux/reducers/currencyReducer"
import productReducer from "redux/reducers/productReducer"
import cartReducer from "redux/reducers/cartReducer"
import wishlistReducer from "redux/reducers/wishlistReducer"
import { combineReducers } from "redux"
import { createMultilanguageReducer } from "redux-multilanguage"

const rootReducer = combineReducers({
  multilanguage: createMultilanguageReducer({ currentLanguageCode: "en" }),
  currencyData: currencyReducer,
  productData: productReducer,
  cartData: cartReducer,
  wishlistData: wishlistReducer,
})

export default rootReducer
