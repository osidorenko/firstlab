public class Task {
    private int n;
    private int a;

    public Task(){

    }
    public Task(int n, int a) {
        this.n = n;
        this.a = a;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Task{" +
                "n=" + n +
                ", a=" + a +
                '}';
    }
}
