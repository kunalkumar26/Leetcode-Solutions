class Solution {
    public int fun(String s){
        if(s.length()==0 || s.length()==1){
            return s.length();
        }
        
        int max = 1;
        int i=0;
        int j=0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(; j<s.length(); j++){
            char key = s.charAt(j);
            if(map.containsKey(key) == true){
                i = Math.max(map.get(key)+1, i);
            }
            map.put(key, j);
            max = Math.max(max, j-i+1);
        }
        return max;
    }
    public int solution(String str) {
	    int i = -1;
	    int j = -1;
	    int ans = 0;
	    HashMap<Character, Integer> map = new HashMap<>();
	    while(true){
	        boolean f1 = false;
	        boolean f2 = false;
	        // acquire
	        while(i<str.length()-1 ){
	            f1 = true;
	           // System.out.println(str.substring(j+1, i+1) );
	           //System.out.println(i);
	            i++;
	            char ch = str.charAt(i);
	            map.put(ch, map.getOrDefault(ch, 0)+1 );
	            if(map.get(ch)==2 ){
	                break;
	            } else {
	                int pans = i-j;
	                if(pans > ans){
	                    ans = pans;
	                }
	            }
	        }
	        
	        // release
	        while(j<i){
	            f2 = true;
	            j++;
	            char ch = str.charAt(j);
	            map.put(ch, map.get(ch)-1 );
	            if(map.get(ch)==1 ){
	                break;
	            }
	        }
	        if(f1==false && f2==false){
	            break;
	        }
	    }
	    return ans;
	}
    public int lengthOfLongestSubstring(String s) {
        return solution(s);
    }
}