package com.app.e_commerce.shared.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.e_commerce.product_list.presentation.ProductCardViewState
import com.app.e_commerce.shared.presentation.ProductListViewState.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(val repository: ProductRepository) : ViewModel() {

    val viewState = MutableLiveData<ProductListViewState>()
    fun loadProductList() {
        viewState.postValue(Loading)
        viewModelScope.launch {
            val productList = repository.getProductList()
            viewState.postValue(ProductListViewState.Content(productList))
        }

    }
}