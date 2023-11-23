
    public class Encryptor {

        // Caesar method
    
        public String substituteEncryptString(String string, int key) throws Exception {
            StringBuilder cipher = new StringBuilder();
    
            if (key < 0 || key > 256) {
                throw new Exception("Key must be between 0 and 256");
            }
    
    
            int shift = key;
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
            int mid = text.length() / 2;
        
            for (int i = 0; i < mid; i++) {
                decryptedText.append(text.charAt(i));
                if (i + mid < text.length()) {
                    decryptedText.append(text.charAt(i + mid));
                }
            }
        
            return decryptedText.toString();
        }
        
        
    }

