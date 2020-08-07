package com.lmw.livebus.lib;

import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;
import java.util.Map;

public class LMWLiveBus {
    public static final String TAG = LMWLiveBus.class.getName();
    /**
     * 粘性事件集合
     */
    private final Map<String, MutableLiveData> stickyBus;

    /**
     * 普通事件结合
     */
    private final Map<String, LMWMutable> bus;

    private LMWLiveBus() {
        stickyBus = new HashMap<>();
        bus = new HashMap<>();
    }

    private static class singleHolder {
        private static final LMWLiveBus SINGLE_BUS = new LMWLiveBus();
    }

    public static LMWLiveBus getInstance() {
        return singleHolder.SINGLE_BUS;
    }

    public MutableLiveData<Object> with(String key) {
        return with(key, Object.class);
    }

    public <T> MutableLiveData<T> with(String key, Class<T> type) {
        if (!bus.containsKey(key)) {
            bus.put(key, new LMWMutable<T>());
        }
        return bus.get(key);
    }

    public MutableLiveData<Object> withSticky(String key) {
        return withSticky(key, Object.class);
    }

    public <T> MutableLiveData<T> withSticky(String key, Class<T> type) {
        if (!stickyBus.containsKey(key)) {
            stickyBus.put(key, new MutableLiveData<T>());
        }
        return stickyBus.get(key);
    }


}
