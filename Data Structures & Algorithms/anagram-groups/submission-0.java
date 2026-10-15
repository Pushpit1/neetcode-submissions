class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();

        for (String word : strs) {
            char[] x = word.toCharArray();
            Arrays.sort(x);

            String key = new String(x);

            mp.putIfAbsent(key, new ArrayList<>());
            mp.get(key).add(word);
        }

        return new ArrayList<>(mp.values());
    }
}
