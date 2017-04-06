package android.wk.datastructure.link;

/**
 * Created by kwang on 2017/4/1.
 */

public class SingleLink<T> {
    private Node<T> mHead;
    private int mCount;

    public SingleLink() {
        mHead = new Node<>(null, null);
        mCount = 0;
    }

    public int size() {
        return mCount;
    }

    public boolean isEmpty() {
        return mCount <= 0;
    }

    public T get(int index) {
        return getNode(index).value;
    }

    /**
     * 节点插入在index 之前
     */
    public void insert(int index, T t) {
        if (index == 0) {
            Node<T> node = new Node<>(t, mHead.next);
            mHead.next = node;
            mCount++;
            return;
        }

        Node<T> nodePrev = getNode(index - 1);
        Node<T> node = new Node<>(t, nodePrev.next);
        nodePrev.next = node;
        mCount++;
    }


    /**
     * 追加到最后面
     */
    public void parseLast(T t) {
        Node<T> nodePrev = getNode(mCount - 1);
        Node<T> node = new Node<>(t, nodePrev.next);
        nodePrev.next = node;
        mCount++;
    }

    public void del(int index) {
        if (index == 0) {
            Node<T> node = getNode(0);
            mHead.next = node.next;
            node = null;
            mCount--;
            return;
        }
        Node<T> nodePrev = getNode(index - 1);
        Node<T> node = getNode(index);

        nodePrev.next = node.next;
        node = null;
        mCount--;
    }

    /*************************************************************************************************/
    private Node<T> getNode(int index) {
        if (index < 0 || index >= mCount) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> node = mHead.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }


    private class Node<T> {
        public Node<T> next;
        public T value;

        public Node(T valueIN, Node<T> nextIn) {
            this.value = valueIN;
            this.next = nextIn;
        }
    }
}
