package myKotlin.myKotlin.ui.mainTab

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dal.dal.Models.FeaturedCollections
import dal.dal.Models.Photos
import dal.dal.Repositories.FeaturedCollectionsRepository
import dal.dal.Repositories.PhotoRepository
import kotlinx.coroutines.launch

class MainTabViewModel(
    private val photoRepo: PhotoRepository,
    private val collectionsRepo: FeaturedCollectionsRepository
) : ViewModel() {
    val photoLiveData: LiveData<Photos>
        get() = photoRepo.photos
    val collectionsLiveData: LiveData<FeaturedCollections>
        get() = collectionsRepo.collections
    private var page = 1

    init {
        viewModelScope.launch {
            photoRepo.get()
            collectionsRepo.get()
        }
    }

    fun getPhotos() {
        viewModelScope.launch {
            photoRepo.get(page)
        }
        page++
    }

    fun getPhotosByName(requestStr: String) {
        viewModelScope.launch {
            photoRepo.getByName(requestStr);
        }
    }
}
