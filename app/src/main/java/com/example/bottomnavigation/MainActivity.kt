package com.example.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottomnavigation.fragment.ChatFragment
import com.example.bottomnavigation.fragment.HomeFragment
import com.example.bottomnavigation.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigation : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigation = findViewById(R.id.bottomNavigation)

        setFragment(HomeFragment())

        bottomNavigation.setOnItemSelectedListener {
            val selectedFragment = when(it.itemId) {
                R.id.chat ->{
                    ChatFragment()
                }
                R.id.profile ->{
                    ProfileFragment()
                }
                else ->{
                    HomeFragment()
                }
            }
            setFragment(selectedFragment)
            true
        }


    }
    private fun setFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}