package rpc.server;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;

import java.io.File;

import utils.ImgUtils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RpcServiceImpl implements IRpcService {
    private static final String TAG = "autotest";
    final UiDevice uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

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
    public void clickByCoordinate(int x, int y) throws Exception {
        uiDevice.click(x, y);

    }

    @Override
    public void clickById(String resourceId) throws Exception {
        uiDevice.findObject(new UiSelector().resourceId(resourceId)).click();
    }

    @Override
    public void clickByText(String text) throws Exception {
        uiDevice.findObject(new UiSelector().text(text)).click();

    }

    @Override
    public void clickByTextContains(String text) throws Exception {
        uiDevice.findObject(new UiSelector().textContains(text)).click();

    }

    @Override
    public void inputTextById(String text, String resourceId) throws Exception {
        UiObject uiObject= uiDevice.findObject(new UiSelector().resourceId(resourceId));
        uiObject.clearTextField();
        uiObject.setText(text);

    }

    @Override
    public void clearTextById(String resourceId) throws Exception {
        UiObject uiObject= uiDevice.findObject(new UiSelector().resourceId(resourceId));
        uiObject.clearTextField();

    }

    @Override
    public void swipe(int x, int y, int x1, int y1, int step) throws Exception {
        uiDevice.swipe(x, y, x1, y1, step);
    }


    @Override
    public byte[] takeScreenshot(String pngName) throws Exception {

        String pngPath = "/data/data/com.guangqianou.androidtestserver";

        String filePath = null;


        if (pngName.equals("")){
            filePath = pngPath + "/tmp.png";
        }else {
            filePath = pngPath + "/" + pngName;
        }

        Log.d(TAG, "takeScreenshot: " + filePath);

        File file = new File(filePath);
        uiDevice.takeScreenshot(file);

        return ImgUtils.image2Bytes(filePath);
    }

    @Override
    public boolean textExists(String text) throws Exception {
        return uiDevice.findObject(new UiSelector().textContains(text)).exists();
    }

    @Override
    public boolean eleExists(String resourceId) throws Exception {
        return uiDevice.findObject(new UiSelector().resourceId(resourceId)).exists();
    }

}
