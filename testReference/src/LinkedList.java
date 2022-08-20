public class LinkedList<T> {
    public Node<T> start;
    public LinkedList(){
        this.start = null;
    }
    public void add(T value){

        Node<T> newNode = new Node<>(value);
        if (this.start == null){
            this.start = newNode;
            return;
        }
        Node<T> currentNode = start;
        while (currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }
    public T get(int index){
        Node<T> currentNode  = start;
        for (int i = 0; i< index; i++){
            currentNode = currentNode.next;
        }
        return currentNode.value;
    }
}
