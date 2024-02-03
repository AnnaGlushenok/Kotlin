package myKotlin.myKotlin.ui.splash

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import myKotlin.myKotlin.R
import myKotlin.myKotlin.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val text = binding.splashImage
        val alphaAnimator = ObjectAnimator.ofFloat(text, View.ALPHA, 1f, 0f)
        alphaAnimator.duration = 1000
        alphaAnimator.repeatCount = ObjectAnimator.INFINITE
        alphaAnimator.repeatMode = ObjectAnimator.REVERSE
        alphaAnimator.interpolator = AccelerateDecelerateInterpolator()
        alphaAnimator.start()
        val animation: Animation =
            AnimationUtils.loadAnimation(this.context, R.anim.rotate_animation)
        text.startAnimation(animation)

//        viewModel.photoLiveData.observe(viewLifecycleOwner) {
//            findNavController().navigate(
//                SplashFragmentDirections
//                    .actionSplashFragmentToMenuPagerFragment(it)
//            )
//        }

        Handler().postDelayed({
            findNavController().popBackStack()
            findNavController().navigate(R.id.menuPagerFragment)
//            findNavController().navigate(
//                SplashFragmentDirections
//                    .actionSplashFragmentToMenuPagerFragment(l)
//            )
        }, 1000)
        return root
    }
}