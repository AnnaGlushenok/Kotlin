package dal.dal.Models

import java.io.Serializable

data class Photos(
    val total_results: Int,
    val page: Int,
    val per_page: Int,
    val photos: List<Photo>,
    val next_page: String?
) : Serializable
