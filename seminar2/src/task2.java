public class task2 {

    public static void main(String[] args) {
        String text = "aaababybabaaa";
        // StringBuilder result = new StringBuilder();
        // int count = 1;
        // String var1, var2;
        // for (int i = 0; i < text.length() - 1; i++) {
        // var1 = text.substring(i, i + 1);
        // var2 = text.substring(i + 1, i + 2);

        // if (var1.equals(var2)) {
        // count += 1;
        // } else {
        // result = result.append(count).append(var1);
        // count = 1;
        // }
        // }
        // System.out.println(result.toString());
        Boolean isPolindrom = false;
        for (int i = 0; i < text.length() / 2; i++) {
            if (text.charAt(i) == text.charAt(text.length()-i-1)) {

                isPolindrom = true;
            } else {
                isPolindrom = false;
                break;
            }

        }
        System.out.println(isPolindrom);

    }
}