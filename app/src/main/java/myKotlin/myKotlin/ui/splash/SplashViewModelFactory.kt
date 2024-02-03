package myKotlin.myKotlin.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dal.dal.Repositories.PhotoRepository
import javax.inject.Inject

class SplashViewModelFactory @Inject constructor(
    private val repository: PhotoRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        SplashViewModel(repository) as T
}