package com.starthub.food_recipe.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.starthub.food_recipe.R
import com.starthub.food_recipe.adapter.CartAdapter
import com.starthub.food_recipe.databinding.FragmentCartBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CartFragment : Fragment() {
    private lateinit var binding : FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater,container,false )

        val  cartFoodName = listOf("Burger","sandwich","momo","item","sandwish","momo","Burger","momo")
        val  cartItemPrice = listOf("$5","$6","$9","$10","$10","$8","$8","$8",)
        val cartImage = listOf(
            R.drawable.mealone,
            R.drawable.mealtwo,
            R.drawable.mealone,
            R.drawable.mealthree,
            R.drawable.mealtwo,
            R.drawable.mealone,
            R.drawable.mealone,
            R.drawable.mealone,
        )
        val adapter = CartAdapter(ArrayList(cartFoodName),ArrayList(cartItemPrice),ArrayList(cartImage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter =adapter
        return binding.root


    }

    companion object {

    }
}