class RandomizedSet {
    List<Integer> elementData ;
    Map<Integer,Integer> map ;
    public RandomizedSet() {
        elementData = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val,elementData.size());
        elementData.add(elementData.size(),val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        //将要删除的元素与最后一个元素交换
        int index = map.get(val);
        int lastVal = elementData.get(elementData.size()-1);
        elementData.set(index,lastVal);
        map.put(lastVal,index);
        elementData.remove(elementData.size()-1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();

        return elementData.get(random.nextInt(elementData.size()));

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
