package com.company.practice.service;

import com.company.practice.entity.Algorithm;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
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

import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.*;

@Service(VerifierService.NAME)
public class VerifierServiceBean implements VerifierService {

    @Override
    public void run(Algorithm algorithm) {
        switch (algorithm.getInfo()) {
            case VERIFYING_DSA:
                verifyingDSA();
                break;
            case VERIFYING_RSA:
                verifyingRSA();
                break;
            case VERIFYING_ECDSA:
                verifyingECDSA();
                break;
            default:
                break;
        }
    }

    private void verifyingDSA() {
        try {
            DSAParameterSpec dsaParams = new DSAParameterSpec(
                    new BigInteger(
                            "F56C2A7D366E3EBDEAA1891FD2A0D099" +
                                    "436438A673FED4D75F594959CFFEBCA7BE0FC72E4FE67D91" +
                                    "D801CBA0693AC4ED9E411B41D19E2FD1699C4390AD27D94C" +
                                    "69C0B143F1DC88932CFE2310C886412047BD9B1C7A67F8A2" +
                                    "5909132627F51A0C866877E672E555342BDF9355347DBD43" +
                                    "B47156B2C20BAD9D2B071BC2FDCF9757F75C168C5D9FC431" +
                                    "31BE162A0756D1BDEC2CA0EB0E3B018A8B38D3EF2487782A" +
                                    "EB9FBF99D8B30499C55E4F61E5C7DCEE2A2BB55BD7F75FCD" +
                                    "F00E48F2E8356BDB59D86114028F67B8E07B127744778AFF" +
                                    "1CF1399A4D679D92FDE7D941C5C85C5D7BFF91BA69F9489D" +
                                    "531D1EBFA727CFDA651390F8021719FA9F7216CEB177BD75", 16),
                    new BigInteger("C24ED361870B61E0D367F008F99F8A1F75525889C89DB1B673C45AF5867CB467", 16),
                    new BigInteger(
                            "8DC6CC814CAE4A1C05A3E186A6FE27EA" +
                                    "BA8CDB133FDCE14A963A92E809790CBA096EAA26140550C1" +
                                    "29FA2B98C16E84236AA33BF919CD6F587E048C52666576DB" +
                                    "6E925C6CBE9B9EC5C16020F9A44C9F1C8F7A8E611C1F6EC2" +
                                    "513EA6AA0B8D0F72FED73CA37DF240DB57BBB27431D61869" +
                                    "7B9E771B0B301D5DF05955425061A30DC6D33BB6D2A32BD0" +
                                    "A75A0A71D2184F506372ABF84A56AEEEA8EB693BF29A6403" +
                                    "45FA1298A16E85421B2208D00068A5A42915F82CF0B858C8" +
                                    "FA39D43D704B6927E0B2F916304E86FB6A1B487F07D8139E" +
                                    "428BB096C6D67A76EC0B8D4EF274B8A2CF556D279AD267CC" +
                                    "EF5AF477AFED029F485B5597739F5D0240F67C2D948A6279", 16)
            );

            String TEST_VALUE = "HELLO world! It is a test value";

            KeyFactory f = KeyFactory.getInstance("DSA", "BC");
            PublicKey publicKey = f.generatePublic(new DSAPublicKeySpec(BigInteger.valueOf(1), dsaParams.getP(), dsaParams.getG(), dsaParams.getQ()));

            DSASigner signer = new DSASigner();
            signer.init(true, new ParametersWithRandom(DSAUtil.generatePublicKeyParameter(publicKey)));
            ASN1Sequence s = (ASN1Sequence) ASN1Object.fromByteArray(publicKey.getEncoded());
            BigInteger[] sign = new BigInteger[]{
                    ((DERInteger) s.getObjectAt(0)).getValue(),
                    ((DERInteger) s.getObjectAt(1)).getValue()
            };
            signer.verifySignature(TEST_VALUE.getBytes(), sign[0], sign[1]);
        } catch (IOException | NoSuchAlgorithmException | InvalidKeyException | InvalidKeySpecException | NoSuchProviderException e) {
            e.printStackTrace();
        }
    }

    private void verifyingRSA() {
        try {
            String TEST_VALUE = "HELLO world! It is a test value";
            Digest digest = new SHA256Digest();
            digest.update(TEST_VALUE.getBytes(), 0, TEST_VALUE.getBytes().length);
            RSADigestSigner signer = new RSADigestSigner(digest);
            RSAKeyParameters lwPubKey = new RSAKeyParameters(
                    true,
                    new BigInteger("b4a7e46170574f16a97082b22be58b6a2a629798419be12872a4bdba626cfae9900f76abfb12139dce5de56564fab2b6543165a040c606887420e33d91ed7ed7", 16),
                    new BigInteger("11", 16));
            signer.init(true, lwPubKey);
            byte[] sign = signer.generateSignature();
            signer.verifySignature(sign);
        } catch (CryptoException e) {
            e.printStackTrace();
        }
    }

    private void verifyingECDSA() {
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
            ECPublicKeySpec pubKey = new ECPublicKeySpec(
                    ECPointUtil.decodePoint(curve, Hex.decode("025b6dc53bc61a2548ffb0f671472de6c9521a9d2d2534e65abfcbd5fe0c70")), // Q
                    spec);
            ECPrivateKeySpec priKey = new ECPrivateKeySpec(
                    new BigInteger("876300101507107567501066130761671078357010671067781776716671676178726717"), // d
                    spec);
            Signature sgr = Signature.getInstance("ECDSA", "BC");
            KeyFactory f = KeyFactory.getInstance("ECDSA", "BC");
            PublicKey vKey = f.generatePublic(pubKey);
            PrivateKey sKey = f.generatePrivate(priKey);

            byte[] message = new byte[]{(byte) 'a', (byte) 'b', (byte) 'c'};

            sgr.update(message);

            sgr.initSign(sKey);
            byte[] signed = sgr.sign();

            sgr.initVerify(vKey);
            sgr.verify(signed);
        } catch (NoSuchAlgorithmException | SignatureException | NoSuchProviderException | InvalidKeySpecException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }
}