package com.srinidhi.ecm.metatest;

import java.io.UnsupportedEncodingException;

public final class a {
    public static int a(byte[] bArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < 4) {
            i3 |= (bArr[i2 + i] & 255) << (i2 << 3);
            i2++;
        }
        return i3;
    }

    public static String a(byte[] bArr, int i, int i2) {
        byte[] b = b(bArr, i, i2);
        try {
            return new String(b, "ISO-8859-1").trim();
        } catch (UnsupportedEncodingException e) {
            return new String(b).trim();
        }
    }

    public static byte[] b(byte[] bArr, int i, int i2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return (byte[]) obj;
    }
}
