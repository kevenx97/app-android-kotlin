package teste.keven.com.food.ui.fragment

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class DeliciousPageAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    private val fragments = listOf(
        "Caseiras" to CaseirasFragment(),
        "Industrializados" to IndustrializadosFragment()
    )

    override fun getPageTitle(position: Int): CharSequence? {
        val (titulo) = fragments[position]
        return titulo
    }

    override fun getItem(position: Int): Fragment {
        val (_, fragment) = fragments[position]
        return fragment
    }

    override fun getCount(): Int {
        return fragments.size
    }
}
