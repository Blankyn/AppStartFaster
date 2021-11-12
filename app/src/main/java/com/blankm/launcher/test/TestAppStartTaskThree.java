package com.blankm.launcher.test;

import android.app.Application;
import android.util.Log;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import me.blankm.launcher.executor.TaskExceutorManager;
import me.blankm.launcher.task.AppStartTask;

public class TestAppStartTaskThree extends AppStartTask {

    public TestAppStartTaskThree(Application application) {
        super(application);
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(300);
        }catch (Exception e){

        }
        Log.i("Task:","TestAppStartTaskThree执行耗时: "+(System.currentTimeMillis()-start));
    }
    @Override
    public Executor runOnExecutor() {
        return TaskExceutorManager.getInstance().getCPUThreadPoolExecutor();
    }
    @Override
    public List<Class<? extends AppStartTask>> getDependsTaskList() {
        List<Class<? extends AppStartTask>> dependsTaskList = new ArrayList<>();
        dependsTaskList.add(TestAppStartTaskOne.class);
        dependsTaskList.add(TestAppStartTaskTwo.class);
        return dependsTaskList;
    }

    @Override
    public boolean isRunOnMainThread() {
        return false;
    }

}
