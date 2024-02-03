package myKotlin.myKotlin.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dal.dal.Models.Photo
import dal.dal.Repositories.PhotoRepository
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val photoRepo: PhotoRepository
) : ViewModel() {
    val photoLiveData: LiveData<List<Photo>>
        get() = photoRepo.savedPhotos

    init {
        get()
    }

    fun get() {
        viewModelScope.launch {
            photoRepo.getSavedPhotos()
        }
    }
}