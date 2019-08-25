package com.company.practice.service;

import com.company.practice.entity.Algorithm;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.*;
import org.springframework.stereotype.Service;

@Service(HashService.NAME)
public class HashServiceBean implements HashService {

    protected static final String TEST_VALUE = "HELLO world! It is a test value";

    @Override
    public void run(Algorithm algorithm) {
        switch (algorithm.getInfo()) {
            case HASH_GOST3411:
                runHash(new GOST3411Digest());
                break;
            case HASH_MD2:
                runHash(new MD2Digest());
                break;
            case HASH_MD4:
                runHash(new MD4Digest());
                break;
            case HASH_MD5:
                runHash(new MD5Digest());
                break;
            case HASH_RIPEMD128:
                runHash(new RIPEMD128Digest());
                break;
            case HASH_RIPEMD160:
                runHash(new RIPEMD160Digest());
                break;
            case HASH_RIPEMD256:
                runHash(new RIPEMD256Digest());
                break;
            case HASH_RIPEMD320:
                runHash(new RIPEMD320Digest());
                break;
            case HASH_SHA1:
                runHash(new SHA1Digest());
                break;
            case HASH_SHA224:
                runHash(new SHA224Digest());
                break;
            case HASH_SHA256:
                runHash(new SHA256Digest());
                break;
            case HASH_SHA384:
                runHash(new SHA384Digest());
                break;
            case HASH_SHA512:
                runHash(new SHA512Digest());
                break;
            case HASH_TIGER:
                runHash(new TigerDigest());
                break;
            case HASH_WHIRLPOOL:
                runHash(new WhirlpoolDigest());
                break;
        }
    }

    protected void runHash(Digest digest) {
        byte[] input = TEST_VALUE.getBytes();
        for (int i = 0; i < 16000; i++) {
            input = processHash(input, digest);
        }
    }

    protected byte[] processHash(byte[] input, Digest digest) {
        digest.update(input, 0, input.length);
        byte[] output = new byte[digest.getDigestSize()];
        digest.doFinal(output, 0);
        return output;
    }
}