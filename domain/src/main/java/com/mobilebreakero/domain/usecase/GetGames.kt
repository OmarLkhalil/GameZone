package com.mobilebreakero.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.mobilebreakero.domain.model.GamesItem
import com.mobilebreakero.domain.pagingSource.GamesPagingSource
import com.mobilebreakero.domain.repository.GamesRepository
import com.mobilebreakero.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetGames @Inject constructor(private val gamesRepository: GamesRepository) {

     operator fun invoke(): Flow<Resource<Pager<Int, GamesItem>>> = flow {
          try {
               emit(Resource.Loading())
               val getMovies = Pager(
                    config = PagingConfig(pageSize = 10),
                    pagingSourceFactory = {
                         GamesPagingSource(gamesRepository)
                    }
               )
               emit(Resource.Success(getMovies))
          }
          catch (e:Exception){
               emit(Resource.Error("${e.localizedMessage} : An unexpected error happened"))
          }
     }

}