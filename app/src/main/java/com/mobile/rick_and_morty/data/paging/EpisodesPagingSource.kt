package com.mobile.rick_and_morty.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mobile.rick_and_morty.data.mappers.toDomain
import com.mobile.rick_and_morty.data.remote.RickAndMortyApi
import com.mobile.rick_and_morty.domain.model.Episode

//class EpisodesPagingSource(
//    private val api: RickAndMortyApi
//
//) : PagingSource<Int, Episode>() {
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Episode> {
//        return try {
//
//            val page = params.key ?: 1
//
//            val response = api.getEpisodes(page = page)
//
//            val episodes = response.results.map { it.toDomain() }
//
//            LoadResult.Page(
//                data = episodes,
//                prevKey = if (page == 1) null else page - 1,
//                nextKey = if (response.info.next != null) page + 1 else null,
//            )
//        } catch (e: Exception) {
//            LoadResult.Error(e)
//        }
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, Episode>): Int? {
//        return state.anchorPosition?.let { position ->
//            state.closestPageToPosition(position)?.prevKey?.plus(1)
//                ?: state.closestPageToPosition(position)?.nextKey?.minus(1)
//        }
//    }
//
//}