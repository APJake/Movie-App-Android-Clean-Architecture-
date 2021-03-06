package com.apjake.codetestmovielist.local.dao

import androidx.room.*
import com.apjake.codetestmovielist.local.entity.PopularMovieEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface PopularMovieDao {

    @Query("SELECT * FROM PopularMovie")
    fun getMovies(): Observable<List<PopularMovieEntity>>

    @Query("SELECT * FROM PopularMovie WHERE id == :id")
    fun getMovie(id: Int): Observable<PopularMovieEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAll(movieList: List<PopularMovieEntity>)

    @Query("DELETE FROM PopularMovie")
    fun deleteAll()

    @Query("UPDATE PopularMovie SET isFavourite=:isFavourite WHERE id=:id")
    fun updateFavourite(id: Int, isFavourite: Boolean)
}