package com.example.myapplication.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityNotifiactionBinding
import com.example.myapplication.ui.fragment.HomeFragment
import com.example.myapplication.ui.fragment.NotifiactionFragment
import com.example.myapplication.ui.fragment.PersonFragment
import com.example.myapplication.ui.fragment.SearchFragment
import com.example.myapplication.ui.fragment.SecondFragment

class NotifiactionActivity : AppCompatActivity() {
    lateinit var binding: ActivityNotifiactionBinding
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameBottom,fragment)
        fragmentTransaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNotifiactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())

        //bottomView -> bottomnavigationview ko id
        binding.bottomView.setOnItemSelectedListener {
            //return gareko data it vanney variable ma aayera basxa
            when(it.itemId){     // java ma switch is kotlin ma when
                R.id.navHome -> replaceFragment(HomeFragment())
                    R.id.navSearch -> replaceFragment(SearchFragment())
                        R.id.navNotification -> replaceFragment(NotifiactionFragment())
                            R.id.navPerson -> replaceFragment(PersonFragment())
                                else -> {}
            }
            true

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}