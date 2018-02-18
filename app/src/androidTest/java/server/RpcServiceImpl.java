package server;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;

public class RpcServiceImpl implements IRpcService {

        final UiDevice uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    public String logMsg() {
        System.out.println("No Arguments log");
        return "No Argument";
    }

    public String logMsg(String msg) {
        System.out.println("With Arguments log");

        return "With Argument >>>" + msg;
    }

    @Override
    public void home() {
        uiDevice.pressHome();
    }

    @Override
    public void back() {
        uiDevice.pressBack();
    }

    @Override
    public void openNotification() {
        uiDevice.openNotification();
    }

    @Override
    public void click(int x, int y) {
        uiDevice.click(x, y);
    }

}
