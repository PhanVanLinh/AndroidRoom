package toong.vn.androidroom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = AppDatabase.getAppDatabase(this);

        Observable.just(db).subscribeOn(Schedulers.io()).subscribe(new Consumer<AppDatabase>() {
            @Override
            public void accept(AppDatabase appDatabase) throws Exception {
                //                prepareData(appDatabase);
                //                prepareTask(appDatabase);

                //                appDatabase.userDao().getAll2();
                //                appDatabase.userDao().getAllUserWithNoOfTask();

                appDatabase.userDao()
                        .rxGetAllSingle()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSuccess(new Consumer<List<User>>() {
                            @Override
                            public void accept(List<User> users) throws Exception {

                            }
                        })
                        .doOnError(new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                            }
                        });

                appDatabase.userDao()
                        .rxGetAllMaybe()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSuccess(new Consumer<List<User>>() {
                            @Override
                            public void accept(List<User> users) throws Exception {

                            }
                        })
                        .doOnComplete(new Action() {
                            @Override
                            public void run() throws Exception {

                            }
                        })
                        .doOnError(new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                            }
                        })
                        .subscribe();
            }
        });
    }

    private void prepareData(AppDatabase appDatabase) {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUid(i);
            user.setFirstName("user " + i);
            user.setAge(1);

            appDatabase.userDao().insert(user);
        }
    }

    private void prepareTask(AppDatabase appDatabase) {
        for (int i = 0; i < 5; i++) {
            Task task = new Task();
            task.setUid(i);
            task.setTitle("task " + i);
            task.setUserId(1);

            appDatabase.mTaskDao().insert(task);
        }
    }
}
