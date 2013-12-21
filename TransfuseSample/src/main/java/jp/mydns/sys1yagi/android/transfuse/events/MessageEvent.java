package jp.mydns.sys1yagi.android.transfuse.events;

public class MessageEvent {

    private String mMessage;

    public MessageEvent(String message) {
        mMessage = message;
    }

    public String getMessage() {
        return mMessage;
    }
}
