package dal.dal.Repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dal.dal.API.PhotoAPI
import dal.dal.Models.Photo
import dal.dal.Models.Photos
import dal.dal.Repositories.Interfaces.IPhotoRepository
import dal.dal.db.PhotoDatabase
//import dal.dal.db.PhotoDatabase
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val api: PhotoAPI,
    private val photoDB: PhotoDatabase
) : IPhotoRepository {
    private val COUNT_PHOTOS = 10
    private val _photos = MutableLiveData<Photos>()
    val photos: LiveData<Photos>
        get() = _photos
    private val _savedPhotos = MutableLiveData<List<Photo>>()
    val savedPhotos: LiveData<List<Photo>>
        get() = _savedPhotos

    override suspend fun get(page: Int) {
        val res = api.getPhotos(COUNT_PHOTOS, page)
        if (res.isSuccessful && res.body() != null) {
            val currentPhotos = _photos.value
            var updatedPhotos: Photos?
            if (currentPhotos != null) {
                val updatedPhotosList = mutableListOf<Photo>()
                val newPhotos = res.body()!!.photos
                updatedPhotosList.addAll(currentPhotos.photos)
                updatedPhotosList.addAll(newPhotos)
                updatedPhotos = currentPhotos.copy(photos = updatedPhotosList)
                _photos.postValue(updatedPhotos)
            } else
                _photos.postValue(res.body())
        }
    }

    override suspend fun getByName(requestStr: String) {
        val res = api.getPhotosByName(requestStr, COUNT_PHOTOS)
        if (res.isSuccessful && res.body() != null)
            _photos.postValue(res.body())
    }

    override suspend fun add(photo: Photo) {
        photoDB.getPhotoDAO().upsert(photo)
    }

    override suspend fun getSavedPhotos() {
        _savedPhotos.postValue(photoDB.getPhotoDAO().getAllPhotos())
    }
}
