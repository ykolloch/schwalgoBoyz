import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    private ArrayList<Integer> last = new ArrayList<>();
    private ArrayList<Integer> test = new ArrayList<>();
    //private int x;

    public static void main(String arg[]) {
        new Test();
    }

    public Test() {
        Scanner input = new Scanner(System.in);
        System.out.println("how big is n?");
        int n = input.nextInt();
        setLast(n);
        setStart(n);
        add(test, last, n - 1);
        System.out.println(System.nanoTime());
    }


    public void setLast(int n) {
        while (n != last.size()) {
            last.add(1);
        }
    }

    public void setStart(int n) {
        while (n != test.size()) {
            test.add(-1);
        }
    }

    public void add(ArrayList<Integer> test, ArrayList<Integer> last, int x) {
        while (!test.equals(last)) {
            if (test.get(x) == -1) {
                test.set(x, 0);
                backwards(test, last, x);
            } else {
                if (test.get(x) == 0) {
                    test.set(x, 1);
                    backwards(test, last, x);
                } else {
                    add(test, last, x - 1);
                }
            }
        }
    }

    public void backwards(ArrayList<Integer> test, ArrayList<Integer> last, int x) {
        if (x != test.size()) {
            int i = x + 1;
            while (i < test.size()) {
                test.set(i, -1);
                i++;
            }
            compare(test);
            add(test, last, test.size() - 1);
        }
    }

    private void compare(ArrayList<Integer> test) {
        int total = 0;
        for (int i = 0; i < test.size(); i++) {
            total = total + test.get(i);
        }
        if (total == 0) {
            out(test);
            System.out.println("");
        }
    }

    private void out(ArrayList<Integer> test) {
        for (int i = 0; i < test.size(); i++) {
            if (test.get(i) == 0) {
                System.out.print("-");
            } else {
                if (test.get(i) == -1) {
                    System.out.print("D");
                } else {
                    System.out.print("U");
                }
            }
        }
    }
}

                                                