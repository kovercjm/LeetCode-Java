/*
 * @lc app=leetcode id=380 lang=java
 *
 * [380] Insert Delete GetRandom O(1)
 */

// @lc code=start
class RandomizedSet {
    private List<Integer> values;
    private Map<Integer, Integer> position;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.values = new ArrayList<>();
        this.position = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (position.containsKey(val))
            return false;
        else {
            position.put(val, values.size());
            values.add(val);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!position.containsKey(val))
            return false;
        else {
            int index = position.get(val);
            int last = values.get(values.size() - 1);
            values.set(index, last);
            position.put(last, index);
            values.remove(values.size() - 1);
            position.remove(val);
            return true;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        return values.get(random.nextInt(values.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end
