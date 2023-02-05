package com.example.aircondition.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.aircondition.R
import com.example.aircondition.databinding.ActivityMainBinding
import com.example.aircondition.viewmodel.AirViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val airViewModel: AirViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        findNavController(R.id.fNavHost).setGraph(R.navigation.nav_air_pollution)
        binding.apply {
            searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    airViewModel.updateSearchText(newText)
                    return false
                }
            })
            searchBar.setOnCloseListener {
                findNavController(R.id.fNavHost).navigateUp()
                false
            }
            searchBar.setOnSearchClickListener {
                findNavController(R.id.fNavHost).navigate(R.id.fSearchList)
            }
        }
    }
}