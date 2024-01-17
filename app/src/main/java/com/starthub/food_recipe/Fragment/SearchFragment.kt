package com.starthub.food_recipe.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.starthub.food_recipe.adapter.MenuAdapter
import com.starthub.food_recipe.R
import com.starthub.food_recipe.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter

    private val originalMenuFoodName: List<String> = listOf(
        "Burger",
        "sandwich",
        "momo",
        "item",
        "sandwish",
        "momo",
        "Burger",
        "momo"
    )
    private val originalMenuItemPrice: List<String> = listOf("$5", "$6", "$9", "$10", "$10", "$8", "$8", "$8")

    private val originalMenuImage: List<Int> = listOf(
        R.drawable.mealone,
        R.drawable.mealtwo,
        R.drawable.mealone,
        R.drawable.mealthree,
        R.drawable.mealtwo,
        R.drawable.mealone,
        R.drawable.mealone,
        R.drawable.mealone
    )

    private  val filterMenuFoodName = mutableListOf<String>()
    private  val filterMenuItemPrice = mutableListOf<String>()
    private  val filterMenuImage = mutableListOf<Int>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        adapter = MenuAdapter(filterMenuFoodName,filterMenuItemPrice,filterMenuImage)
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        setSearchView()
        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        filterMenuFoodName.clear()
        filterMenuItemPrice.clear()
        filterMenuImage.clear()

        filterMenuFoodName.addAll(originalMenuFoodName)
        filterMenuItemPrice.addAll(originalMenuItemPrice)
        filterMenuImage.addAll(originalMenuImage)

        adapter.notifyDataSetChanged()
    }

    private fun setSearchView() {

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true


            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }

        })
    }

    private fun filterMenuItems(query: String) {

        filterMenuFoodName.clear()
        filterMenuItemPrice.clear()
        filterMenuImage.clear()

        originalMenuFoodName.forEachIndexed { index, foodName ->
            if (foodName.contains(query,ignoreCase = true)){
                filterMenuFoodName.add(foodName)
                filterMenuItemPrice.add(originalMenuItemPrice[index])
                filterMenuImage.add(originalMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()

        Log.d("SearchFragment", "Filtered Items: $filterMenuFoodName")

    }

    companion object {
    }
}
