package com.app.e_commerce.shared.presentation

import com.app.e_commerce.product_list.presentation.ProductCardViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductRepository @Inject constructor(){

    suspend fun getProductList(): List<ProductCardViewState> {
           return withContext(Dispatchers.IO) {
               delay(2000)
               (1..3).map {
                   ProductCardViewState(
                       "PlayStation $it",
                       "This is description",
                       "$ 200"
                   )
        }
    }
}
}