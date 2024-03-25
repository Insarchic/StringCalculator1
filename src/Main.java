import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char action;
        String[] parts;
        if (input.contains(" + ")) {
            parts = input.split(" \\+ ");
            action = '+';
        } else if (input.contains(" - ")) {
            parts = input.split(" - ");
            action = '-';
        } else if (input.contains(" * ")) {
            parts = input.split(" \\* ");
            action = '*';
        } else if (input.contains(" / ")) {
            parts = input.split(" / ");
            action = '/';
        } else {
            throw new Exception("Некорректный знак действия");
        }

        if (action == '*' || action == '/') {
            if (parts[1].contains("\"")) {
                throw new Exception("Строчку можно делить или умножать только на число");
            }
              if (Integer.parseInt(parts[1]) > 10 || Integer.parseInt(parts[1]) < 1 ) {
                throw new Exception("На вход принимаются только цифры от 1 до 10");
            }
        }
        if (parts[0].length() > 10) {
            throw new Exception("Калькулятор должен принимать строки длиной не более 10 символов");
        }

        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].replace("\"", "");
        }

        if (action == '+') {
            System.out.println(parts[0] + parts[1]);
        } else if (action == '-') {
            int index = parts[0].indexOf(parts[1]);
            if (index == -1) {
                printInQuotes(parts[0]);
            } else {
                String result = parts[0].substring(0, index);
                result = result + parts[0].substring(index + parts[1].length());
                printInQuotes(result);
            }
        } else if (action == '*') {
            int multi = Integer.parseInt(parts[1]);
            String result = "";
            for (int i = 0; i < multi; i++) {
                result = result + parts[0];
            }
            printInQuotes(result);
        } else {
            int newLength = parts[0].length() / Integer.parseInt(parts[1]);
            String result = parts[0].substring(0, newLength);
            printInQuotes(result);
        }

    }

    private static void printInQuotes(String string) {
         if (string.length() > 40) {
            System.out.println("\""+string.substring(0, 40)+"...\"");
        }
        else {
            System.out.println("\""+string+"\"");
    }

}
