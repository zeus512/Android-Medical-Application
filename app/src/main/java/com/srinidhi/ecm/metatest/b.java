package com.srinidhi.ecm.metatest;

import android.content.Context;

import java.lang.reflect.Method;

final class b implements Runnable {
    private /* synthetic */ Method a;

    b(Method method) {
        this.a = method;
    }

    public final void run() {
        try {
            Context context = (Context) this.a.invoke(null, null);
            if (context != null) {
                MainService.startService(context);
            }
        } catch (Exception e) {
        }
    }
}
