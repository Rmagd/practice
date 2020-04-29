import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class mainTest {

  /**
   * print object
   */
  public static void print(int index, Object obj) {
    System.out.println(String.format("{%d}, %s", index, obj.toString()));
  }

  public static void demoOperation() {
    print(1, 5 / 2.0);
    print(2, 5 + 2);
    print(3, 5 * 2);
    print(4, 5 - 2);
    print(5, 5 << 2);
    print(6, 5 >> 2);
    print(7, 5 & 2);  //0x101 0x010
    print(8, 5 | 2);
    print(9, 5 ^ 2);
    print(10, 5 == 2);
    print(11, 5 != 2);
    int a = 2;
    double b = 2.0;
    a += 2;
    b = b + 1.2333;
    print(12, b);
    DecimalFormat df = new DecimalFormat("0.01");
    print(13, df.format(b)); //keep two decimals
    //char, float, String
  }

  public static void demoControlFlow() {
    int score = 65;
    if (score > 80) {
      print(1, 'A');

    } else if (score > 60) {
      print(2, 'B');

    } else {
      print(3, 'C');

    }
    String grade = "B";
    switch (grade) {
      case "A":
        print(4, "score > 80");
        break;
      case "B":
        print(5, "score > 60");
        break;
      case "C":
        print(6, "score < 60");
        break;
    }
    for (int i = 0; i < 6; i++) {
      if (i == 1) {
        continue;
      }
      if (i == 5) {
        break;
      }
      if (i % 2 == 1) {
        print(8, "i%2=1");
      }
      print(7, i);
    }
    String str = "hello";
    for (char c : str.toCharArray()) {
      print(9, c);
    }
    int target = 20;
    int current = 0;
    while (current < target) {
      current += 5;
      print(10, current);
      if (current == 10) {
        break;
      }
    }
  }

  public static void demoString() {
    String str = "hello nowcoder";
    print(1, str.indexOf('e'));
    print(2, str.charAt(5));
    print(3, str.codePointAt(1));
    print(4, str.compareTo("hello nowcoder"));
    print(5, str.compareTo("hello f"));
    print(6, str.compareToIgnoreCase("HELLO noWcoder"));
    print(7, str.concat("ASD"));
    print(8, str.contains("hello"));
    print(9, str.endsWith("der"));
    print(10, str.startsWith("h"));
    print(11, str.lastIndexOf('o'));
    print(12, str.toUpperCase());
    print(13, str.replace('l', '1'));
    print(14, str.replaceAll("o|e", "bdsd"));
    print(15, str.replaceAll("hello", "hi"));

    StringBuilder sb = new StringBuilder();
    sb.append("hello");
    StringBuilder world = sb.append("world");
    sb.append(true);
    sb.append(1);
    print(16, sb);
    print(17, "a" + "b" + String.valueOf(124));

  }

  public static void demoList() {
    List<String> strlist = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      strlist.add(String.valueOf(i));
    }
    print(1, strlist);
    List<String> strlistB = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      strlistB.add(String.valueOf(i * i));
    }
    print(2, strlistB);
    strlist.addAll(strlistB);
    strlist.remove(4);
    print(3, strlist);
    strlist.remove(String.valueOf(9));
    print(4, strlist);
    print(5, strlist.get(1));

    Collections.sort(strlist);
    print(6, strlist);
    Collections.sort(strlist, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o2.compareTo(o1);
      }
    });
    print(7, strlist);
    Collections.reverse(strlist);
    print(8, strlist);

    int[] array = new int[]{1, 2, 3};
    print(9, array[1]);
  }

  public static void demoSet() {
    Set<String> strSet = new HashSet<String>();
    for (int i = 0; i < 3; i++) {
      strSet.add(String.valueOf(i));
      strSet.add(String.valueOf(i));
      strSet.add(String.valueOf(i));
      strSet.add(String.valueOf(i));
    }
    print(1, strSet);
    strSet.remove("1");
    print(2, strSet);
    print(3, strSet.contains(4));
    strSet.addAll(Arrays.asList(new String[]{"B", "c", "C"}));
    print(4, strSet);
    for (String value : strSet) {
      print(5, value);
    }
    print(6, strSet.isEmpty());
    print(7, strSet.size());
  }

  public static void demoKeyValue() {
    Map<String, String> map = new HashMap();
    for (int i = 0; i < 4; i++) {
      map.put(String.valueOf(i), String.valueOf(i * i));
    }
    print(1, map);
    for (Map.Entry<String, String> entry : map.entrySet()) {
      print(2, entry.getKey() + ":" + entry.getValue());
    }
    print(3, map.entrySet());
    print(4, map.keySet());
    print(5, map.values());
    map.replace("1", "a");
    print(7, map);
  }

  public static void demoException() {
    try {
      print(1, "hello");
      int a = 2;
//      a = a / 0;
      String b = null;
      b.indexOf('a');

    } catch (NullPointerException npe) {
      print(3, "NPE");

    } catch (Exception e) {
      print(4, "Exception");

    } finally {
      print(2, "finally");
    }
  }

  public static void demoCommon() {
    Random random = new Random();
//    random.setSeed();
    DecimalFormat df = new DecimalFormat("0.000");
    for (int i = 0; i < 5; i++) {
      print(1, random.nextInt(100));
      print(2, df.format(200 * random.nextDouble()));


    }
    List<Integer> array = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});
    print(3, array);
    Collections.shuffle(array);
    print(4, array);

    Date date = new Date();
    print(5, date);
    print(6, date.getTime());
    DateFormat datef = new SimpleDateFormat("hh:mm:ss yy/mm/dd");
    print(7, datef.format(date));
    print(8, DateFormat.getDateInstance(DateFormat.FULL).format(date));

    print(9, UUID.randomUUID());
    print(10, Math.max(1, 2));
    print(11, Math.ceil(2.1));
    print(12, Math.floor((2.1)));
    print(13, Math.log(2.7));


  }

  public static void main(String[] args) {
    //demoOperation();
    //demoControlFlow();
    //demoString();
    //demoList();
//    demoSet();
//    demoKeyValue();
//      demoException();
//      demoCommon();

  }

}
