package ae.dubaitrade.mobile.dubaitradebackendplugin.utils;

public class StringUtils {

    public static String toCamelCase(String str, boolean upperCaseFirst) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder camelCase = new StringBuilder();
        boolean firstChar = true;

        for (char ch : str.toCharArray()) {
            if (Character.isLetterOrDigit(ch) || Character.isUpperCase(ch)) {
                camelCase.append(firstChar ? Character.toLowerCase(ch) : ch);
                firstChar = false;
            } else {
                firstChar = true;
            }
        }

        return camelCase.toString();
    }


    public static String toSnakeCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder snakeCase = new StringBuilder();
        boolean firstChar = true;

        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                if (!firstChar) {
                    snakeCase.append('_');
                }
                snakeCase.append(Character.toLowerCase(ch));
            } else {
                snakeCase.append(ch);
            }
            firstChar = false;
        }

        return snakeCase.toString();
    }

    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        str = str.trim();

        StringBuilder titleCase = new StringBuilder();
        boolean newWord = true;

        for (char ch : str.toCharArray()) {
            if (ch == ' ' || ch == '_' || ch == '-') {
                newWord = true;
            } else {
                if (newWord) {
                    titleCase.append(Character.toUpperCase(ch));
                    newWord = false;
                } else {
                    titleCase.append(Character.toLowerCase(ch));
                }
            }
        }

        return titleCase.toString();
    }
}

