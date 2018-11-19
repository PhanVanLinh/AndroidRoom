package toong.vn.androidroom.screen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import toong.vn.androidroom.R
import toong.vn.androidroom.data.local.AppDatabase
import toong.vn.androidroom.data.model.Task
import toong.vn.androidroom.data.model.User

@SuppressLint("CheckResult")
class MainActivity : AppCompatActivity() {
    lateinit var db: AppDatabase

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = AppDatabase.getAppDatabase(this)

        button_insert.setOnClickListener { Observable.just(db).subscribeOn(Schedulers.io()).subscribe { insertUser().subscribeOn(Schedulers.io()).subscribe { updateUsersList() } } }
        updateUsersList()
    }

    private fun updateUsersList() {
        db.userDao().all.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe { users ->
                    val resultBuilder = StringBuilder()
                    for (user in users) {
                        resultBuilder.append(user.firstName).append("\n")
                    }
                    text_result.text = resultBuilder
                }
    }

    private fun insertUser(): Completable {
        return db.userDao().count().flatMapCompletable { id->
            val user = User()
            user.uid = id
            user.firstName = "user $id"
            user.age = 1
            return@flatMapCompletable Completable.fromAction { db.userDao().insert(user) }
        }
    }

    private fun prepareTask(appDatabase: AppDatabase) {
        for (i in 0..4) {
            val task = Task()
            task.uid = i
            task.title = "task $i"
            task.userId = 1

            appDatabase.taskDao().insert(task)
        }
    }
}
