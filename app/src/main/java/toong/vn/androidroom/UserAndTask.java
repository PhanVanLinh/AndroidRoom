package toong.vn.androidroom;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;
import java.util.List;

/**
 * Created by PhanVanLinh on 23/11/2017.
 * phanvanlinh.94vn@gmail.com
 */

public class UserAndTask {
    @Embedded
    public User user;
    @Relation(parentColumn="uid", entityColumn = "userId", entity = Task.class)
    public List<Task> tasks;


}
