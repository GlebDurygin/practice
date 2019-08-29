package com.company.practice.service;

import com.company.practice.entity.Algorithm;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.signers.DSASigner;
import org.bouncycastle.crypto.signers.RSADigestSigner;
import org.bouncycastle.jce.ECPointUtil;
import org.bouncycastle.jce.provider.DSAUtil;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.stereotype.Service;
import sun.security.provider.DSAPrivateKey;

import java.math.BigInteger;
import java.security.*;
import java.security.spec.*;

@Service(SignerService.NAME)
public class SignerServiceBean implements SignerService {

    protected static final String TEST_VALUE = "HELLO world! It is a test value";

    @Override
    public long run(Algorithm algorithm) {
        switch (algorithm.getInfo()) {
            case SIGNING_DSA:
                return signingDSA();
            case SIGNING_RSA:
                return signingRSA();
            case SIGNING_ECDSA:
                return signingECDSA();
            default:
                return 0;
        }
    }

    protected long signingDSA() {
        DSAPrivateKeySpec PRIVATE_KEY = new DSAPrivateKeySpec(
                // x
                new BigInteger(
                        "15382583218386677486843706921635237927801862255437148328980464126979"),
                // p
                new BigInteger(
                        "181118486631420055711787706248812146965913392568235070235446058914"
                                + "1170708161715231951918020125044061516370042605439640379530343556"
                                + "4101919053459832890139496933938670005799610981765220283775567361"
                                + "4836626483403394052203488713085936276470766894079318754834062443"
                                + "1033792580942743268186462355159813630244169054658542719322425431"
                                + "4088256212718983105131138772434658820375111735710449331518776858"
                                + "7867938758654181244292694091187568128410190746310049564097068770"
                                + "8161261634790060655580211122402292101772553741704724263582994973"
                                + "9109274666495826205002104010355456981211025738812433088757102520"
                                + "562459649777989718122219159982614304359"),
                // q
                new BigInteger(
                        "19689526866605154788513693571065914024068069442724893395618704484701"),
                // g
                new BigInteger(
                        "2859278237642201956931085611015389087970918161297522023542900348"
                                + "0877180630984239764282523693409675060100542360520959501692726128"
                                + "3149190229583566074777557293475747419473934711587072321756053067"
                                + "2532404847508798651915566434553729839971841903983916294692452760"
                                + "2490198571084091890169933809199002313226100830607842692992570749"
                                + "0504363602970812128803790973955960534785317485341020833424202774"
                                + "0275688698461842637641566056165699733710043802697192696426360843"
                                + "1736206792141319514001488556117408586108219135730880594044593648"
                                + "9237302749293603778933701187571075920849848690861126195402696457"
                                + "4111219599568903257472567764789616958430"));
        try {
            DSASigner signer = new DSASigner();
            signer.init(true, new ParametersWithRandom(
                    DSAUtil.generatePrivateKeyParameter(
                            new DSAPrivateKey(PRIVATE_KEY.getX(),
                                    PRIVATE_KEY.getP(),
                                    PRIVATE_KEY.getQ(),
                                    PRIVATE_KEY.getG()))));
            signer.generateSignature(TEST_VALUE.getBytes());
            return Runtime.getRuntime().freeMemory();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return Runtime.getRuntime().freeMemory();
    }

    protected long signingRSA() {
        try {
            Digest digest = new SHA256Digest();
            digest.update(TEST_VALUE.getBytes(), 0, TEST_VALUE.getBytes().length);
            RSADigestSigner signer = new RSADigestSigner(digest);
            RSAKeyParameters lwPubKey = new RSAKeyParameters(
                    true,
                    new BigInteger("b4a7e46170574f16a97082b22be58b6a2a629798419be12872a4bdba626cfae9900f76abfb12139dce5de56564fab2b6543165a040c606887420e33d91ed7ed7", 16),
                    new BigInteger("11", 16));
            signer.init(true, lwPubKey);
            signer.generateSignature();
            return Runtime.getRuntime().freeMemory();
        } catch (CryptoException e) {
            e.printStackTrace();
        }
        return Runtime.getRuntime().freeMemory();
    }

    protected long signingECDSA() {
        try {
            EllipticCurve curve = new EllipticCurve(
                    new ECFieldFp(new BigInteger("883423532389192164791648750360308885314476597252960362792450860609699839")), // q
                    new BigInteger("7fffffffffffffffffffffff7fffffffffff8000000000007ffffffffffc", 16), // a
                    new BigInteger("6b016c3bdcf18941d0d654921475ca71a9db2fb27d1d37796185c2942c0a", 16)); // b

            ECParameterSpec spec = new ECParameterSpec(
                    curve,
                    ECPointUtil.decodePoint(curve, Hex.decode("020ffa963cdca8816ccc33b8642bedf905c3d358573d3f27fbbd3b3cb9aaaf")), // G
                    new BigInteger("883423532389192164791648750360308884807550341691627752275345424702807307"), // n
                    1); // h
            ECPrivateKeySpec priKey = new ECPrivateKeySpec(
                    new BigInteger("876300101507107567501066130761671078357010671067781776716671676178726717"), // d
                    spec);
            Signature sgr = Signature.getInstance("ECDSA", "BC");
            KeyFactory f = KeyFactory.getInstance("ECDSA", "BC");
            PrivateKey sKey = f.generatePrivate(priKey);

            byte[] message = new byte[]{(byte) 'a', (byte) 'b', (byte) 'c'};

            sgr.update(message);

            sgr.initSign(sKey);
            sgr.sign();
            return Runtime.getRuntime().freeMemory();
        } catch (NoSuchAlgorithmException | SignatureException | NoSuchProviderException | InvalidKeySpecException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return Runtime.getRuntime().freeMemory();
    }
}