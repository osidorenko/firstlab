

public class MyList<Task> {
    private Elem<Task> frstEl;
    private int size = 0;

    public MyList() {
        frstEl = new Elem<>(null, null);
    }

    public void add(Task e) {
        Elem temp = new Elem(e, frstEl.getNext());
        frstEl.setNext(temp);
        size++;
    }

    public Task get(int x) {
        if (size <= x || x < 0) {
            return null;
        } else {
            Elem temp;
            temp = frstEl.getNext();
            for (int i = 0; i < x; i++) {
                temp = temp.getNext();
            }
            return (Task) temp.getTs();
        }
    }

    public void remove(int x) {
        Elem temp;
        temp = frstEl;
        for(int i = 0;i<x-1;i++){
            temp = temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
        size--;
    }


    public int size() {
        return size;
    }

    private static class Elem<Task> {
        Task ts;
        private Elem<Task> next;

        public Elem(Task ts, Elem<Task> next) {
            this.ts = ts;
            this.next = next;
        }

        public Task getTs() {
            return ts;
        }

        public void setTs(Task ts) {
            this.ts = ts;
        }

        public Elem<Task> getNext() {
            return next;
        }

        public void setNext(Elem<Task> next) {
            this.next = next;
        }
    }
}

