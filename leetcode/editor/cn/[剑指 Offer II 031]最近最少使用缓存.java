//
// 运用所掌握的数据结构，设计和实现一个 LRU (Least Recently Used，最近最少使用) 缓存机制 。 
// 
//
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
//
// 
//
// 进阶：是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 
// 注意：本题与主站 146 题相同：https://leetcode-cn.com/problems/lru-cache/ 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 92 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    private HashMap<Integer, DoubleList.Node> map;

    private DoubleList cache;

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        //确认是否存在
        if (!map.containsKey(key)) return -1;
        //提升级别
        makeRecently(key);
        return map.get(key).value;
    }

    public void put(int key, int value) {
        //存在 key 执行 更新值和提升级别
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
            return;
        }

        //容量已满清理优先级最低的数据
        if (capacity == cache.getSize()) {
            removeLeastRecently();
        }

        //有容量且不存在 key
        addRecently(key, value);
    }

    /**
     * 提升优先级
     *
     * @param key
     */
    private void makeRecently(int key) {
        //获取需要提升的节点
        DoubleList.Node node = map.get(key);
        //删除
        cache.remove(node);
        //添加到尾部
        cache.addlast(node);
    }

    /**
     * 添加元素，添加的元素的优先级为最高
     *
     * @param key
     * @param value
     */
    private void addRecently(int key, int value) {
        DoubleList.Node node = new DoubleList.Node(key, value);
        cache.addlast(node);
        map.put(key, node);
    }

    /**
     * 删除元素
     *
     * @param key
     */
    private void deleteKey(int key) {
        DoubleList.Node node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }

    /**
     * 删除优先级最低的元素
     */
    private void removeLeastRecently() {
        DoubleList.Node node = cache.removeFirst();
        int key = node.key;
        map.remove(key);
    }
}


class DoubleList {
    private Node head, tail;

    private int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /**
     * 添加元素至尾部
     * @param node
     */
    public void addlast(Node node) {
        //处理插入的节点
        node.prev = tail.prev;
        node.next = tail;
        //处理原尾部节点
        tail.prev.next = node;
        //处理虚拟尾节点
        tail.prev = node;
        ++size;
    }

    /**
     * 删除指定元素
     * @param node
     */
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        --size;
    }

    /**
     * 删除链表第一个元素
     * @return
     */
    public Node removeFirst() {
        if (head.next == tail) return null;
        Node first = head.next;
        remove(first);
        return first;
    }

    public int getSize() {
        return size;
    }

    static class Node {
        public int key, value;
        public Node next;
        public Node prev;

        public Node(int key, int value) {
            this.key = key;

            this.value = value;
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
