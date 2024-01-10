package com.starthub.food_recipe.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.starthub.food_recipe.R
import com.starthub.food_recipe.adapter.CartAdapter
import com.starthub.food_recipe.adapter.MenuAdapter
import com.starthub.food_recipe.databinding.FragmentMenuBottomSheetBinding

class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var  binding :FragmentMenuBottomSheetBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMenuBottomSheetBinding.inflate(inflater,container,false )
        binding . buttonBack.setOnClickListener {
            dismiss()
        }
        val  menuFoodName = listOf("Burger","sandwich","momo","item","sandwish","momo","Burger","momo")
        val  menuItemPrice = listOf("$5","$6","$9","$10","$10","$8","$8","$8",)
        val menuImage = listOf(
            R.drawable.mealone,
            R.drawable.mealtwo,
            R.drawable.mealone,
            R.drawable.mealthree,
            R.drawable.mealtwo,
            R.drawable.mealone,
            R.drawable.mealone,
            R.drawable.mealone,
        )
        val adapter = MenuAdapter(
            ArrayList(menuFoodName),
            ArrayList(menuItemPrice),
            ArrayList(menuImage)
        )
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter =adapter
        return binding.root
    }

    companion object {


    }
}