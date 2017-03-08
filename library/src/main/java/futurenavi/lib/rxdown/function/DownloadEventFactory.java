package futurenavi.lib.rxdown.function;

import futurenavi.lib.rxdown.entity.DownloadEvent;
import futurenavi.lib.rxdown.entity.DownloadStatus;

import static futurenavi.lib.rxdown.entity.DownloadFlag.COMPLETED;
import static futurenavi.lib.rxdown.entity.DownloadFlag.FAILED;
import static futurenavi.lib.rxdown.entity.DownloadFlag.NORMAL;
import static futurenavi.lib.rxdown.entity.DownloadFlag.PAUSED;
import static futurenavi.lib.rxdown.entity.DownloadFlag.STARTED;
import static futurenavi.lib.rxdown.entity.DownloadFlag.WAITING;

/**
 * Author: Season(ssseasonnn@gmail.com)
 * Date: 2016/11/23
 * Time: 14:18
 * FIXME
 */
public class DownloadEventFactory {
    public static DownloadEvent normal(DownloadStatus status) {
        return createEvent(NORMAL, status);
    }

    public static DownloadEvent waiting(DownloadStatus status) {
        return createEvent(WAITING, status);
    }

    public static DownloadEvent started(DownloadStatus status) {
        return createEvent(STARTED, status);
    }

    public static DownloadEvent paused(DownloadStatus status) {
        return createEvent(PAUSED, status);
    }

    public static DownloadEvent completed(DownloadStatus status) {
        return createEvent(COMPLETED, status);
    }

    public static DownloadEvent failed(DownloadStatus status, Throwable throwable) {
        return createEvent(FAILED, status, throwable);
    }

    private static DownloadEvent createEvent(int flag, DownloadStatus status, Throwable throwable) {
        DownloadEvent event = createEvent(flag, status);
        event.setError(throwable);
        return event;
    }

    public static DownloadEvent createEvent(int flag, DownloadStatus status) {
        DownloadEvent event = new DownloadEvent();
        event.setDownloadStatus(status == null ? new DownloadStatus() : status);
        event.setFlag(flag);
        return event;
    }
}
