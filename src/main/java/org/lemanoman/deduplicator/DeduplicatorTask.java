package org.lemanoman.deduplicator;

import java.util.HashSet;
import java.util.Set;

public class DeduplicatorTask implements Runnable{
    private String text;
    private OnDeduplication event;
    public DeduplicatorTask(String text, OnDeduplication event){
        this.text = text;
        this.event = event;
    }


    @Override
    public void run() {
        if(event!=null) event.onInit(text);
        try {
            DedupOutput out = new Deduplicator().deduplicate(text);
            event.onFinish(out);
        }catch (Exception ex){
            event.onError(ex);
            ex.printStackTrace();
        }
    }
}
