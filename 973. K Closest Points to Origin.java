class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int[][] dists = new int[n][3];
        for (int i = 0; i < n; i++) {
            dists[i][0] = points[i][0];
            dists[i][1] = points[i][1];
            dists[i][2] = dists[i][0] * dists[i][0] + dists[i][1] * dists[i][1];
        }
        Arrays.sort(dists, (a, b) -> Integer.compare(a[2], b[2]));
        int[][] results = new int[k][2];
        for (int i = 0; i < k; i++) {
            results[i][0] = dists[i][0];
            results[i][1] = dists[i][1];
        }
        return results;
    }
}
