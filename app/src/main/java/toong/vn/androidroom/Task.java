package toong.vn.androidroom;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by PhanVanLinh on 23/11/2017.
 * phanvanlinh.94vn@gmail.com
 */

@Entity
public class Task {
    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "userId")
    private int userId;

    private String title;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}