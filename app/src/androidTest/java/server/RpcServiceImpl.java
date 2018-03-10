package server;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiSelector;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RpcServiceImpl implements IRpcService {

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
        uiDevice.findObject(new UiSelector().text(text));

    }

    @Override
    public void clickByTextContains(String text) throws Exception {
        uiDevice.findObject(new UiSelector().textContains(text)).click();

    }

    @Override
    public void verifyTextExists(String text) throws Exception {
        assertTrue(uiDevice.findObject(new UiSelector().textContains(text)).exists());

    }

    @Override
    public void verifyTextNotExists(String text) throws Exception {
        assertFalse(uiDevice.findObject(new UiSelector().textContains(text)).exists());

    }

    @Override
    public void verifyEleExists(String resourceId) throws Exception {
        assertTrue(uiDevice.findObject(new UiSelector().resourceId(resourceId)).exists());


    }

    @Override
    public void verifyEleNotExists(String resourceId) throws Exception {
        assertFalse(uiDevice.findObject(new UiSelector().resourceId(resourceId)).exists());

    }
}
