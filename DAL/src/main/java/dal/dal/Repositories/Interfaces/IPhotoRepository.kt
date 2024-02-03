package dal.dal.Repositories.Interfaces

import dal.dal.Models.Photo


interface IPhotoRepository : IRepository {
    suspend fun get(page: Int = 1)
    suspend fun getByName(requestStr: String)
    suspend fun add(photo: Photo)
    suspend fun getSavedPhotos()
}