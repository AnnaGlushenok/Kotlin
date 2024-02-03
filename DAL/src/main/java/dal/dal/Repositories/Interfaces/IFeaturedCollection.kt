package dal.dal.Repositories.Interfaces

interface IFeaturedCollection:IRepository {
    suspend fun get()
}