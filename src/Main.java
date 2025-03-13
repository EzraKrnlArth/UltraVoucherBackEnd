import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] words = {"cook", "save", "taste", "aves", "vase", "state", "map"};
        List<List<String>> result = anagramCari(words);

        for (List<String> group : result) {
            System.out.println(group);
        }
    }

    public static List<List<String>> anagramCari(String[] words) {
        List<List<String>> grup = new ArrayList<>();
        boolean[] visited = new boolean[words.length];

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }

            List<String> group = new ArrayList<>();
            group.add(words[i]);
            visited[i] = true;

            for (int j = i + 1; j < words.length; j++) {
                if (!visited[j] && isAnagram(words[i], words[j])) {
                    group.add(words[j]);
                    visited[j] = true;
                }
            }

            grup.add(group);
        }

        return grup;
    }

    public static boolean isAnagram(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}