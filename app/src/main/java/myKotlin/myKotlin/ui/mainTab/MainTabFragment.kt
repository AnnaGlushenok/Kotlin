package myKotlin.myKotlin.ui.mainTab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import myKotlin.myKotlin.Picture
import myKotlin.myKotlin.PictureAdapter
import myKotlin.myKotlin.R
import myKotlin.myKotlin.databinding.FragmentMainTabBinding

class MainTabFragment : Fragment() {
    private lateinit var viewModel: MainTabViewModel
    private val pictures = listOf(
        Picture(R.drawable.p1, "Пейзаж", "Красивый розовый пейзаж"),
        Picture(R.drawable.p2, "Ромашки", "Утренине ромашки в росе"),
        Picture(R.drawable.p3, "Горы", "Цветные горы на закате"),
        Picture(R.drawable.p4, "Розовые ромашки", "Полотно розовых ромашек"),
        Picture(R.drawable.p6, "Розы", "Декабрьские красные розы"),
        Picture(R.drawable.p7, "Рыба", "Просто рыба в океане"),
        Picture(R.drawable.p8, "Кораллы", "Коралловый риф"),
        Picture(R.drawable.p9, "Дайвер", "Дайвер в пещере")
    )
    private var _binding: FragmentMainTabBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[MainTabViewModel::class.java]
        _binding = FragmentMainTabBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.recyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerView.adapter = PictureAdapter(pictures, findNavController())
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}