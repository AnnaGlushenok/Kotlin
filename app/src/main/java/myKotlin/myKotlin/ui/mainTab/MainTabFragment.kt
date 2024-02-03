package myKotlin.myKotlin.ui.mainTab

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import myKotlin.myKotlin.LastRequest
import myKotlin.myKotlin.MainActivity
import myKotlin.myKotlin.PictureAdapter
import myKotlin.myKotlin.R
import myKotlin.myKotlin.databinding.FragmentMainTabBinding

class MainTabFragment : Fragment() {
    private lateinit var viewModel: MainTabViewModel
    private var _binding: FragmentMainTabBinding? = null
    private val binding
        get() = _binding!!
    private var lastRequest: LastRequest = LastRequest.POPULAR
    private lateinit var lastRequestStr: String
    private var prevButton: Button? = null
    private val buttons = mutableListOf<Button>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(
            this,
            (activity as MainActivity).mainTabFactory
        )[MainTabViewModel::class.java]

        _binding = FragmentMainTabBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val adapter = PictureAdapter(findNavController())
        viewModel.photoLiveData.observe(viewLifecycleOwner) {
            adapter.differ.submitList(it.photos)
        }
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val pastVisibleItems = layoutManager
                    .findFirstVisibleItemPositions(null)
                    .firstOrNull() ?: 0

                if (visibleItemCount + pastVisibleItems >= totalItemCount)
                    viewModel.getPhotos()

            }
        })
        binding.include.clearButton.setOnClickListener {
            binding.include.searchText.text.clear()
        }
        binding.include.searchText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.include.clearButton.visibility = View.VISIBLE
                lastRequest = LastRequest.SEARCH
                if (s?.isEmpty() == true) {
                    binding.include.clearButton.visibility = View.INVISIBLE
                    viewModel.getPhotos()
                    setInactive(prevButton, view!!)
                }
                var job: Job? = null
                job?.cancel()
                job = MainScope().launch {
                    delay(1000)
                    s?.let {
                        lastRequestStr = s.toString()
                        if (lastRequestStr.isNotEmpty())
                            viewModel.getPhotosByName(lastRequestStr)
                        val button = buttons.find { b -> b.text == lastRequestStr }
                        if (button != null) {
                            setActive(button, view!!)
                            prevButton = button
                        } else {
                            setInactive(prevButton, view!!)
                        }
                    }
                }
            }
        })
        viewModel.collectionsLiveData.observe(viewLifecycleOwner) {
            it.collections.forEach { el -> createButton(requireView(), binding.featured, el.title) }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setActive(button: Button, view: View) {
        button.setBackgroundResource(R.drawable.feature_btn_active)
        button.setTextColor(
            ContextCompat.getColor(
                view.context,
                R.color.light_gray
            )
        )
    }

    private fun setInactive(button: Button?, view: View) {
        button?.setBackgroundResource(R.drawable.feature_btn_inactive)
        button?.setTextColor(
            ContextCompat.getColor(
                view.context,
                R.color.gray
            )
        )
    }

    private fun createButton(view: View, container: LinearLayout, name: String) {
        val button = Button(view.context)
        button.id = View.generateViewId()
        button.text = name
        val layoutParams =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        layoutParams.setMargins(0, 0, 20, 0)
        button.layoutParams = layoutParams
        button.setBackgroundResource(R.drawable.feature_btn_inactive)
        button.isAllCaps = false
        button.setOnClickListener {
            lastRequest = LastRequest.FEATURED_BUTTON
            setActive(button, view)
            lastRequestStr = button.text.toString()
            if (prevButton != null)
                setInactive(prevButton, view)

            binding.include.searchText.setText(button.text.toString())
            prevButton = button
        }
        container.addView(button)
        buttons.add(button)
    }
}
