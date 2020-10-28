class RecentCounter {
    
    List<Integer> lst;

    public RecentCounter() {
        lst = new ArrayList<Integer>();
    }
    
    public int ping(int t) {
        lst.add(t);
        while(lst.size() > 0 && lst.get(0) < (t-3000))
            lst.remove(0);
        return lst.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */