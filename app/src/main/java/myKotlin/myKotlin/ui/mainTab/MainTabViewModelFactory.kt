package myKotlin.myKotlin.ui.mainTab

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dal.dal.Repositories.FeaturedCollectionsRepository
import dal.dal.Repositories.PhotoRepository
import javax.inject.Inject

class MainTabViewModelFactory @Inject constructor(
    private val photoRepository: PhotoRepository,
    private val featuredCollectionsRepository: FeaturedCollectionsRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainTabViewModel(photoRepository, featuredCollectionsRepository) as T
    }
}
