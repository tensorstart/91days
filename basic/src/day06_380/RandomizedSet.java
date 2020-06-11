package day06_380;

/**
 * ClassName:day06
 * Package:day06_380
 * Discription:
 *
 * @Data:2020/6/6 14:02
 */
import java.util.*;

/**
 * ClassName:RandomizedSet
 * Package:day06_380
 * Discription:设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 *
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 * 示例 :
 *
 * // 初始化一个空的集合。
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomSet.insert(1);
 *
 * // 返回 false ，表示集合中不存在 2 。
 * randomSet.remove(2);
 *
 * // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomSet.insert(2);
 *
 * // getRandom 应随机返回 1 或 2 。
 * randomSet.getRandom();
 *
 * // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomSet.remove(1);
 *
 * // 2 已在集合中，所以返回 false 。
 * randomSet.insert(2);
 *
 * // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 * randomSet.getRandom();
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Data:2020/6/6 10:48
 */
class RandomizedSet {
    private ArrayList<Integer> value =new ArrayList<>();//存放值
    private Map<Integer,Integer> map=new HashMap<>();//存关系


    /** Initialize your data structure here. */
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        else {
            map.put(val,value.size());
            value.add(val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        else {
            int last_ele=value.get(value.size()-1);//拿到列表的最后一个元素
            int index=map.get(val);//通过值(key)拿到当前要删除元素的下标
            value.set(index,last_ele);//这里不能用add(index,ele),因为使用这个是添加元素，列表会变长
            map.put(last_ele,index);//相应的把map的值也更新了
            value.remove(value.size()-1);//把最后一个元素删掉，因为此使原来的最后一个元素已经和与要删除的元素交换了
            map.remove(val);//清除map中的这个元素
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (value==null) throw new RuntimeException("列表为空");
        Random rd=new Random();
        int i = rd.nextInt(value.size());
        return value.get(i);
    }
}
class testMySet{
    public static void main(String[] args) {
        /*["RandomizedSet","insert","insert","remove","insert","remove","getRandom"]
[[],[0],[1],[0],[2],[1],[]]*/
        RandomizedSet rdset = new RandomizedSet();
        rdset.insert(0);
        rdset.insert(1);
        rdset.remove(0);
        rdset.insert(2);
        rdset.remove(1);
        int random = rdset.getRandom();
        System.out.println(random);

        int a=1;

    }
}
