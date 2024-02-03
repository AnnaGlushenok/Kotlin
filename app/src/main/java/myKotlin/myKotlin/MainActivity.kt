package myKotlin.myKotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import myKotlin.myKotlin.databinding.ActivityMainBinding
import myKotlin.myKotlin.ui.dashboard.DashboardViewModelFactory
import myKotlin.myKotlin.ui.details.DetailViewModelFactory
import myKotlin.myKotlin.ui.mainTab.MainTabViewModelFactory
import myKotlin.myKotlin.ui.menuPager.MenuPagerViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var mainTabFactory: MainTabViewModelFactory

    @Inject
    lateinit var menuPagerFactory: MenuPagerViewModelFactory

    @Inject
    lateinit var detailFactory: DetailViewModelFactory

    @Inject
    lateinit var dashboardFactory: DashboardViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        (application as MainApp).appComponent.inject(this)
        setContentView(binding.root)
    }
}
