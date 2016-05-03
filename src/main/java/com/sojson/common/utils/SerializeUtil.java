package com.sojson.common.utils;

import java.io.*;

/**
 * 
 * 开发公司：WENYIFAN.NET<br/>
 * 版权：WENYIFAN.NET<br/>
 * <p>
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2014年9月3日 　<br/>
 * <p>
 * 序列化
 * <p>
 * @author zhou-baicheng
 * 
 * @version 1.0,2014年9月3日 <br/>
 * 
 */
@SuppressWarnings("unchecked")
public class SerializeUtil {

    public static byte[] serialize(Object value) {
        if (value == null) {
            throw new NullPointerException("Can't serialize null");
        }
        byte[] rv = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        try {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(value);
            os.close();
            bos.close();
            rv = bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("serialize error");
        } finally {
            close(os);
            close(bos);
        }
        return rv;
    }

    
	public static Object deserialize(byte[] in) {
        return deserialize(in, Object.class);
    }

    public static <T> T deserialize(byte[] in, Class<T>...requiredType) {
        Object rv = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            if (in != null) {
                bis = new ByteArrayInputStream(in);
                is = new ObjectInputStream(bis);
                rv = is.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("deserialize error");
        } finally {
            close(is);
            close(bis);
        }
        return (T) rv;
    }

    private static void close(Closeable closeable) {
        if (closeable != null)
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("close stream error");
            }
    }

}
