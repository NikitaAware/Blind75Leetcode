import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CrosswordPuzzle {
    List<String> crossword;
    String[] words;
    HashSet<String> locationStringToBeFilled;

    CrosswordPuzzle(List<String> crossword, String wordsStr) {
        this.crossword = crossword;
        this.words = wordsStr.split(";");
        this.locationStringToBeFilled = new HashSet<String>();
    }

    public int[][] convertToArray() {
        // size mentioned in the problem
        int[][] crossWordArray = new int[10][10];
        for (int i = 0; i < crossword.size(); i++) {
            String currentRow = crossword.get(i);
            for (int j = 0; j < currentRow.length(); j++) {
                // find positions to be filled
                if (currentRow.charAt(j) == '-') {
                    crossWordArray[i][j] = 1;
                    locationStringToBeFilled.add("(" + i + "," + j + ")");
                }
            }
        }
        return crossWordArray;
    }

    public List<List<int[]>> getWordLocations() {
        List<List<int[]>> wordLocations = new ArrayList<List<int[]>>();
        int[][] crossWordArray = convertToArray();
        // find the word locations in the rows
        List<int[]> prev = new ArrayList<int[]>();
        for (int i = 0; i < crossWordArray.length; i++) {
            for (int j = 0; j < crossWordArray[0].length; j++) {
                if (crossWordArray[i][j] == 1) {
                    int[] location = new int[] { i, j };
                    prev.add(location);
                } else {
                    if (prev.size() > 1) {
                        wordLocations.add(prev);
                    }
                    prev = new ArrayList<int[]>();
                }
            }
        }
        // find the word locations in the column
        prev = new ArrayList<int[]>();
        for (int i = 0; i < crossWordArray[0].length; i++) {
            for (int j = 0; j < crossWordArray.length; j++) {
                if (crossWordArray[j][i] == 1) {
                    int[] location = new int[] { j, i };
                    prev.add(location);
                } else {
                    if (prev.size() > 1) {
                        wordLocations.add(prev);
                    }
                    prev = new ArrayList<int[]>();
                }
            }
        }
        return wordLocations;
    }

    public char[][] fill() {
        List<List<int[]>> wordLocations = getWordLocations();
        char[][] filledArray = new char[10][10];
        char[][] res = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                res[i][j] = '+';
                filledArray[i][j] = '+';
            }
        }
        fillHelper(wordLocations, filledArray, res, 0, new HashSet<Integer>(), new HashSet<String>());

        return res;
    }

    public void fillHelper(List<List<int[]>> wordLocations, char[][] currArray, char[][] res, int pos,
            HashSet<Integer> vis, HashSet<String> filledLocations) {
        if (filledLocations.size() == locationStringToBeFilled.size()) {
            res = currArray;
            return;
        }
        if (pos >= words.length) {
            res = currArray;
            return;
        }
        String currentWord = words[pos];
        for (int i = 0; i < wordLocations.size(); i++) {
            if (vis.contains(i)) {
                continue;
            }
            char[][] filledArray = currArray.clone();
            List<int[]> currWordLocation = wordLocations.get(i);
            HashSet<String> currentFilledLocations = (HashSet<String>) filledLocations.clone();
            // length matches
            if (currWordLocation.size() == currentWord.length()) {
                boolean success = true;
                // try to fill the word in
                for (int j = 0; j < currentWord.length(); j++) {
                    int row = currWordLocation.get(j)[0];
                    int column = currWordLocation.get(j)[1];
                    if (filledArray[row][column] != '+') {
                        if (filledArray[row][column] != currentWord.charAt(j)) {
                            success = false;
                            break;
                        }
                    } else {
                        filledArray[row][column] = currentWord.charAt(j);
                        currentFilledLocations.add("(" + row + "," + column + ")");
                    }
                }
                if (success) {
                    HashSet<Integer> newVis = (HashSet<Integer>) vis.clone();
                    newVis.add(i);
                    fillHelper(wordLocations, filledArray, res, pos + 1, newVis, currentFilledLocations);
                }
            }
        }
    }

    public void result() {
        char[][] res = fill();
        for (int i = 0; i < res.length; i++) {
            System.out.println();
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]);
            }
        }

    }
}