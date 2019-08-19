package tk.madhavareddy.digitaldiary.bcript;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class BCryptPswdGen {
    public static void main(String args[]){
        String hash_php = "$2y$10$ss9kwE8iSIqcJOAPhZR0Y.2XdYXJTFJ1/wGq6SUv74vULE7uhKUIO".replaceFirst("2y", "2a");
        System.out.println("hash php " + hash_php);
        if (BCrypt.checkpw("password", hash_php)) {
            System.out.println("It matches");
        } else {
            System.out.println("It does not match");
        }
    }
}
