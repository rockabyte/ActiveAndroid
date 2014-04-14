package com.activeandroid.serializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 * Created by sschlicht on 14.04.14.
 */
public class MapSerializer extends TypeSerializer {
    public Class<?> getDeserializedType() {
        return Map.class;
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

    public Map<?,?> deserialize(Object data) {
        if (data == null) {
            return null;
        }

        try {
            ByteArrayInputStream in = new ByteArrayInputStream((byte[]) data);
            ObjectInputStream is = new ObjectInputStream(in);
            return (Map<?,?>)is.readObject();
        } finally {
            return null;
        }
    }
}
