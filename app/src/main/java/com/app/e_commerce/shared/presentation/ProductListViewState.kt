package com.app.e_commerce.shared.presentation

import com.app.e_commerce.product_list.presentation.ProductCardViewState


sealed class ProductListViewState{
    object Loading : ProductListViewState()
    data class Content(val productList : List<ProductCardViewState>) : ProductListViewState()
    object Error : ProductListViewState()
}
