import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        String firstWordList = "";
        String secondWordList = "";

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        String[] firstArray = firstWordList.split(",");
        String[] secondArray = secondWordList.split(",");
        List<String> firstList = Arrays.stream(firstArray).map(s -> {
            if (s.equals("") || isContainNoEnglish(s)) {
                throw new RuntimeException();
            }
            return s.toUpperCase();
        }).distinct().collect(Collectors.toList());

        List<String> secondList = Arrays.stream(secondArray).map(s -> {
            if (s.equals("") || isContainNoEnglish(s)) {
                throw new RuntimeException();
            }
            return s.toUpperCase();
        }).distinct().collect(Collectors.toList());

        firstList.retainAll(secondList);
        List<String> collect = firstList.stream().sorted().map(s -> s.replace("", " ").trim()).collect(Collectors.toList());
        return collect;
    }

    public static boolean isContainNoEnglish(String str) {

        Pattern p = Pattern.compile("[^a-zA-Z\\s]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
}
