class StockPrice {
    // <time, val>
    TreeMap<Integer, Integer> records;
    // <val, <times>>
    TreeMap<Integer, Set<Integer>> vals;

    public StockPrice() {
        records = new TreeMap();
        vals = new TreeMap();
    }

    public void update(int timestamp, int price) {
        // records.put(timestamp, price);
        if(records.containsKey(timestamp)) { // update
            int preval = records.get(timestamp);
            records.put(timestamp, price);
            Set<Integer> times = vals.get(preval);
            times.remove(timestamp);
            if(times.size() == 0) vals.remove(preval);

        }
        records.put(timestamp, price);
        if(!vals.containsKey(price)) {
            vals.put(price, new HashSet());
        }
        vals.get(price).add(timestamp);

    }

    public int current() {
        return records.lastEntry().getValue();
    }

    public int maximum() {
        return vals.lastKey();
    }

    public int minimum() {
        return vals.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */