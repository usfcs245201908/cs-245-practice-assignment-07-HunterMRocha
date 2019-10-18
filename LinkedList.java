

//LinkedList class --------------------------------------
public class LinkedList <T> implements List <T>{

    protected int size; 
    Node<T> head; 
    //Node tail; 
   
    
    public LinkedList(int size){
        this.size = 0; 
        this.head = null;
        //this.tail = null; 
    }

    public LinkedList(){
        this(100);
    }

    public void add(T item){
        if(head == null){
            head = new Node<T>(item);
            ++size;
            return;
        }
        
        Node <T> current = head; 
        while(current.next != null){
            current = current.next; 
        }

        current.next = new Node<T>(item); 
        ++size; 

    }

    public void add(int pos, T item) throws Exception {
        if(pos > size-1 || pos < 0) {
            throw new Exception("Invalid Position");
        }
        if(pos == 0){
            Node current = new Node(item); 
            current.next = head; 
            head = current; 
            ++size; 
        }else{
            Node current = new Node(item);
            Node prev = head; 
            for(int i = 0; i < pos-1; i++){
                prev = prev.next; 
            }
            current.next = prev.next; 
            prev.next = current;
            ++size;
        }

        // Node <T> current = head; 
        // int increment = 0;
        // while(increment != pos-1){
        //     ++increment;
        //     current = current.next; 
        // }
        // Node <T> tempNode = current.next; 
        // current.next = new Node<T>(item); 
        // current.next.next = tempNode; 
        // ++size; 
    }

    public T get(int pos) throws Exception {
        if(pos > size-1|| pos < 0){
            throw new Exception("Invalid Position"); 
        }

        Node<T> current = head; 
        for(int i = 0; i < pos; i++){
            current = current.next; 
       }
        return current.data; 
        // Node<T> current = head; 
        // int increment = 0; 
        // while (increment != pos){
        //     ++increment;
        //     current = current.next; 
        // }
        
        // return current.data; 
    }

    public T remove(int pos) throws Exception{
        if(pos > size-1 || pos < 0){
            throw new Exception("Invalid Position.");
        }
        if(pos == 0){
            T temp = head.data;
            head = head.next;
            --size; 
            return (T) temp; 
        } 
        Node<T> current = head; 

        for(int i = 0; i < pos-1; i++){
            current = current.next; 
        }
        Node<T> temp = current.next;
        
        current.next = current.next.next; 
        --size;
        return temp.data;
    }

    public int size(){
        return size; 
    }
}