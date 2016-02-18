package com.anwei.rms.util;

import java.nio.ByteBuffer;
import java.util.UUID;

public abstract class UuidUtils {

    public static String base58Uuid() {
        UUID uuid = UUID.randomUUID();
        return base58Uuid(uuid);
    }

    protected static String base58Uuid(UUID uuid) {

        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());

        return Base58.encode(bb.array());
    }

    public static String encodeBase58Uuid(String uuidString) {
        UUID uuid = UUID.fromString(uuidString);
        return base58Uuid(uuid);
    }

    public static String decodeBase58Uuid(String base58uuid) {
        byte[] byUuid = Base58.decode(base58uuid);
        ByteBuffer bb = ByteBuffer.wrap(byUuid);
        UUID uuid = new UUID(bb.getLong(), bb.getLong());
        return uuid.toString();
    }    
}