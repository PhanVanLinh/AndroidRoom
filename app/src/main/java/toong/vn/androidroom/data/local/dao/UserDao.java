package toong.vn.androidroom.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.List;
import toong.vn.androidroom.data.model.DisplayUser;
import toong.vn.androidroom.data.model.User;
import toong.vn.androidroom.data.model.UserAndTask;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user")
    Single<List<User>> rxGetAllSingle();

    @Query("SELECT * FROM user")
    Maybe<List<User>> rxGetAllMaybe();

    @Query("SELECT *, 1 as noOfTask FROM user")
    List<DisplayUser> getAllUserWithNoOfTask();

    @Query("SELECT * FROM user")
    List<UserAndTask> getAll2();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND "
           + "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);

    @Insert
    void insertAll(User... users);

    @Insert
    void insert(User user);

    @Delete
    void delete(User user);
}