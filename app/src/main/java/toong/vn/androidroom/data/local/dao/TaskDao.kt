package toong.vn.androidroom.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import toong.vn.androidroom.data.model.Task

/**
 * Created by PhanVanLinh on 23/11/2017.
 * phanvanlinh.94vn@gmail.com
 */
@Dao
interface TaskDao {
    @Insert
    fun insert(user: Task)
}
