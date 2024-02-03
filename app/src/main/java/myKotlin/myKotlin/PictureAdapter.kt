package myKotlin.myKotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dal.dal.Models.Photo
import myKotlin.myKotlin.databinding.CardBinding
import myKotlin.myKotlin.ui.menuPager.MenuPagerFragmentDirections

class PictureAdapter(private val nav: NavController) :
    RecyclerView.Adapter<PictureAdapter.ViewHolder>() {

    class ViewHolder(val binding: CardBinding) : RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(CardBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = differ.currentList[position]
        holder.binding.apply {
            title.text = photo.photographer
            text.text = photo.alt
            Glide.with(holder.itemView.context)
                .load(photo.src.original)
                .placeholder(R.drawable.image_placeholder_icon)
                .into(imageView)
            pictureCard.setOnClickListener {
                nav.navigate(
                    MenuPagerFragmentDirections
                        .actionMenuPagerFragmentToDetailFragment(photo)
                )
            }
        }
    }
}