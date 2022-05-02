package ch11;

import java.util.*;

public class MyVector implements List {
    
    // 인스턴스 변수
    Object[] data = null; // 데이터 저장 배열
    int capacity = 0; // 배열 길이 ( 저장 용량 )
    int size = 0; // 배열 내 데이터의 개수

    // 생성자를 통한 데이터 저장 배열 생성
    public MyVector(int capacity){
        if(capacity < 0) throw new IllegalArgumentException("유효하지 않은 값입니다."); // RuntimeExcepion 이기에 예외처리가 필수가 아니다.
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public MyVector(){
        this(10);
    }

    public boolean add(Object obj){
        ensureCapacity(size + 1);
        data[size++] = obj;
        return true;
    }

    // 최소 배열 길이 확인
    public void ensureCapacity(int minCapacity) {
        if (minCapacity - data.length > 0) {
            setCapacity(minCapacity);
        }
    }

    public Object get(int index) {
        if(index < 0 || index > size - 1) throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
        return data[index];
    }

    public Object remove(int index){
        Object oldObj = null;
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
        oldObj = data[index];
        // 배열의 마지막 인덱스가 아니라면
        if (index != size - 1) {
            System.arraycopy(data, index+1, data, index, size-index-1);
        }
        data[size-1] = null;
        size--;
        return oldObj;
    }

    public boolean remove(Object obj) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(obj)) {
                remove(i);
                return true;
            }
        }
        return false;
    }
    public void trimToSize(){setCapacity(size);}
    private void setCapacity(int capacity){
        if(capacity < 0 ) throw new IllegalArgumentException();
        if(this.capacity == capacity) return;
        Object[] tmp = new Object[capacity];
        System.arraycopy(data, 0, tmp, 0, size);
        data = tmp;
        this.capacity = capacity;
    }
    public void clear(){for (int i = 0; i < data.length; i++) data[i] = null;}
    public int size(){return size;}

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
