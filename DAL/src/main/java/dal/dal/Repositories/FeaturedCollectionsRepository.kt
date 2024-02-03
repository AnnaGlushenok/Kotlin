package dal.dal.Repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dal.dal.API.FeaturedCollectionsAPI
import dal.dal.Models.FeaturedCollections
import dal.dal.Repositories.Interfaces.IFeaturedCollection
import javax.inject.Inject

class FeaturedCollectionsRepository @Inject constructor(private val api: FeaturedCollectionsAPI) :
    IFeaturedCollection {
    private val COUNT_COLLECTIONS = 6
    private val _collections = MutableLiveData<FeaturedCollections>()
    val collections: LiveData<FeaturedCollections>
        get() = _collections

    override suspend fun get() {
        val res = api.getFeaturedCollections(COUNT_COLLECTIONS)
        if (res.isSuccessful && res.body() != null)
            _collections.postValue(res.body())
    }
}