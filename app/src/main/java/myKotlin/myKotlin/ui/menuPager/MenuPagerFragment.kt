package myKotlin.myKotlin.ui.menuPager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import myKotlin.myKotlin.FragmentAdapter
import myKotlin.myKotlin.MainActivity
import myKotlin.myKotlin.R
import myKotlin.myKotlin.databinding.FragmentMenuPagerBinding

class MenuPagerFragment : Fragment() {
    private lateinit var viewModel: MenuPagerViewModel

    private var _binding: FragmentMenuPagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(
            this,
            (activity as MainActivity).menuPagerFactory
        )[MenuPagerViewModel::class.java]

        _binding = FragmentMenuPagerBinding.inflate(inflater, container, false)

        val root: View = binding.root
        val tabLayout: TabLayout = binding.tabLayout
        val viewPager: ViewPager2 = binding.viewPager
        viewPager.adapter = FragmentAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.icon =
                    ContextCompat.getDrawable(requireContext(), R.drawable.home_selector)

                1 -> tab.icon =
                    ContextCompat.getDrawable(requireContext(), R.drawable.bookmark_selector)
            }
        }.attach()

        return root
    }

}