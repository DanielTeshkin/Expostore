package com.expostore.ui.main

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.expostore.MainActivity
import com.expostore.R
import com.expostore.api.Retrofit
import com.expostore.api.ServerApi
import com.expostore.api.pojo.getcategory.Category
import com.expostore.api.pojo.getcategory.GetCategoryResponseData
import com.expostore.api.pojo.getcategoryadvertising.CategoryAdvertising
import com.expostore.api.pojo.signin.SignInResponseData
import com.expostore.databinding.MainFragmentBinding
import com.expostore.utils.CategoryRecyclerViewAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var navController: NavController
    private lateinit var mAdapter: CategoryRecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.mainVM = mainViewModel


        return binding.root
    }


    override fun onStart() {
        super.onStart()

        (context as MainActivity).navView.visibility = View.VISIBLE

        val token = (context as MainActivity).sharedPreferences.getString("token", "")

        if (token.isNullOrEmpty()){
            navController = Navigation.findNavController(binding.root)
            navController.navigate(R.id.action_mainFragment_to_openFragment)
        }

        val serverApi = Retrofit.getClient(Retrofit.BASE_URL).create(ServerApi::class.java)

        serverApi.getCategories("Bearer $token").enqueue(object : Callback<ArrayList<Category>> {
            override fun onResponse(call: Call<ArrayList<Category>>, response: Response<ArrayList<Category>>) {
                if (response.isSuccessful) {
                    if(response.body() != null){
                        mAdapter = CategoryRecyclerViewAdapter(response.body(), requireContext())
                        binding.rvCategories.apply {
                            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                            adapter = mAdapter
                        }
                        mAdapter.onClick = onClickRecyclerItems()
                        mAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<Category>>, t: Throwable) {}
        })

        serverApi.getCategoryAdvertising("Bearer $token").enqueue(object : Callback<ArrayList<CategoryAdvertising>> {
            override fun onResponse(call: Call<ArrayList<CategoryAdvertising>>, response: Response<ArrayList<CategoryAdvertising>>) {
                if (response.isSuccessful) {
                    if(response.body() != null){
                        val firstItem = response.body()!![0]
                        Picasso.get().load(firstItem.image).into(binding.ivAdvertising)
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<CategoryAdvertising>>, t: Throwable) {
            }
        })
    }

    private fun onClickRecyclerItems() : CategoryRecyclerViewAdapter.OnClickListener{
        return object : CategoryRecyclerViewAdapter.OnClickListener {

            override fun onDetailCategoryButton(category: Category) {
                val bundle = Bundle()
                bundle.putSerializable("category",category)
                navController = Navigation.findNavController(binding.root)
                navController.navigate(R.id.action_mainFragment_to_detailCategoryFragment, bundle)

            }
        }
    }
}