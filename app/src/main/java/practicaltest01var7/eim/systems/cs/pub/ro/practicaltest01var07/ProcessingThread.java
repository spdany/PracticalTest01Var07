package practicaltest01var7.eim.systems.cs.pub.ro.practicaltest01var07;


import android.content.Context;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.util.Log;

import java.util.Date;
import java.util.Random;

public class ProcessingThread extends Thread {

    private Context context = null;
    private boolean isRunning = true;

    private Random random = new Random();

    private double arithmeticMean;
    private double geometricMean;

    public ProcessingThread(Context context) {
        this.context = context;

    }

    @Override
    public void run() {
        Log.d("[ProcessingThread]", "Thread has started!");
        while (isRunning) {
            sendMessage();
            sleep();
        }
        Log.d("[ProcessingThread]", "Thread has stopped!");
    }

    private void sendMessage() {
        Intent intent = new Intent();
        int nr1,nr2,nr3,nr4;
        nr1 = random.nextInt(10) ;
        nr2 = random.nextInt(10) ;
        nr3 = random.nextInt(10) ;
        nr4 = random.nextInt(10) ;
        intent.putExtra("nr1", String.valueOf(nr1));
        intent.putExtra("nr2", String.valueOf(nr2));
        intent.putExtra("nr3", String.valueOf(nr3));
        intent.putExtra("nr4", String.valueOf(nr4));
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}