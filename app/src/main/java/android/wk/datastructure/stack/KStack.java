package android.wk.datastructure.stack;

import android.wk.datastructure.link.SingleLink;

/**
 * Created by kwang on 2017/4/6
 */

public class KStack<T> {
    private SingleLink<T> mLink;

    public KStack() {
        this.mLink = new SingleLink<>();
    }

    public void push(T value) {
        mLink.insert(0, value);
    }

    public T pop() {
        if(size() == 0){
            return null;
        }
        T val = mLink.get(0);
        mLink.del(0);
        return val;
    }
    public int size(){
        return mLink.size();
    }

    @Override
    @Deprecated
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        int length = size();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(mLink.get(i) + "---");
        }

        return stringBuilder.toString();
    }

    public static void main(String args[]){
        KStack<Integer> stack = new KStack<>();
        stack.push(1111);
        stack.push(2222);
        stack.push(3333);
        stack.push(4444);
        System.out.println(stack.toString());
        System.out.println(stack.pop());
        System.out.println(stack.toString());
        stack.push(5555);
        stack.push(6666);
        stack.push(7777);
        stack.push(8888);
    }
}
