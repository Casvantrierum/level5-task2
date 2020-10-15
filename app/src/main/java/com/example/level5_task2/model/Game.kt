package com.example.level5_task2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "gameTable")
data class Game(

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "release")
    var release: Date,

    @ColumnInfo(name = "platform")
    var platform: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
)
