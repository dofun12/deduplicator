package org.lemanoman.deduplicator;

public interface OnDeduplication {
    void onInit(String receivedText);
    void onFinish(DedupOutput dedupOutput);
    void onError(Exception ex);
}
