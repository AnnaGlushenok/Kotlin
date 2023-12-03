package myKotlin.myKotlin

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import myKotlin.myKotlin.ui.dashboard.DashboardFragment
import myKotlin.myKotlin.ui.mainTab.MainTabFragment

class FragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MainTabFragment()
            1 -> DashboardFragment()
            else -> MainTabFragment()
        }
    }
}