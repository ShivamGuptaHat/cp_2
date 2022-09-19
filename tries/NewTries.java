package tries;

import java.util.*;

public class NewTries {
    public static void main(String[] args) {
        String pat1 = "abc";
        String pat2 = "abd";
        List<String> ll = Arrays.asList(pat1, pat2);
        Collections.sort(ll);
        System.out.println(ll.get(0));

    }



    static class Tries{
        public boolean isEnd;
        Tries[] children;
        public Tries(){
            isEnd = false;
            children = new Tries[26];
        }

        public void insert(String word){
            Tries r = this;
            for (int i = 0; i < word.length(); ++i){
                if(r.children[word.charAt(i) - 'a'] == null){
                    r.children[word.charAt(i) - 'a'] = new Tries();
                }
                r = r.children[word.charAt(i) - 'a'];
            }
            r.isEnd = true;
        }

        public boolean search(String word){
            Tries r = this;
            for (int i = 0; i < word.length(); ++i){
                int idx = word.charAt(i) - 'a';
                if(r.children[idx] != null){
                    r = r.children[idx];
                }else{
                    return false;
                }
            }
            return r.isEnd;
        }

        public boolean startsWith(String prefix){
            Tries r = this;
            for (int i = 0; i < prefix.length(); ++i){
                int idx = prefix.charAt(i) - 'a';
                if(r.children[idx] != null){
                    r = r.children[idx];
                }else{
                    return false;
                }
            }
            return true;
        }
    }
}

