/**
 * A deque list of T, using arrays
 *
 * @author zhou
 *         [Do not modify this file.]
 */
public class ArrayDeque<T> {
    /**
     * 数组容量
     */
    private int size;
    /**
     * 当前的队列要素个数
     */
    private int count;
    /**
     * 队首位置
     */
    private int first;
    /**
     * 队首位置
     */
    private int rear;
    T[] que;

    /**
     * A List with first FIRST0 and rest REST0.
     */
    public ArrayDeque(){
        que = (T[]) new Object[8];
        size = 8;
        count = 0;
        first = 0;
        rear = 0;
    }

    /**
     * A List with first FIRST0 and rest REST0.
     */
    private void expansion(){
            size = count*2;
            T[] temp = (T[]) new Object[size];
            for(int i=0; i< count; i++){
                temp[i] = que[i];
            }
            que = temp;
    }

    /**
     * A List with first FIRST0 and rest REST0.
     */
    public void addFirst(T item){
        if(count == size){
            expansion();
        }
        if(0 == first){
            first = size-1;
            que[first] = item;
        }else{
            que[--first] = item;
        }
        count++;
    }

    /**
     * A List with first FIRST0 and rest REST0.
     */
    public void addLast(T item){
        if(count == size){
            expansion();
        }
        if(size-1 == rear){
            rear = 0;
            que[rear] = item;
        }else{
            que[++rear] = item;
        }
        count++;
    }

    /**
     * A List with first FIRST0 and rest REST0.
     */
    public boolean isEmpty(){
        return count == 0 ? true : false;
    }

    /**
     * A List with first FIRST0 and rest REST0.
     */
    public int size(){
        return count;
    }

    /**
     * A List with first FIRST0 and rest REST0.
     */
    public void  printDeque(){
        if(first <= rear){
            for(int i = first; i < rear; i++){
                System.out.println(que[i]);
                System.out.println(" ");
            }
            System.out.println(que[rear]);
        }else{
            for(int i = first; i < size; i++){
                System.out.println(que[i]);
                System.out.println(" ");
            }
            for(int i = 0; i < rear; i++){
                System.out.println(que[i]);
                System.out.println(" ");
            }
            System.out.println(que[rear]);
        }
    }

    /**
     * A List with first FIRST0 and rest REST0.
     */
    private void decrease(){
        T[] temp = (T[]) new Object[size/2];
        if(first <= rear){
            for(int i = first; i <= rear; i++){
                temp[i-first] = que[i];
            }
        }else{
            for(int i = first; i < size; i++){
                temp[i-first] = que[i];
            }
            for(int i = 0; i <= rear; i++){
                temp[size-first] = que[i];
            }
        }
        size/=2;
    }

    /**
     * A List with first FIRST0 and rest REST0.
     */
    public T removeFirst() {
        int temp = first;
        if(size-1 == first) {
            first = 0;
        }else {
            first++;
        }
        count--;
        if(16 <= count && count < size/4) {
            decrease();
        }
        return que[temp];
    }

    /**
     * A List with first FIRST0 and rest REST0.
     */
    public T removeLast() {
        int temp = rear;
        if(0 == rear) {
            rear = size -1;
        }else {
            rear--;
        }
        if(16 <= count && count < size/4) {
            decrease();
        }
        return que[temp];
    }

    /**
     * A List with first FIRST0 and rest REST0.
     * @param index
     */
    public T get(int index) {
        if (count - 1 < index) {
            return null;
        }
        if (first <= rear || index <= size - first) {
            return que[first + index];
        } else {
            return que[index - (size - first) - 1];
        }
    }
}