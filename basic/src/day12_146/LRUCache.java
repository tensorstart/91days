package day12_146;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * ClassName:LRUCache
 * Package:day12_146
 * Discription:运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Data:2020/6/13 21:00
 */
public class LRUCache {
    private LinkedList<Integer> list=new LinkedList<>();//存储key 这里不能使用多态创建 编译看左边，运行看右边
    //编译的时候发现左边没有子类的特有方法，所以编译期会直接报错
    private Map<Integer,Integer> map=new HashMap<>();//存储关系 哈希表
    private int size;//最大长度
    private int length;//当前长度
    public LRUCache(int capacity) {
        size=capacity;
        length=0;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        put(key,map.get(key));//动了这个元素了，先放到第一个位置
        return map.get(key);//返回它的值
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            list.remove((Integer) key);//remove(Object o) 用的删除元素
            list.addFirst(key);//放在头上
            map.put(key,value);//加入哈希表
        }
        else {
            if (length==size){
                map.remove(list.pollLast());//如果超过最大长度，先删除
                map.put(key,value);//再存
                list.addFirst(key);
            }else {
                map.put(key,value);//没超过直接存
                list.addFirst(key);
                length++;//当前长度+1
            }

        }
    }
}
