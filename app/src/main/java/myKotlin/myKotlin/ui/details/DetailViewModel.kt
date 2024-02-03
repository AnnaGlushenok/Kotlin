package myKotlin.myKotlin.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dal.dal.Models.Photo
import dal.dal.Repositories.PhotoRepository
import kotlinx.coroutines.launch

class DetailViewModel(private val photoRepo: PhotoRepository) : ViewModel() {
    fun add(photo: Photo) {
        viewModelScope.launch {
            photoRepo.add(photo);
        }
    }
}
