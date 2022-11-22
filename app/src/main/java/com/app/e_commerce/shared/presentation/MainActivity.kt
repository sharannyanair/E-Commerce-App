package com.app.e_commerce.shared.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.e_commerce.databinding.ProductListFragmentBinding
import com.app.e_commerce.product_list.presentation.ProductCardListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val adapter = ProductCardListAdapter()

    private lateinit var binding: ProductListFragmentBinding
    private val viewModel by viewModels<ProductListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ProductListFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewProductList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.viewProductList.adapter = adapter
        viewModel.viewState.observe(this) { viewState ->
            updateUI(viewState)
        }
        viewModel.loadProductList()

    }

    private fun updateUI(viewState: ProductListViewState) {
        when (viewState) {
            is ProductListViewState.Content -> {
                binding.errorView.isVisible = false
                binding.loadingView.isVisible = false
                adapter.setData(viewState.productList)
            }
        }
    }
}