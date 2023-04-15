
package solution;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("colliding_encoding_sample_ts1_input.txt"));
        

        // read the number of test cases
        int T = scanner.nextInt();

        // process each test case
        for (int testCase = 0; testCase < T; testCase++) {
            // read the mapping
            int[] mapping = new int[26];
            for (int i = 0; i < 26; i++) {
                mapping[i] = scanner.nextInt();
            }

            // read the number of words
            int n = scanner.nextInt();

            // read the words
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = scanner.next();
            }

            // encode the words and check for duplicates
            boolean found = false;
            Set<String> encodings = new HashSet<>();
            for (String word : words) {
                String encoding = encode(word, mapping);
                if (encodings.contains(encoding)) {
                    found = true;
                    break;
                }
                encodings.add(encoding);
            }
            

            // output the result
            System.out.println("Case #" + (testCase + 1) + ": " + (found ? "YES" : "NO"));
        
        }
        
    }

    static String encode(String word, int[] mapping) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append(mapping[word.charAt(i) - 'A']);
        }
        return sb.toString();
    }
}