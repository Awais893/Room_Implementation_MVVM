package com.shadowarm.dataclass

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [ContactEntity::class], version = 1)
abstract class ContactDatabae : RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object {
        @Volatile
        private var INSTANCE: ContactDatabae? = null

        fun getDatabse(context: Context): ContactDatabae {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabae::class.java, "contactDB"
                    ).createFromAsset("Courses.db")
                        .build()
                }
                }

                return INSTANCE!!

        }
    }
}