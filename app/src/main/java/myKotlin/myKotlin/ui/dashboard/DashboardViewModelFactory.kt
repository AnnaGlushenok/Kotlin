package myKotlin.myKotlin.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dal.dal.Repositories.PhotoRepository
import javax.inject.Inject

class DashboardViewModelFactory @Inject constructor(
    private val photoRepository: PhotoRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DashboardViewModel(photoRepository) as T
    }
}