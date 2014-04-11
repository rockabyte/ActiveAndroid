package com.activeandroid.serializer;

import com.activeandroid.util.KeyValueMap;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by sschlicht on 10.04.14.
 */
public class KeyValueSerializer extends TypeSerializer {
    public Class<?> getDeserializedType() {
        return KeyValueMap.class;
    }

    public Class<?> getSerializedType() {
        return byte[].class;
    }

    public byte[] serialize(Object data) {
        if (data == null) {
            return null;
        }

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(out);
            os.writeObject(data);

            return out.toByteArray();
        } finally {
            return null;
        }
    }

    public KeyValueMap deserialize(Object data) {
        if (data == null) {
            return null;
        }

        try {
            ByteArrayInputStream in = new ByteArrayInputStream((byte[]) data);
            ObjectInputStream is = new ObjectInputStream(in);
            return (KeyValueMap)is.readObject();
        } finally {
            return null;
        }
    }
}
