package toong.vn.androidroom.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by PhanVanLinh on 23/11/2017.
 * phanvanlinh.94vn@gmail.com
 */

@Entity
class Task {
    @PrimaryKey
    var uid: Int = 0

    @ColumnInfo(name = "userId")
    var userId: Int = 0

    var title: String? = null
}