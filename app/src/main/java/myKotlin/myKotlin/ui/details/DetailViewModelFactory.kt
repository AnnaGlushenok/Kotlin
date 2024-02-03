package myKotlin.myKotlin.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dal.dal.Repositories.PhotoRepository
import javax.inject.Inject

class DetailViewModelFactory @Inject constructor(
    private val photoRepository: PhotoRepository,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(photoRepository) as T
    }
}