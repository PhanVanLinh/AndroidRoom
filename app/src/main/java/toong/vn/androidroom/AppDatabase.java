package toong.vn.androidroom;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import toong.vn.androidroom.dao.TaskDao;
import toong.vn.androidroom.dao.UserDao;

@Database(entities = { User.class, Task.class }, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract TaskDao mTaskDao();

    private static AppDatabase INSTANCE;

    public synchronized static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,
                                    "android-room-user-database").build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}