public class Leet {

    public static String toLeet(String normal) {
        if (normal.contains("elite")) normal = normal.replace("elite", "1337");
        if (normal.contains("cool")) normal = normal.replace("cool", "k3wl");
        if (normal.contains("!")) normal = normal.replace("!", "!!!11");
        if (normal.contains("ck")) normal = normal.replace("ck", "xx");
        if (normal.contains("ers")) normal = normal.replace("ers", "0rz");
        if (normal.contains("er")) normal = normal.replace("er", "0rz");
        if (normal.contains("en")) normal = normal.replace("en", "n");
        if (normal.contains("e")) normal = normal.replace("e", "3");
        if (normal.contains("t")) normal = normal.replace("t", "7");
        if (normal.contains("o")) normal = normal.replace("o", "0");
        if (normal.contains("a")) normal = normal.replace("a", "@");
        return normal;
    }

    public static String[] allToLeet(String[] normals) {

        String[] dict = new String[normals.length];
        for (int i = 0; i < normals.length; i++)
            for (int j = 0; j < normals[i].length(); j++)
                dict[i] = toLeet(normals[i]);
        return dict;
    }
}