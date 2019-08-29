package com.company.practice.service;

import com.company.practice.entity.Algorithm;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.*;
import org.springframework.stereotype.Service;

@Service(HashService.NAME)
public class HashServiceBean implements HashService {

    protected static final String TEST_VALUE = "HELLO world! It is a test value";

    @Override
    public long run(Algorithm algorithm) {
        switch (algorithm.getInfo()) {
            case HASH_GOST3411:
                return runHash(new GOST3411Digest());
            case HASH_MD2:
                return runHash(new MD2Digest());
            case HASH_MD4:
                return runHash(new MD4Digest());
            case HASH_MD5:
                return runHash(new MD5Digest());
            case HASH_RIPEMD128:
                return runHash(new RIPEMD128Digest());
            case HASH_RIPEMD160:
                return runHash(new RIPEMD160Digest());
            case HASH_RIPEMD256:
                return runHash(new RIPEMD256Digest());
            case HASH_RIPEMD320:
                return runHash(new RIPEMD320Digest());
            case HASH_SHA1:
                return runHash(new SHA1Digest());
            case HASH_SHA224:
                return runHash(new SHA224Digest());
            case HASH_SHA256:
                return runHash(new SHA256Digest());
            case HASH_SHA384:
                return runHash(new SHA384Digest());
            case HASH_SHA512:
                return runHash(new SHA512Digest());
            case HASH_TIGER:
                return runHash(new TigerDigest());
            case HASH_WHIRLPOOL:
                return runHash(new WhirlpoolDigest());
            default:
                return 0;
        }
    }

    protected long runHash(Digest digest) {
        byte[] input = TEST_VALUE.getBytes();
        for (int i = 0; i < 16000; i++) {
            input = processHash(input, digest);
        }
        return Runtime.getRuntime().freeMemory();
    }

    protected byte[] processHash(byte[] input, Digest digest) {
        digest.update(input, 0, input.length);
        byte[] output = new byte[digest.getDigestSize()];
        digest.doFinal(output, 0);
        return output;
    }
}