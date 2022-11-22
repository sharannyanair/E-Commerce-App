package com.app.e_commerce.shared.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.e_commerce.product_list.presentation.ProductCardViewState
import com.app.e_commerce.shared.presentation.ProductListViewState.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor() : ViewModel() {

    val viewState = MutableLiveData<ProductListViewState>()
    fun loadProductList() {
        viewState.postValue(Loading)

        viewState.postValue(ProductListViewState.Content((1..3).map {
            ProductCardViewState(
                "PlayStation $it",
                "This is description",
                "$ 200"
            )
        }))
    }
}