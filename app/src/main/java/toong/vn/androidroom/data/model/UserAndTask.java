package toong.vn.androidroom.data.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;
import java.util.List;

import toong.vn.androidroom.data.model.Task;
import toong.vn.androidroom.data.model.User;

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
