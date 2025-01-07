package interviewCodingTasks;

import org.junit.jupiter.api.Test;

import java.util.List;

public class AreaOfTriangleTests {
    //https://docs.google.com/document/d/1odwyexzXU4jWIl-cpo1z2NN-mqgSLfjN33ziTBO7lpg/edit?tab=t.0#heading=h.wam8hug7ch38

    @Test
    void test() {
        int area = getTriangleArea(List.of(0, 4, 7), List.of(0, 8, 6));
        System.out.println("Area: " + area);
    }

    /*
     * x and y - INTEGER_ARRAY
     */
    public static int getTriangleArea(List<Integer> x, List<Integer> y) {
        /*
        1. Расчитать длины сторон
        2. Найти наибольшую стороны - это будет наше основание
        3. Вычисляем высоту треугольника через уравнение прямой
        4. Вычисляем площадь
         */
        if (x.size() != 3 || y.size() != 3) {
            throw new IllegalArgumentException("Требуется список из трех координат для каждой оси");
        }

        // Координаты вершин
        int x1 = x.get(0), y1 = y.get(0);
        int x2 = x.get(1), y2 = y.get(1);
        int x3 = x.get(2), y3 = y.get(2);

        // Длины сторон
        double sideAB = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double sideBC = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double sideAC = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));

        // Определяем наибольшую сторону
        double base = Math.max(sideAB, Math.max(sideBC, sideAC));
        int baseX1, baseY1, baseX2, baseY2; // Координаты концов основания
        int oppositeX, oppositeY;           // Координаты вершины напротив основания

        if (base == sideAB) {
            baseX1 = x1; baseY1 = y1;
            baseX2 = x2; baseY2 = y2;
            oppositeX = x3; oppositeY = y3;
        } else if (base == sideBC) {
            baseX1 = x2; baseY1 = y2;
            baseX2 = x3; baseY2 = y3;
            oppositeX = x1; oppositeY = y1;
        } else {
            baseX1 = x1; baseY1 = y1;
            baseX2 = x3; baseY2 = y3;
            oppositeX = x2; oppositeY = y2;
        }

        // Уравнение прямой: A * x + B * y + C = 0
        double A = baseY2 - baseY1;
        double B = baseX1 - baseX2;
        double C = -A * baseX1 - B * baseY1;

        // Вычисляем высоту
        double height = Math.abs(A * oppositeX + B * oppositeY + C) / Math.sqrt(A * A + B * B);

        // Вычисляем площадь
        double area = 0.5 * base * height;

        // Возвращаем целое значение площади
        return (int) Math.round(area);
    }
}
