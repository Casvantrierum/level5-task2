package com.example.level5_task2.dao


import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.level5_task2.model.Game

@Dao
interface GameDao {

    @Query("SELECT * FROM gameTable")
    fun getGameLog(): LiveData<List<Game>>

    @Insert
    suspend fun insertGame(game: Game)

    @Delete
    suspend fun deleteGame(game: Game)

    @Update
    suspend fun updateGame(game: Game)
}