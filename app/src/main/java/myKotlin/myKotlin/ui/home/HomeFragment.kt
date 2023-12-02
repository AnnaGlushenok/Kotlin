package myKotlin.myKotlin.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import myKotlin.myKotlin.Picture
import myKotlin.myKotlin.PictureAdapter
import myKotlin.myKotlin.R
import myKotlin.myKotlin.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val list = listOf(
            Picture(R.drawable.p1, "Пейзаж", "Красивый розовый пейзаж"),
            Picture(R.drawable.p2, "Ромашки", "Утренине ромашки в росе"),
            Picture(R.drawable.p3, "Горы", "Цветные горы на закате"),
            Picture(R.drawable.p4, "Розовые ромашки", "Полотно розовых ромашек"),
            Picture(R.drawable.p6, "Розы", "Декабрьские красные розы"),
            Picture(R.drawable.p7, "Рыба", "Просто рыба в океане"),
            Picture(R.drawable.p8, "Кораллы", "Коралловый риф"),
            Picture(R.drawable.p9, "Дайвер", "Дайвер в пещере")
        )

        binding.recyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerView.adapter = PictureAdapter(list,this)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}