package com.afifbaihaqi.movieku.core.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [FavoriteMovie::class, FavoriteTv::class],
    version = 1
)
abstract class DatabaseFavorite : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}