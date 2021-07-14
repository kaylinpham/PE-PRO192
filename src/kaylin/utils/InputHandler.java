package kaylin.utils;

import kaylin.data.IDuplicate;

import java.util.Scanner;

public class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static int getIntegerInRange(String prompt, int min, int max) {
        int number;

        while (true) {
            try {
                System.out.print(prompt);
                number = Integer.parseInt(scanner.nextLine());
                if (number >= min && number <= max)
                    return number;
            } catch (Exception e) {
                System.out.println("Not an integer!");
            }
        }
    }

    public static String inputNonBlankStr(String prompt) {
        String data;

        do {
            System.out.print(prompt);
            data = scanner.nextLine().trim();
        } while (data.length() == 0);

        return data;
    }


    public static String inputDatePattern(String prompt, String pattern) {
        String data;

        do {
            System.out.print(prompt);
            data = scanner.nextLine().trim();
            if (!data.matches(pattern) || !isValidDate(data)) {
                System.out.println("Incorrect date.");
            }
        } while (!data.matches(pattern) || !isValidDate(data));

        return data;
    }

    public static String noDuplicateAndPattern(IDuplicate isDuplicate, String prompt, String warning, String pattern) {
        String res;
        do {
            res = inputNonBlankStr(prompt);
            if (isDuplicate.isDuplicate(res)) {
                System.out.println(warning);
            }
            if (!pattern.trim().isEmpty() && !res.toUpperCase().matches(pattern.toUpperCase()))
                System.out.println("Incorrect format.");
        } while (isDuplicate.isDuplicate(res) || !res.toUpperCase().matches(pattern.toUpperCase()));
        return res;
    }

    public static boolean isValidDate(String date) {
        String[] elements = date.split("/");
        int dd, mm, yy;
        try {
            dd = Integer.parseInt(elements[0]);
            mm = Integer.parseInt(elements[1]);
            yy = Integer.parseInt(elements[2]);
            if (yy >= 1900 && yy <= 2099) {
                if (mm >= 1 && mm <= 12) {
                    if ((dd >= 1 && dd <= 31) && (mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 || mm == 12))
                        return true;
                    else if ((dd >= 1 && dd <= 30) && (mm == 4 || mm == 6 || mm == 9 || mm == 11))
                        return true;
                    else if ((dd >= 1 && dd <= 28) && (mm == 2))
                        return true;
                    else if (dd == 29 && mm == 2 && (yy % 400 == 0 || (yy % 4 == 0 && yy % 100 != 0)))
                        return true;
                    else
                        return false;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
