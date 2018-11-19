package toong.vn.androidroom.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import toong.vn.androidroom.data.local.dao.TaskDao
import toong.vn.androidroom.data.local.dao.UserDao
import toong.vn.androidroom.data.model.Task
import toong.vn.androidroom.data.model.User

@Database(entities = [User::class, Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun taskDao(): TaskDao

    companion object {
        fun getAppDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                    context,
                    AppDatabase::class.java, "database-name"
            ).build()
        }
    }
}