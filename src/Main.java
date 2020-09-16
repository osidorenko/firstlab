public class Main {

    public static void main(String[] args) {
        Task t1 = new Task(1, 0);
        Task t2 = new Task(2, 0);
        Task t3 = new Task(3, 0);
        Task t4 = new Task(4, 0);
        Task t5 = new Task(5, 0);

        MyList<Task> arr = new MyList<>();
        arr.add(t1);
        arr.add(t2);
        arr.add(t3);
        arr.add(t4);
        System.out.println(arr.size());
        System.out.println(arr.get(0));
        arr.remove(1);
        System.out.println(arr.size());
        System.out.println(arr.get(0)+" "+arr.get(1)+" "+arr.get(2)+" "+arr.get(3));


    }
}
