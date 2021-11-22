import java.util.Arrays;

public class Lists {
    private Node head;
    private int size;

    public void add(int value){
        if (head == null){
            this.head = new Node(value);
        } else{
            Node temp = head;
            while (temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
            temp.getNext().setback(temp);
        }
        size++;
    }
    public int getIndx(int index) throws IllegalAccessException {
        int i = 0;
        Node temp = head;
        while (temp != null) {
            if (i == index)
                return temp.getValue();
            temp = temp.getNext();
            i++;
        }
        throw new IllegalAccessException();
    }
    public void remove(int index){
        int i = -1;
        Node temp = head;
        Node temp1;
        while (temp != null){
            if (++i == index){
                temp1 = temp.getback();
                if (temp1 == null){
                    temp = temp.getNext();
                    this.head = temp;
                    if (temp != null)
                        temp.setback(null);
                    this.size--;
                    return ;
                }
                temp = temp.getNext();
                temp1.setNext(temp);
                if (temp != null)
                    temp.setback(temp1);
                this.size--;
                return;
            }
            temp = temp.getNext();
        }
    }
    public void removeAll(){
        while (head != null)
            remove(this.size - 1);
    }
    public String toString(){
        if (size <= 0)
            return "empty";
        int[] res = new int[size];
        int index = 0;
        Node lst = head;
        while (lst != null){
            res[index++] = lst.getValue();
            lst = lst.getNext();
        }
        return Arrays.toString(res);
    }

    private static class Node {
        private int value;
        private Node back;
        private Node next;

        public Node(int value){
            this.value = value;
        }
        public int getValue(){
            return value;
        }
        public void setValue(int value){
            this.value = value;
        }
        public Node getNext(){
            return next;
        }
        public void setNext(Node list){
            this.next = list;
        }
        public Node getback(){
            return back;
        }
        public void setback(Node list){
            this.back = list;
        }
    }
}
