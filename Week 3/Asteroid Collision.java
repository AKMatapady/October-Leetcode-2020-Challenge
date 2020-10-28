class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids == null || asteroids.length < 2)
            return asteroids;
        //int i = 0, j = asteroids.length-1;
        //List<Integer> lst = Arrays.stream(asteroids).boxed().collect(Collectors.toList());
        // while(i <= j)
        // {
        //     while(lst.get(i) < 0 && i < lst.size()-1)
        //         i++;
        //     while(lst.get(j) > 0 && j>0)
        //         j--;
        //     if()
        // }
        List<Integer> lst = new ArrayList<Integer>();
        lst.add(asteroids[0]);
        for(int i = 1; i < asteroids.length; i++)
        {
            int curr = asteroids[i];
            lst.add(curr);
            if(curr < 0)
            {
                //lst.add(curr);
                while(lst.size() > 1 && lst.get(lst.size()-2) > 0 && Math.abs(curr) > lst.get(lst.size()-2))
                    lst.remove(lst.size()-2);
                
                if(lst.size() > 1 && lst.get(lst.size()-2) > 0)
                {
                    if(Math.abs(curr) < lst.get(lst.size()-2))
                        lst.remove(lst.size()-1);
                    else if(Math.abs(curr) == lst.get(lst.size()-2))
                    {
                        lst.remove(lst.size()-1);
                        lst.remove(lst.size()-1);
                    }
                }
            }
            // else if(curr > 0)
            // {
            //     lst.add(curr);
            // }
        }
        return lst.stream().mapToInt(Integer::intValue).toArray();
    }
}