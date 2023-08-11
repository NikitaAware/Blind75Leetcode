// There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

// For example,
// Given the following words in dictionary,

// [
// "wrt",
// "wrf",
// "er",
// "ett",
// "rftt"
// ]
// The correct order is: "wertf".
package Graph;

import java.util.HashMap;
import java.util.HashSet;

public class AlienDictionary {
    String[] sortedWords;
    HashSet<Character> covered;
    HashMap<Character, HashSet<Character>> dependencies;
    String res;
    public AlienDictionary(String[] sortedWords) {
        this.sortedWords = sortedWords;
        // create a dependency map first 
        this.dependencies = new HashMap<Character, HashSet<Character>>();
        this.covered = new HashSet<Character>();
        this.res = "";
    }

    public void getDependencies() {
        for (int i = 0; i < sortedWords.length; i++) {
            String word = sortedWords[i];
            HashSet<Character> dependency = new HashSet<Character>();
            for (int j = 0; j < word.length(); j++) {
                HashSet<Character> tmp = dependencies.getOrDefault(word.charAt(j), new HashSet<Character>());
                tmp.addAll(dependency);
                tmp.remove(word.charAt(j));
                dependencies.put(word.charAt(j), tmp);
                dependency.add(word.charAt(j)); // for the next char this would be a dependency
            }
        }
        System.out.println(dependencies);
    }
    public void order() {
        getDependencies();
        DFS();
        System.out.println(res);
    }
    public void DFS() {
        for (char c: dependencies.keySet()) {
            if (covered.contains(c)) {
                continue;
            }
            HashSet<Character> dependency = dependencies.get(c);
            dependency.removeAll(covered);
            if (dependency.size() == 0) {
                res = res + c;
                covered.add(c);
            } else {
                dependencies.put(c, dependency);
            }
        }
        if (covered.size() != dependencies.keySet().size()) {
            DFS();
        }
    }
}
/**
 * 
 * 
 * e -  w - r - f - t
 */