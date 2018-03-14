package rpc.server;

public interface IRpcService {

    void home() throws Exception;
    void back() throws Exception;
    void openNotification();

    void clickByCoordinate(int x, int y) throws Exception;
    void clickById(String resourceId) throws Exception;
    void clickByText(String text) throws Exception;
    void clickByTextContains(String text) throws Exception;

    void inputTextById(String text, String resourceId) throws Exception;
    void clearTextById(String resourceId) throws Exception;

    void swipe(int x, int y, int x1, int y1, int step) throws Exception;

    byte[] takeScreenshot(String pngName) throws Exception;

    boolean textExists(String text) throws Exception;
    boolean eleExists(String resourceId) throws Exception;
}
