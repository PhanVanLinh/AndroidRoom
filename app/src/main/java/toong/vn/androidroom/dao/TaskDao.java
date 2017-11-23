package toong.vn.androidroom.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import toong.vn.androidroom.Task;

/**
 * Created by PhanVanLinh on 23/11/2017.
 * phanvanlinh.94vn@gmail.com
 */

@Dao
public interface TaskDao {

    @Insert
    void insert(Task user);
}
