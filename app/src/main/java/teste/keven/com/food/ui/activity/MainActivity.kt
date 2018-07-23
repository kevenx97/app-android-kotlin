package teste.keven.com.food.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import teste.keven.com.food.R
import java.util.*

class MainActivity : AppCompatActivity() {

    private val foodList = arrayListOf("Subway", "Hot Dog", "Burger King")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selectedFoodText.text = foodList[2]

        addFoodButton.setOnClickListener {
            if (addFoodText.text.isNotEmpty()) {
                foodList.add(addFoodText.text.toString())
                selectedFoodText.text = addFoodText.text
                addFoodText.text.clear()
            }
        }

        decideButton.setOnClickListener {
            val randomFood = Random().nextInt(foodList.count())

            with(selectedFoodText) {
                if (text !== foodList[randomFood]) {
                    text = foodList[randomFood]
                } else {
                    it.callOnClick()
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val about: Intent = Intent(this, AboutActivity::class.java)
        val delicious: Intent = Intent(this, DeliciousActivity::class.java)

        when (item?.itemId) {
            R.id.aboutItem -> startActivity(about)
            R.id.deliciousItem -> startActivity(delicious)
            R.id.exitItem -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
