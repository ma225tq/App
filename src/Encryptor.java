import javax.xml.stream.events.Characters;

public class Encryptor {

        // Caesar method
    
        public String substituteEncryptString(String string, int key) throws Exception {
            StringBuilder cipher = new StringBuilder();

            // ensure the key is between 0 and 256
    
            if (key < 0 || key > 256) {
                throw new Exception("Key must be between 0 and 256");
            }

            //ensure the key is within the range of the alphabet

            int shift = key % 26;

            // shift the letters by the key, using A as a base, and apppend to the cipher
    
            for (char c : string.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    c = (char) ((c - base + shift) % 26 + base);
                    cipher.append(c);
                } else {
                    cipher.append(c);
                }
            }
    
            return cipher.toString();
        }
    
        public String substituteDecryptString(String string, int key) throws Exception {
    
              if (key < 0 || key > 256) {
                throw new Exception("Key must be between 0 and 256");
            }
            StringBuilder decryptedText = new StringBuilder();

           
            int shift = key % 26;
    
            for (char c : string.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    c = (char) ((c - base - shift + 26) % 26 + base);
                } else {
                    decryptedText.append(c);
                }
                decryptedText.append(c);
            }
    
            return decryptedText.toString();
        }
    
        // transposition method
        public String railFenceEncrypt(String text) {
            StringBuilder topRail = new StringBuilder();
            StringBuilder bottomRail = new StringBuilder();
        
            for (int i = 0; i < text.length(); i++) {
                if (i % 2 == 0) {
                    topRail.append(text.charAt(i));
                } else {
                    bottomRail.append(text.charAt(i));
                }
            }
        
            return topRail.toString() + bottomRail.toString();
        }
        
        
        
    
        public String railFenceDecrypt(String text) {
            StringBuilder decryptedText = new StringBuilder();

            // The length of the text is divided by 2 to get the midpoint
            int mid = text.length() / 2;

            // Characters at even indices are appended to the top rail.
            // Characters at odd indices are appended to the bottom rail. 
        
            for (int i = 0; i < mid; i++) {
                decryptedText.append(text.charAt(i));
                if (i + mid < text.length()) {
                    decryptedText.append(text.charAt(i + mid));
                }
            }
        
            return decryptedText.toString();
        }
        
        
    }

