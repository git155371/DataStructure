package android.wk.datastructure.link;

/**
 * Created by kwang on 2017/4/1.
 */

public class DoubleLink<T> {
    private DoubleNode<T> mHead;
    private int mCount;


    public DoubleLink() {
        mHead = new DoubleNode<>(null, null, null);
        mHead.dPrev = mHead.dNext = mHead;
        mCount = 0;
    }

    public int size() {
        return mCount;
    }

    public boolean isEmpty() {
        return mCount == 0;
    }

    public T get(int index) {
        return getNode(index).dValue;
    }

    public T getFirst() {
        return getNode(0).dValue;
    }

    public T getLast() {
        return getNode(mCount - 1).dValue;
    }


    /**
     * 节点插入到 第index 位置之前
     */
    public void insert(int index, T t) {
        if (index == 0) {
            DoubleNode<T> node = new DoubleNode<>(t, mHead, mHead.dNext);
            mHead.dNext.dPrev = node;
            mHead.dNext = node;
            mCount++;
            return;
        }
        DoubleNode<T> inode = getNode(index);
        DoubleNode<T> tnode = new DoubleNode<>(t, inode.dPrev, inode);
        inode.dPrev.dNext = tnode;
        inode.dNext = tnode;
        mCount++;
        return;
    }

    public void insertFirst(T t) {
        insert(0, t);
    }

    public void appendLast(T t) {
        DoubleNode<T> node = new DoubleNode<>(t, mHead.dPrev, mHead);
        mHead.dPrev.dNext = node;
        mHead.dPrev = node;
        mCount++;
    }

    public void del(int index) {
        DoubleNode<T> inode = getNode(index);
        inode.dPrev.dNext = inode.dNext;
        inode.dNext.dPrev = inode.dPrev;
        inode = null;
        mCount++;
    }

    public void deleteFirst() {
        del(0);
    }

    public void deleteLast() {
        del(mCount - 1);
    }


    /*************************************************************************************************/
    private DoubleNode<T> getNode(int index) {
        if (index < 0 || index >= mCount) {
            throw new IndexOutOfBoundsException();
        }

        //通过 next 查找
        if (index <= mCount / 2) {
            DoubleNode node = mHead.dNext;
            for (int i = 0; i < index; i++) {
                node = node.dNext;
            }
            return node;
        }

        //通过 prev 查找
        DoubleNode node = mHead.dPrev;
        int cycles = mCount - index - 1;
        for (int j = 0; j < cycles; j++) {
            node = node.dPrev;
        }
        return node;
    }


    private class DoubleNode<T> {
        public DoubleNode dPrev;
        public DoubleNode dNext;
        public T dValue;

        public DoubleNode(T dValueIn, DoubleNode dPrevIn, DoubleNode dNextIn) {
            this.dValue = dValueIn;
            this.dPrev = dPrevIn;
            this.dNext = dNextIn;
        }
    }


}
