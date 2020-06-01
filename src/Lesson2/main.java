package Lesson2;

public class main {
    public static void main(String[] args) {
        try {
            matrixSum(matrix1);
            matrixSum(matrix2);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    static int MATRIX_SIZE = 4;

    static String [][] matrix1 = new String[][]{
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
    };

    static String [][] matrix2 = new String[][]{
            {"1", "2", "3", "4"},
            {"5", "t", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
    };


    public static void matrixSum(String[][] strings) throws MyArraySizeException, MyArrayDataException{
        int matrixSum = 0;
        int size = strings.length;
        if (size != MATRIX_SIZE) throw new MyArraySizeException("Другой размер матрицы!!!");
        for (int i = 0; i < MATRIX_SIZE; i++){
            if (strings[i].length != MATRIX_SIZE) throw new MyArraySizeException("Другой размер матрицы!!!");
            for (int j = 0; j < MATRIX_SIZE; j++) {
                try {
                    int element = Integer.parseInt(strings[i][j]);
                    matrixSum += element;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(" Неверный элемент в ячейке [" + i + "][" + j + "]" );
                }

            }
        }
        System.out.println("Сумма матрицы равна " + matrixSum);
    }
}

