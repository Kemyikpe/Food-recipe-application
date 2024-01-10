package com.starthub.food_recipe.Fragment

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.starthub.food_recipe.R
import com.starthub.food_recipe.adapter.PopularAdapter
import com.starthub.food_recipe.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding. viewAllMenu . setOnClickListener {
            val bottomSheetDialog = MenuBottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"Test")
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.flag1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.flag1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.flag1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.flag1, ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)
        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imageList[position]
                val itemMessage = "selected Image  $position"
                Toast.makeText(requireContext(), itemMessage, Toast.LENGTH_SHORT).show()
            }
        })
        val foodName = listOf("Burger", "sandwish", "momo", "item", "Burger", "momo")
        val price = listOf("$5", "$7", "$8", "$10", "$15", "$20")
        val populerFoodImages = listOf(
            R.drawable.mealone,
            R.drawable.mealtwo,
            R.drawable.mealone,
            R.drawable.mealthree,
            R.drawable.mealthree,
            R.drawable.mealone,
        )
        val adapter = PopularAdapter(foodName, price, populerFoodImages)
        binding.popularRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.popularRecyclerView.adapter = adapter
        println("item count: ${adapter.toString()}")
    }


}