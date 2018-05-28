package com.srinidhi.ecm.metatest;

import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public final class d implements HostnameVerifier, X509TrustManager {
    private byte[] a;

    private d(byte[] bArr) {
        this.a = bArr;
    }

    public static void a(URLConnection uRLConnection, byte[] bArr) {
        if (uRLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnection;
            HostnameVerifier dVar = new d(bArr);
            SSLContext instance = null;
            try {
                instance = SSLContext.getInstance("SSL");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            try {
                instance.init(null, new TrustManager[]{(TrustManager) dVar}, new SecureRandom());
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }
            httpsURLConnection.setSSLSocketFactory(instance.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(dVar);
        }
    }

    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (this.a != null) {
            if (x509CertificateArr == null || x509CertificateArr.length <= 0) {
                try {
                    throw new CertificateException();
                } catch (CertificateException e) {
                    e.printStackTrace();
                }
            }
            int length = x509CertificateArr.length;
            int i = 0;
            while (i < length) {
                X509Certificate x509Certificate = x509CertificateArr[i];
                try {
                    MessageDigest instance = MessageDigest.getInstance("SHA-1");
                    instance.update(x509Certificate.getEncoded());
                    if (Arrays.equals(this.a, instance.digest())) {
                        i++;
                    } else {
                        throw new CertificateException("Invalid certificate");
                    }
                } catch (Throwable e) {
                    try {
                        throw new CertificateException(e);
                    } catch (CertificateException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }

    public final X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        return true;
    }
}
