

public class MyList<Task> {
    private Elem<Task> frstEl;
    private int size = 0;

    public MyList() {
        frstEl = new Elem<>(null, null);
    }

    public MyList(MyList arr) {
        frstEl = new Elem<Task>(null, null);
        for (int i = 0; i < arr.size(); i++) {
            add((Task) arr.get(i));
        }
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

    private void removefirst() {
        frstEl.setNext(frstEl.getNext().getNext());
    }

    public void remove(int x) {
        if (x == 0) {
            removefirst();
        } else {
            Elem temp;
            temp = frstEl;
            for (int i = 0; i < x; i++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
        size--;
    }

    public void set(int x, Task t) {

        Elem temp = frstEl;
        for (int i = 0; i < x; i++) {
            temp = temp.getNext();
        }
        Elem nw = new Elem(t, temp.getNext().getNext());
        temp.setNext(nw);

    }
    public void clear(){
        frstEl.setNext(null);
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String s = "";
        Elem temp = frstEl.getNext();
        for (int i = 0; i < size; i++) {
            s += " " + temp.getTs();
            temp = temp.getNext();
        }
        s += " size : " + size;
        return s;
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

