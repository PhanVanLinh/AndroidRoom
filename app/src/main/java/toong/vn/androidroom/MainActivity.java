package toong.vn.androidroom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = AppDatabase.getAppDatabase(this);

        Observable.just(db).subscribeOn(Schedulers.io()).subscribe(new Consumer<AppDatabase>() {
            @Override
            public void accept(AppDatabase appDatabase) throws Exception {
                User user = new User();
                user.setUid(new Random().nextInt(1000));
                user.setFirstName("s");
                appDatabase.userDao().insertAll(user);
                appDatabase.userDao().getAll();
            }
        });
    }
}
