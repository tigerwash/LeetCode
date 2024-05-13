class ProductOfNumbers {
    // prefix product
    List<Integer> list;
    public ProductOfNumbers() {
        list = new ArrayList();
        list.add(1);
    }

    public void add(int num) {
        if(num == 0) {
            list = new ArrayList();
            list.add(1);
        }else {
            list.add(list.get(list.size()-1) * num);
        }
    }

    public int getProduct(int k) {
        int len = list.size();
        if(k>len-1) return 0;
        return list.get(len-1) / list.get(len-k-1);
    }
}