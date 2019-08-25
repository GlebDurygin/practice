package com.company.practice.service;

import com.company.practice.entity.Algorithm;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.*;
import org.bouncycastle.crypto.prng.DigestRandomGenerator;
import org.springframework.stereotype.Service;

@Service(RandomNumberService.NAME)
public class RandomNumberServiceBean implements RandomNumberService {

    protected static final String TEST_VALUE = "HELLO world! It is a test value";

    @Override
    public void run(Algorithm algorithm) {
        switch (algorithm.getInfo()) {
            case RANDOM_NUMBER_GOST3411:
                generateNumber(new GOST3411Digest());
                break;
            case RANDOM_NUMBER_MD2:
                generateNumber(new MD2Digest());
                break;
            case RANDOM_NUMBER_MD4:
                generateNumber(new MD4Digest());
                break;
            case RANDOM_NUMBER_MD5:
                generateNumber(new MD5Digest());
                break;
            case RANDOM_NUMBER_RIPEMD128:
                generateNumber(new RIPEMD128Digest());
                break;
            case RANDOM_NUMBER_RIPEMD160:
                generateNumber(new RIPEMD160Digest());
                break;
            case RANDOM_NUMBER_RIPEMD256:
                generateNumber(new RIPEMD256Digest());
                break;
            case RANDOM_NUMBER_RIPEMD320:
                generateNumber(new RIPEMD320Digest());
                break;
            case RANDOM_NUMBER_SHA1:
                generateNumber(new SHA1Digest());
                break;
            case RANDOM_NUMBER_SHA224:
                generateNumber(new SHA224Digest());
                break;
            case RANDOM_NUMBER_SHA256:
                generateNumber(new SHA256Digest());
                break;
            case RANDOM_NUMBER_SHA384:
                generateNumber(new SHA384Digest());
                break;
            case RANDOM_NUMBER_SHA512:
                generateNumber(new SHA512Digest());
                break;
            case RANDOM_NUMBER_TIGER:
                generateNumber(new TigerDigest());
                break;
            case RANDOM_NUMBER_WHIRLPOOL:
                generateNumber(new WhirlpoolDigest());
                break;
        }
    }

    protected void generateNumber(Digest digest) {
        byte[] input = TEST_VALUE.getBytes();
        digest.update(input, 0, input.length);
        DigestRandomGenerator generator = new DigestRandomGenerator(digest);
        byte[] output = new byte[digest.getDigestSize()];
        int count = 0;
        while (count < 1048576) {
            generator.nextBytes(output);
            count += output.length;
        }
    }
}