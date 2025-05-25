import java.util.Scanner;

public class Main {
    public static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    public static class MyArrayDataException extends Exception {
        public MyArrayDataException(String message) {
            super(message);
        }
    }

    public static void size(int row, int col) throws MyArraySizeException {
        if (row < 4 || col < 4) {
            throw new MyArraySizeException("Размер массива меньше 4x4");
        } else if (row > 4 || col > 4) {
            throw new MyArraySizeException("Размер массива больше 4x4");
        }
    }

    public static int sumRow(String[][] array) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            "Неверные данные в ячейке [" + i + "][" + j + "]: " + array[i][j]);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите количество строк: ");
            int row = scanner.nextInt();
            System.out.print("Введите количество столбцов: ");
            int col = scanner.nextInt();

            size(row, col);

            String[][] array = new String[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print("Введите данные: ");
                    array[i][j] = scanner.next();

                    System.out.println("Текущий массив:");
                    for (int r = 0; r < row; r++) {
                        for (int c = 0; c < col; c++) {
                            if (array[r][c] != null) {
                                System.out.print("[" + array[r][c] + "]");
                            } else {
                                System.out.print("[ ]");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
            }
            System.out.println("Верный размер массива");

            try {
                int total = sumRow(array);
                System.out.println("Сумма значений: " + total);
            } catch (MyArrayDataException e) {
                System.out.println(e.getMessage());
            }

        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
    }
}
