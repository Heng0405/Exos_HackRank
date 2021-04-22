package fabernovel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SierpinskiTriangles {

    public static int COLUMNS = 63;

    public List<String> draw(int N, int rows) {
        List<String> list = new ArrayList<>();
        if (N == 0) {
            for (int i = 1; i <= rows; i++) {
                StringBuilder stringBuilder = new StringBuilder(COLUMNS);
                for (int j = rows - i; j > 0; j--) {
                    stringBuilder.append("_");
                }
                for (int k = 1; k <= 2 * i - 1; k++) {
                    stringBuilder.append("1");
                }
                for (int l = rows - i; l > 0; l--) {
                    stringBuilder.append("_");
                }
                list.add(stringBuilder.toString());
            }
        } else {
            List<String> list0 = draw(N-1 ,rows/2);
            for (int i = 0; i < rows/2 ; i++) {
                StringBuilder stringBuilder = new StringBuilder(COLUMNS);
                for (int j = 1; j <= rows/2 ; j++) {
                    stringBuilder.append("_");
                }
                stringBuilder.append(list0.get(i));
                for (int j = 1; j <= rows/2 ; j++) {
                    stringBuilder.append("_");
                }
                list.add(stringBuilder.toString());
            }
            list.addAll(list0.stream().map(e -> e+"_"+e).collect(Collectors.toList()));
        }
        return list;
    }

    public void print(List<String> list) {
        list.forEach(System.out::println);
    }


    public static void main(String[] args) {
        SierpinskiTriangles sierpinskiTriangles = new SierpinskiTriangles();
        List<String> list = sierpinskiTriangles.draw(2,32);
        System.out.println(list.size());
        System.out.println(list.get(0).length());
        sierpinskiTriangles.print(list);
    }

}
