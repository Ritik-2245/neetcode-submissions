class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n];

        int inf = (int)1e9;

        Arrays.fill(dist,inf);
        dist[k-1]=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<times.length;j++){
                int a = times[j][0];
                int b = times[j][1];
                int d = times[j][2];

                dist[b-1] = Math.min(dist[b-1],dist[a-1]+d);
            }
        }

        int ans = Arrays.stream(dist).max().getAsInt();

        return ans != inf ? ans :-1;

    }
}
