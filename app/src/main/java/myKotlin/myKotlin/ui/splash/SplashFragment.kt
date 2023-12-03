package myKotlin.myKotlin.ui.splash

import android.animation.ObjectAnimator
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.navigation.fragment.findNavController
import myKotlin.myKotlin.R
import myKotlin.myKotlin.databinding.FragmentMenuPagerBinding
import myKotlin.myKotlin.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    private lateinit var viewModel: SplashViewModel
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[SplashViewModel::class.java]
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val text = binding.splashText
        val alphaAnimator = ObjectAnimator.ofFloat(text, View.ALPHA, 1f, 0f)
        alphaAnimator.duration = 1000
        alphaAnimator.repeatCount = ObjectAnimator.INFINITE
        alphaAnimator.repeatMode = ObjectAnimator.REVERSE
        alphaAnimator.interpolator = AccelerateDecelerateInterpolator()
        alphaAnimator.start()

        Handler().postDelayed({
            findNavController().popBackStack()
            findNavController().navigate(R.id.menuPagerFragment)
        }, 2000)
        return root
    }
}