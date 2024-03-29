package myKotlin.myKotlin.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import myKotlin.myKotlin.MainActivity
import myKotlin.myKotlin.R
import myKotlin.myKotlin.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(
            this,
            (activity as MainActivity).detailFactory
        )[DetailViewModel::class.java]
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val root = binding.root
        binding.titleDetail.text = args.photo.alt
        binding.bookmarkBtn.setOnClickListener {
            viewModel.add(args.photo)
        }
        Glide.with(this)
            .load(args.photo.src.original)
            .placeholder(R.drawable.image_placeholder_icon)
            .into(binding.imageView2)
        return root
    }
}