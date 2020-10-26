package com.example.level5_task2.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.level5_task2.dao.GameDao
import com.example.level5_task2.database.GamelogRoomDatabase
import com.example.level5_task2.model.Game

class GameRepository(context: Context) {

    private var gameDao: GameDao

    init {
        val noteRoomDatabase = GamelogRoomDatabase.getDatabase(context)
        gameDao = noteRoomDatabase!!.gameDao()
    }

    fun getGamelog(): LiveData<List<Game>> {
        return gameDao.getGameLog()
    }

    suspend fun insertGame(game: Game) {
        gameDao.insertGame(game)
    }

    suspend fun deleteGame(game: Game) {
        gameDao.deleteGame(game)
    }

    suspend fun deleteAllGames() {
        gameDao.deleteAllGames()
    }
}
