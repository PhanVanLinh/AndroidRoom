package toong.vn.androidroom.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single
import toong.vn.androidroom.data.model.DisplayUser
import toong.vn.androidroom.data.model.User

@Dao
interface UserDao {

    @get:Query("SELECT * FROM user")
    val all: Single<List<User>>

    @get:Query("SELECT *, 1 as noOfTask FROM user")
    val allUserWithNoOfTask: List<DisplayUser>

    @Query("SELECT * FROM user")
    fun rxGetAllMaybe(): Maybe<List<User>>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " + "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

    @Query("SELECT COUNT(*) FROM user")
    fun count(): Single<Int>

    @Query("SELECT * FROM user WHERE uid = :id")
    fun getUserById(id: String): Flowable<User>

    @Insert
    fun insertAll(vararg users: User)

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)
}