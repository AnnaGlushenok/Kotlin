package myKotlin.myKotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import myKotlin.myKotlin.databinding.CardBinding
import myKotlin.myKotlin.ui.home.HomeFragmentDirections

class PictureAdapter(private val pictures: List<Picture>, val fragment: Fragment) :
    RecyclerView.Adapter<PictureAdapter.ViewHolder>() {

    class ViewHolder(val binding: CardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(CardBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = pictures.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            title.text = pictures[position].title
            text.text = pictures[position].text
            imageView.setImageResource(pictures[position].image)
            pictureCard.setOnClickListener {
                val direction = HomeFragmentDirections.actionNavigationHomeToDetailFragment(
                    Picture(
                        pictures[position].image,
                        pictures[position].title,
                        pictures[position].text
                    )
                )
                fragment.findNavController().navigate(direction)
            }
        }
    }
}