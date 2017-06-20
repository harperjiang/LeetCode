package max_points_on_line;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Definition for a point. class Point { int x; int y; Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; } }
 */
public class Solution {

	private boolean sameline(Point pi, Point pj, Point pk) {
		return (pi.y - pj.y) * (pk.x - pj.x) + (pj.x - pi.x) * (pk.y - pj.y) == 0;
	}

	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0)
			return 0;
		int max = 0;
		if (points.length == 1)
			return 1;

		int upperBound = points.length;
		int n = points.length;
		int current;
		for (int i = 0; i < upperBound; i++) {
			Point pi = points[i];
			for (int j = i + 1; j < n; j++) {
				Point pj = points[j];
				current = 1;
				while (pi.x == pj.x && pi.y == pj.y) {
					current++;
					pj = points[++j];
				}
				current++;
				for (int k = j + 1; k < n && current + n - k > max; k++) {
					Point pk = points[k];
					if ((pk.x == pi.x && pk.y == pj.y)
							|| (pk.x == pj.x && pk.y == pj.y)) {
						current++;
						continue;
					}

					if (sameline(pi, pj, pk))
						current++;
				}
				max = Math.max(max, current);
			}
			upperBound = n - max;
		}
		return max;
	}

	public static void main(String[] args) {
		String datas = "(29,87),(145,227),(400,84),(800,179),(60,950),(560,122),(-6,5),(-87,-53),(-64,-118),(-204,-388),(720,160),(-232,-228),(-72,-135),(-102,-163),(-68,-88),(-116,-95),(-34,-13),(170,437),(40,103),(0,-38),(-10,-7),(-36,-114),(238,587),(-340,-140),(-7,2),(36,586),(60,950),(-42,-597),(-4,-6),(0,18),(36,586),(18,0),(-720,-182),(240,46),(5,-6),(261,367),(-203,-193),(240,46),(400,84),(72,114),(0,62),(-42,-597),(-170,-76),(-174,-158),(68,212),(-480,-125),(5,-6),(0,-38),(174,262),(34,137),(-232,-187),(-232,-228),(232,332),(-64,-118),(-240,-68),(272,662),(-40,-67),(203,158),(-203,-164),(272,662),(56,137),(4,-1),(-18,-233),(240,46),(-3,2),(640,141),(-480,-125),(-29,17),(-64,-118),(800,179),(-56,-101),(36,586),(-64,-118),(-87,-53),(-29,17),(320,65),(7,5),(40,103),(136,362),(-320,-87),(-5,5),(-340,-688),(-232,-228),(9,1),(-27,-95),(7,-5),(58,122),(48,120),(8,35),(-272,-538),(34,137),(-800,-201),(-68,-88),(29,87),(160,27),(72,171),(261,367),(-56,-101),(-9,-2),(0,52),(-6,-7),(170,437),(-261,-210),(-48,-84),(-63,-171),(-24,-33),(-68,-88),(-204,-388),(40,103),(34,137),(-204,-388),(-400,-106)";
		datas = datas.replaceAll("\\),\\(", "):(");
		String[] parts = datas.split(":");

		List<Point> ps = new ArrayList<Point>();
		Pattern ptn = Pattern.compile("\\(([\\-\\d]+),([\\-\\d]+)\\)");
		for (String p : parts) {
			Matcher matcher = ptn.matcher(p);
			if (!matcher.matches())
				throw new RuntimeException(p);
			Point pnt = new Point(Integer.valueOf(matcher.group(1)),
					Integer.valueOf(matcher.group(2)));
			ps.add(pnt);
		}
		Point[] parr = new Point[ps.size()];
		ps.toArray(parr);
		long sum = 0;
		for (int i = 0; i < 1; i++) {
			long start = System.currentTimeMillis();
			System.out.println(new Solution().maxPoints(parr));
			sum += System.currentTimeMillis() - start;
		}
		System.out.println(sum);
	}
}
