public class ArrayList <T> implements List{

    protected int size;
    T arr[]; 

    public ArrayList(int size){
        this.size = size; 
        this.arr = (T[]) new Object[10];
    }

    public ArrayList(){
        this(0);
    }

    
    public void growArray(){
        T tempArray[];
        tempArray = (T[]) new Object[size*2];
        for(int i = 0; i < arr.length; i++){
            tempArray[i] = arr[i];
        }
        arr = tempArray; 
        
    }

    public int size(){
        return size; 
    }


    public void add(Object item){
        if(size == arr.length){
            return; 
        }
        arr[size++] = (T) item; 
    }

    public void add(int pos, Object item) throws Exception{
        if(pos < 0 || pos > size){
            throw new Exception("Invalid Position.");
        }
        if(size == arr.length){
            growArray();
        }

        for(int i = size-1; i > pos; i--){
            arr[i+1] = arr[i];
        }
        arr[pos] = (T) item; 
        ++size; 
    }

    public T remove(int pos) throws Exception{
        if(pos < 0 || pos > size-1){
            throw new Exception("Invalid Position."); 
        }
        if(arr.length == 0){
            throw new Exception("Invalid Position.");
        }
        T temp = arr[pos];

        for(int i = size-1; i > pos; i--){
            arr[i+1] = arr[i];
        }
        --size; 
        return (T) temp; 
        
    }

    public T get(int pos) throws Exception {
        if(pos < 0 || pos > size-1){
            throw new Exception("Invalid Position. ");
        }
        return (T) arr[pos];
    }
}