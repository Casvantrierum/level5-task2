package com.example.level5_task2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.level5_task2.Converters
import com.example.level5_task2.dao.GameDao
import com.example.level5_task2.model.Game

@Database(entities = [Game::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class GamelogRoomDatabase : RoomDatabase() {

    abstract fun gameDao(): GameDao

    companion object {
        private const val DATABASE_NAME = "GAMELOG_DATABASE"

        @Volatile
        private var INSTANCE: GamelogRoomDatabase? = null

        fun getDatabase(context: Context): GamelogRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(GamelogRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            GamelogRoomDatabase::class.java, DATABASE_NAME
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }

}
