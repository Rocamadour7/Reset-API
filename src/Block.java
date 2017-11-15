import java.nio.CharBuffer;
import java.security.Timestamp;

public class Block {

    private int index;
    private Candidate data;
    private Timestamp timestamp;
    private String hash;
    private String previousHash;

    public Block(int index, Candidate data, String previousHash) {
        this.index = index;
        this.data = data;
        this.previousHash = previousHash;
    }

    private String calculateHash() {
        // TODO return hash
        return null;
    }

    private void mineBlock(int difficulty) {
        String checkString = CharBuffer.allocate(difficulty).toString().replace('\0', '0');
        while(!this.hash.substring(0, difficulty).equals(checkString)){
            // TODO check and create a nonce variable
        }
    }


}
