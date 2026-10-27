class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        words.remove(beginWord);

        int steps = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int j = 0; j < size; j++) {
                String curr = q.poll();

                if (curr.equals(endWord)) {
                    return steps;
                }

                Iterator<String> it = words.iterator();

                while (it.hasNext()) {
                    String word = it.next();
                    int diff = 0;

                    for (int i = 0; i < curr.length(); i++) {
                        if (curr.charAt(i) != word.charAt(i)) {
                            diff++;
                        }
                    }

                    if (diff == 1) {
                        q.offer(word);
                        it.remove();
                    }
                }
            }

            steps++;
        }

        return 0;
    }
}
