package toong.vn.androidroom.data.model

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Created by PhanVanLinh on 23/11/2017.
 * phanvanlinh.94vn@gmail.com
 */

class UserAndTask {
    @Embedded
    var user: User? = null
    @Relation(parentColumn = "uid", entityColumn = "userId", entity = Task::class)
    var tasks: List<Task>? = null


}
