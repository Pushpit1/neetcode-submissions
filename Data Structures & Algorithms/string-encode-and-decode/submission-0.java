class Solution {
    public String encode(List<String> strs) {
        StringBuilder s = new StringBuilder();
        for (String str : strs) {
            s.append(str.length()).append("#").append(str);
        }
        return s.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j));

            j++;
            ans.add(str.substring(j, j + len));

            i = j + len;
        }
        return ans  ;
    }
}
