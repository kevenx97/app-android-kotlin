package teste.keven.com.food.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_delicious.*
import teste.keven.com.food.R
import teste.keven.com.food.ui.fragment.DeliciousPageAdapter

class DeliciousActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_delicious)
        setSupportActionBar(toolbar)

        val fragmentAdapter = DeliciousPageAdapter(supportFragmentManager)
        viewpager.adapter = fragmentAdapter
        tabs.setupWithViewPager(viewpager)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }
}



