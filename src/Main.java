

public class Main {

    public static void main(String[] args) {
        Task t1 = new Task(1, 1);
        Task t2 = new Task(2, 2);
        Task t3 = new Task(3, 3);
        Task t4 = new Task(4, 4);
        Task t5 = new Task(5, 5);
        Task t6 = new Task(0, 5);

        MyList<Task> arr = new MyList<>();
        arr.add(t1);
        arr.add(t2);
        arr.add(t5);
        arr.add(t3);
        arr.add(t4);
        // arr.add(t5);
        arr.add(t5);
        arr.add(t5);
        MyList arr1 = new MyList(arr);
        arr.add(new Task(10, 1));

        arr1.remove(0);

        arr1.add(new Task(10, 1));
        //arr1.add(t1);

        System.out.println(arr.size());
        System.out.println(transform(arr));
        System.out.println(meaning(arr, 2));
        System.out.println(arr.toString());
        System.out.println("1   " + arr.toString() + "\n2   " + arr1.toString());
        MyList list = new MyList();
        add(list, arr, arr);
    }


    public static boolean euality(MyList<Task> a, MyList<Task> b) {
        if (a.size() != b.size()) {
            return false;
        } else {
            MyList r1 = new MyList(a);
            MyList r2 = new MyList(b);
            r1 = ordered(r1);
            r2 = ordered(r2);
            for (int i = 0; i < r1.size(); i++) {
                Task eq1 = (Task) r1.get(i);
                Task eq2 = (Task) r2.get(i);
                if (eq1.getN() != eq2.getN() && eq1.getA() != eq2.getA()) {
                    return false;
                }
            }
            return true;
        }
    }

    public static double meaning(MyList<Task> s, int x) {
        double result = 0;
        for (int i = 0; i < s.size(); i++) {
            Task t = s.get(i);
            result += t.getA() * Math.pow(x, t.getN());
        }
        return result;
    }

    public static void add(MyList<Task> p, MyList<Task> q, MyList<Task> r) {
        p.clear();
        MyList end = new MyList();
        for (int i = 0; i < q.size(); i++) {
            end.add(q.get(i));
        }
        for (int i = 0; i < r.size(); i++) {
            end.add(r.get(i));
        }
        p = ordered(end);
        System.out.println(transform(p));
    }

    public static MyList ordered(MyList beg) {
        MyList end = new MyList();
        MyList begin = new MyList(beg);
        int l = begin.size();
        while (end.size() != l) {
            int g = 0;
            Task min = (Task) begin.get(g);
            for (int i = 0; i < begin.size(); i++) {
                Task temp = (Task) begin.get(i);
                if (min.getN() > temp.getN()) {
                    g = i;
                    min = temp;
                }
            }
            end.add(begin.get(g));
            begin.remove(g);
        }
        int i = 1;
        while (i < end.size()) {
            Task t1 = (Task) end.get(i - 1);
            Task t2 = (Task) end.get(i);
            if (t1.getN() == t2.getN()) {
                end.set(i, new Task(t1.getN(), t1.getA() + t2.getA()));
                end.remove(i - 1);

            } else {
                i++;
            }
        }
        return end;
    }

    public static String transform(MyList arr) {
        arr = ordered(arr);
        String s = "S(x) = ";
        for (int i = 0; i < arr.size() - 1; i++) {
            Task w = (Task) arr.get(i);
            s += " " + w.getA() + "*x^(" + w.getN() + ") + ";
        }
        s = s.substring(0,s.length()-2);
        return s;

    }
}

