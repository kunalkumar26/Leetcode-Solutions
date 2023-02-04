class Solution {
    public double helper(int a[], int b[]){
        if(a.length > b.length){
            return findMedianSortedArrays(b, a);
        }
        
        int n1 = a.length;
        int n2 = b.length;
        int low = 0, high = n1;
        
        while(low <= high){
            int cut1 = (low+high)/2;
            int cut2 = (n1+n2+1)/2 - cut1;
            
            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : a[cut1-1];
            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : b[cut2-1];
            
            int right1 = (cut1 == n1) ? Integer.MAX_VALUE : a[cut1];
            int right2 = (cut2 == n2) ? Integer.MAX_VALUE : b[cut2];
            
            if(left1 <= right2 && left2 <= right1){
                if((n1+n2)%2 == 0){
                    return (Math.max(left1, left2) + Math.min(right1, right2))/2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if(left1 > right2){
                high = cut1-1;
            } else {
                low = cut1+1;
            }
        }
        return 0.0;
    }
    
    public double helper1(int a[], int b[]){
        if(a.length > b.length){
            int temp[] = a;
            a = b;
            b = temp;
        }
        
        int lo = 0;
        int hi = a.length;
        int te = a.length + b.length;
        
        while(lo <= hi){
            int aleft = (lo+hi)/2;
            int bleft = (te+1)/2 - aleft;
            
            int alm1 = (aleft == 0) ? Integer.MIN_VALUE : a[aleft-1];
            int al = (aleft == a.length) ? Integer.MAX_VALUE : a[aleft];
            int blm1 = (bleft == 0) ? Integer.MIN_VALUE : b[bleft-1];
            int bl = (bleft == b.length) ? Integer.MAX_VALUE : b[bleft];
            
            // valid segregation
            if(alm1 <= bl && blm1 <= al ){
                double median = 0.0;
                if(te%2 == 0){
                    // even ele
                    int lmax = Math.max(alm1, blm1);
                    int rmin = Math.min(al, bl);
                    return (lmax+rmin)/2.0;
                } else {
                    // odd ele
                    return Math.max(alm1, blm1);
                }
            } else if(alm1 > bl){
                // more elements to be picked from the b array
                hi = aleft-1;
            } else if(blm1 > al){
                // more elemnts to be picked from the a array
                lo = aleft+1;
            }
        }
        return 0.0;
    }
    
    public double findMedianSortedArrays(int[] a, int[] b) {
        // return helper(a, b);
        return helper1(a, b);
        
    }
}












