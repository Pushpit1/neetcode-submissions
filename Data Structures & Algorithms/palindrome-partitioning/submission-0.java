class Solution {
    boolean isPalindrome(String sub) {
    int l = 0, r = sub.length() - 1;

    while (l < r) {
        if (sub.charAt(l) != sub.charAt(r)) return false;
        l++;
        r--;
    }

    return true;
}
    void back(int i , String s , List<String> cur , List<List<String>>ans ){
        
        if(i==s.length()){
            ans.add(new ArrayList<>(cur));
            return ;
        }
        for(int j = i ; j<s.length() ; j++){
           String sub = s.substring(i, j + 1);

if (isPalindrome(sub)) {
    cur.add(sub);
    back(j + 1, s, cur, ans);
    cur.remove(cur.size() - 1);
}
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans  = new ArrayList<>() ;

        back(0 , s , new ArrayList<>(), ans) ;

        return ans  ;
    }
}
