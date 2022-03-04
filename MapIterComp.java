import java.util.Map;
import java.util.HashMap;

public class MapIterComp {
    
    private static int size = 10000, round = 5;
    private static long sum, start, end;

    private static void print(String name, long value) {

        System.out.print(String.format("%-20s: ", name));
        System.out.print(String.format("%5d", (end - start)));
        System.out.println(" ms");
    }

    private static void compare() {

        final Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < size; i++) map.put(i, i);

        System.out.println("[size]: " + size);
        System.out.println("[round]: " + round);
        
        // 1. key set for loop
        sum = 0;
        for (int i = 0; i < round; i++) {

            start = System.currentTimeMillis();
            for (Integer key: map.keySet()) sum += map.get(key);
            end = System.currentTimeMillis();
            sum += (end - start);
        }
        print("keySet() for", sum/round);

        // 2. key set for each
        sum = 0;
        for (int i = 0; i < round; i++) {

            start = System.currentTimeMillis();
            map.keySet().forEach(k -> sum += map.get(k));
            end = System.currentTimeMillis();
            sum += (end - start);
        }
        print("keySet() forEach", sum/round);

        // 3. entry set for loop
        sum = 0;
        for (int i = 0; i < round; i++) {

            start = System.currentTimeMillis();
            for (Map.Entry<Integer, Integer> e: map.entrySet()) sum += e.getValue();
            end = System.currentTimeMillis();
            sum += (end - start);
        }
        print("entrySet() for", sum/round);

        // 4. entry set for each
        sum = 0;
        for (int i = 0; i < round; i++) {

            start = System.currentTimeMillis();
            map.entrySet().forEach(e -> sum += e.getValue());
            end = System.currentTimeMillis();
            sum += (end - start);
        }
        print("entrySet() forEach", sum/round);

        // 5. values for loop
        sum = 0;
        for (int i = 0; i < round; i++) {

            start = System.currentTimeMillis();
            for (Integer value: map.values()) sum += value;
            end = System.currentTimeMillis();
            sum += (end - start);
        }
        print("values() for", sum/round);
        
        // 6. values for each
        sum = 0;
        for (int i = 0; i < round; i++) {

            start = System.currentTimeMillis();
            map.values().forEach(v -> sum += v);
            end = System.currentTimeMillis();
            sum += (end - start);
        }
        print("values() for each", sum/round);
        
        // 7. for each
        sum = 0;
        for (int i = 0; i < round; i++) {

            start = System.currentTimeMillis();
            map.forEach((k, v) -> sum += v);
            end = System.currentTimeMillis();
            sum += (end - start);
        }
        print("for each", sum/round);
    }

    public static void main(String[] args) {
        
        if (args.length == 2) {

            size = Integer.valueOf(args[0]);
            round = Integer.valueOf(args[1]);
        }

        if (args.length == 1) size = Integer.valueOf(args[0]);

        compare();
    }
}
