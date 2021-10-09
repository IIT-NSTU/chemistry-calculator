package ChemistryCalculator.frontend;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Formater {
    public static String formatEquation(String equation) {
        String[] subScript = {"\u2080", "\u2081", "\u2082", "\u2083", "\u2084", "\u2085", "\u2086", "\u2087", "\u2088", "\u2089"};
        String[] segments = equation.split("(?<=([A-Za-z])|\\))\\d+");
        Pattern pattern = Pattern.compile("(?<=([A-Za-z])|\\))\\d+");
        Matcher matcher = pattern.matcher(equation);

        StringBuilder output = new StringBuilder();
        int i = 0;
        while (matcher.find()) {
            String group = matcher.group();
            if (group.length() == 1) {
                int number = Integer.parseInt(group);
                output.append(segments[i]).append(subScript[number]);
            } else {

                char[] number = group.toCharArray();
                String result = IntStream.range(0, number.length).mapToObj(j -> subScript[Character.getNumericValue(number[j])]).collect(Collectors.joining());

                output.append(segments[i]).append(result);
            }


            i++;
        }

        while (i < segments.length) {
            output.append(segments[i]);
            i++;
        }


        return output.toString();
    }

}
