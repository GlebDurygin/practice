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
    public long run(Algorithm algorithm) {
        switch (algorithm.getInfo()) {
            case RANDOM_NUMBER_GOST3411:
                return generateNumber(new GOST3411Digest());
            case RANDOM_NUMBER_MD2:
                return generateNumber(new MD2Digest());
            case RANDOM_NUMBER_MD4:
                return generateNumber(new MD4Digest());
            case RANDOM_NUMBER_MD5:
                return generateNumber(new MD5Digest());
            case RANDOM_NUMBER_RIPEMD128:
                return generateNumber(new RIPEMD128Digest());
            case RANDOM_NUMBER_RIPEMD160:
                return generateNumber(new RIPEMD160Digest());
            case RANDOM_NUMBER_RIPEMD256:
                return generateNumber(new RIPEMD256Digest());
            case RANDOM_NUMBER_RIPEMD320:
                return generateNumber(new RIPEMD320Digest());
            case RANDOM_NUMBER_SHA1:
                return generateNumber(new SHA1Digest());
            case RANDOM_NUMBER_SHA224:
                return generateNumber(new SHA224Digest());
            case RANDOM_NUMBER_SHA256:
                return generateNumber(new SHA256Digest());
            case RANDOM_NUMBER_SHA384:
                return generateNumber(new SHA384Digest());
            case RANDOM_NUMBER_SHA512:
                return generateNumber(new SHA512Digest());
            case RANDOM_NUMBER_TIGER:
                return generateNumber(new TigerDigest());
            case RANDOM_NUMBER_WHIRLPOOL:
                return generateNumber(new WhirlpoolDigest());
            default:
                return 0;
        }
    }

    protected long generateNumber(Digest digest) {
        byte[] input = TEST_VALUE.getBytes();
        digest.update(input, 0, input.length);
        DigestRandomGenerator generator = new DigestRandomGenerator(digest);
        byte[] output = new byte[digest.getDigestSize()];
        int count = 0;
        while (count < 1048576) {
            generator.nextBytes(output);
            count += output.length;
        }
        return Runtime.getRuntime().freeMemory();
    }
}