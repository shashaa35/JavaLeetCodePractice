package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/word-ladder-ii/
public class WordLadder2 {
    int ansTillNow[];
    boolean wordSelected[];
    int curLadderSize;
    List<List<String>> listOfAns;
    int minLadderSize;
    Map<String , List<String>> map;
    Map<String, Integer> indexMap;
    String beginWord;

    public static void main(String[] args) {
        WordLadder2 obj = new WordLadder2();
//        System.out.println(obj.isAtOneDistance("hot", "hit"));
//        System.out.println(obj.isAtOneDistance("hot", "sait"));
//        System.out.println(obj.isAtOneDistance("hot", "sit"));
//        System.out.println(obj.isAtOneDistance("hot", "hot"));
//        System.out.println(obj.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
//        System.out.println(obj.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(obj.findLadders("qa", "sq", Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye")));
    }

    private boolean isAtOneDistance(String w1, String w2) {
        if (w1.length() != w2.length())
            return false;
        int count = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                count++;
            }
            if (count > 1)
                return false;
        }
        if (count == 1)
            return true;
        return false;
    }

    private void printLadder(List<String> wordList) {
        System.out.println("Ans length is " + curLadderSize);
        for (int i = 0; i < ansTillNow.length && ansTillNow[i] != -1; i++) {
            System.out.printf("%s ", wordList.get(ansTillNow[i]));
        }
        System.out.println();
    }

    private void saveLadder(List<String> wordList) {
        if (curLadderSize > minLadderSize) {
            return;
        }

        List<String> ladder = new ArrayList<>();
        ladder.add(beginWord);
        for (int i = 0; i < ansTillNow.length && ansTillNow[i] != -1; i++) {
            ladder.add(wordList.get(ansTillNow[i]));
        }

        if (curLadderSize == minLadderSize) {
            //add this ladder
            listOfAns.add(ladder);
        }

        if (curLadderSize < minLadderSize) {
            minLadderSize = curLadderSize;
            listOfAns.clear();
            listOfAns.add(ladder);
        }
    }

    private void populateMap(List<String> wordList) {
        map = new HashMap<>();
        indexMap = new HashMap<>();
        map.put(beginWord, new ArrayList<>());
        for (int i = 0;i<wordList.size();i++) {
            map.put(wordList.get(i), new ArrayList<>());
            indexMap.put(wordList.get(i), i);
        }

        for (int j =0;j<wordList.size();j++) {
            String b = wordList.get(j);
            if (isAtOneDistance(beginWord, b)) {
                map.get(beginWord).add(b);
            }
        }

        for (int i = 0;i < wordList.size()-1;i++) {
            String a = wordList.get(i);
            for (int j = i+1;j<wordList.size();j++) {
                String b = wordList.get(j);
                if (isAtOneDistance(a, b)) {
                    map.get(a).add(b);
                    map.get(b).add(a);
                }
            }
        }
    }

    private void checkAndReturn(String beginWord, String endWord, List<String> wordList) {
//        printLadder(wordList);
        if (beginWord.equals(endWord)) {
            saveLadder(wordList);
            printLadder(wordList);
            return;
        }

        if (curLadderSize > minLadderSize) {
            return;
        }

        List<String> listOfWordsReachable = map.get(beginWord);
        for (int i = 0; i < listOfWordsReachable.size(); i++) {
            String word = listOfWordsReachable.get(i);
            int indexOfWord = indexMap.get(word);
            if (!wordSelected[indexOfWord]) {
                ansTillNow[curLadderSize] = indexOfWord;
                curLadderSize++;
                wordSelected[indexOfWord] = true;
                checkAndReturn(word, endWord, wordList);
                curLadderSize--;
                ansTillNow[curLadderSize] = -1;
                wordSelected[indexOfWord] = false;
            }
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return new ArrayList<List<String>>();
        ansTillNow = new int[wordList.size()];
        Arrays.fill(ansTillNow, -1);
        curLadderSize = 0;
        wordSelected = new boolean[wordList.size()];
        listOfAns = new ArrayList<List<String>>();
        minLadderSize = wordList.size() + 1;
        this.beginWord = beginWord;
        populateMap(wordList);
        checkAndReturn(beginWord, endWord, wordList);
        return listOfAns;
    }
}
