package ru.job4j.loop;

public class Paint {
    public String piramid(int h) {
        int height = (h + h) - 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < height; j++) {
//                if () {
//                    builder.append("^");
//                } else {
//                    builder.append(" ");
//                }
            }
            builder.append(System.getProperty("line.separator"));
        }
        return builder.toString();
    }
}
