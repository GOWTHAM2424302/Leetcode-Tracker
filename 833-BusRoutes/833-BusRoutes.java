// Last updated: 7/9/2026, 3:01:34 PM
class Solution {

    public int numBusesToDestination(int[][] routes, int source, int target) {

        if (source == target)
            return 0;

        Map<Integer, List<Integer>> stopToBus = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToBus.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(source);

        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedBus = new HashSet<>();

        visitedStops.add(source);

        int buses = 0;

        while (!q.isEmpty()) {

            buses++;

            int size = q.size();

            while (size-- > 0) {

                int stop = q.poll();

                List<Integer> busesList = stopToBus.getOrDefault(stop, new ArrayList<>());

                for (int bus : busesList) {

                    if (visitedBus.contains(bus))
                        continue;

                    visitedBus.add(bus);

                    for (int nextStop : routes[bus]) {

                        if (nextStop == target)
                            return buses;

                        if (!visitedStops.contains(nextStop)) {
                            visitedStops.add(nextStop);
                            q.offer(nextStop);
                        }
                    }
                }
            }
        }

        return -1;
    }
}