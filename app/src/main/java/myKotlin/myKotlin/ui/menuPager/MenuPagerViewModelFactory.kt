package myKotlin.myKotlin.ui.menuPager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dal.dal.Repositories.PhotoRepository
import javax.inject.Inject

class MenuPagerViewModelFactory @Inject constructor(
    private val repository: PhotoRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        MenuPagerViewModel(repository) as T
}