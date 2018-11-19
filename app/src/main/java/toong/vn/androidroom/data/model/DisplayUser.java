package toong.vn.androidroom.data.model;

import toong.vn.androidroom.data.model.User;

/**
 * Created by PhanVanLinh on 23/11/2017.
 * phanvanlinh.94vn@gmail.com
 */

public class DisplayUser extends User {

    private int noOfTask;

    public int getNoOfTask() {
        return noOfTask;
    }

    public void setNoOfTask(int noOfTask) {
        this.noOfTask = noOfTask;
    }
}
