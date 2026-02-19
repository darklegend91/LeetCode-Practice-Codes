class Solution {
    public int[] dailyTemperatures(int[] temps) {

        int n = temps.length;
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && temps[i] > temps[stack.peek()]) {

                int prevIndex = stack.pop();
                res[prevIndex] = i - prevIndex;
            }

            stack.push(i);
        }

        return res;
    }
}