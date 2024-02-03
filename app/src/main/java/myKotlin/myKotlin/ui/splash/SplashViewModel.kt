package myKotlin.myKotlin.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dal.dal.Models.Photos
import dal.dal.Repositories.PhotoRepository
import kotlinx.coroutines.launch

class SplashViewModel(private val photoRepo: PhotoRepository) : ViewModel() {
    val photoLiveData: LiveData<Photos>
        get() = photoRepo.photos

    init {
        viewModelScope.launch {
            photoRepo.get()
        }
    }
}