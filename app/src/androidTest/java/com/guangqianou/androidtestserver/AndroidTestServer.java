package com.guangqianou.androidtestserver;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import rpc.exporter.RpcExporter;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class AndroidTestServer {
    @Test
    public void startServer() throws Exception {

        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {

                    RpcExporter.exporter("localhost", 9000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        while (true){
            Thread.sleep(500);
        }

    }
}
