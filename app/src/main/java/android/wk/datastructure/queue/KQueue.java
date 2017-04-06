package android.wk.datastructure.queue;

import android.wk.datastructure.link.DoubleLink;

/**
 * Created by kwang on 2017/4/5.
 * 使用思想
 * 使用 循环双链表，第一个节点用作入队，最后一个节点用作出队，
 *
 * 由于循环双链表 查找时使用 index小于一半的正向查找，大于一半的反向查找，
 * 所以查找  最后一个节点 和第一个节点 时 一步找到。再交换赋值，最节省性能。
 */

public class KQueue<T> {
    private DoubleLink<T> mLink;

    public KQueue() {
        mLink = new DoubleLink<>();

    }

    public void push(T t) {
        mLink.insertFirst(t);
    }

    public T pop() {
        if(size() == 0){
            return null;
        }
        T t = mLink.getLast();
        mLink.deleteLast();
        return t;
    }

    public int size() {
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

    public static void main(String args[]) {
        KQueue<String> kQueue = new KQueue<>();
        kQueue.push("11111");
        kQueue.push("22222");
        kQueue.push("33333");
        kQueue.push("44444");
        kQueue.push("55555");
        System.out.println(kQueue.toString());
        kQueue.push("66666");
        System.out.println(kQueue.toString());
        System.out.println(kQueue.pop());
        System.out.println(kQueue.toString());
        kQueue.push("77777");

    }

}
