package metodosClasses;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Login {
    private final byte[] senhaHash;

    public Login(String senha) {
        this.senhaHash = hash(senha);
    }

    public boolean autenticar(String senhaDigitada) {
        return MessageDigest.isEqual(senhaHash, hash(senhaDigitada));
    }

    /* -------- Helpers -------- */
    private static byte[] hash(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return md.digest(senha.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) { throw new IllegalStateException(e); }
    }
}
