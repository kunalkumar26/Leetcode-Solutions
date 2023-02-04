class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int si = 0;
        int ei = 0;
        
        boolean dp[][] = new boolean[n][n];
        for(int g=0; g<n; g++){
            for(int i=0,j=g; j<n; i++, j++){
                if(g==0){
                    dp[i][j] = true;
                } else if(g==1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                        si=i;
                        ei=j;
                    }
                } else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    if(ei-si+1 < j-i+1){
                        si = i;
                        ei = j;
                    }
                }
            }
        }
        return s.substring(si, ei+1);
    }
}