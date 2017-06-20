package max_points_on_line;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution_Learn {

	public int maxPoints(Point[] points) {
		int n = points.length;
		if (n < 2)
			return n;
		int currentL = 0, maxL = 2, x = 0, y = 0, dx = 0, dy = 0, overlap = 0, upperB = n;
		for (int i = 0; i < upperB; i++) {
			for (int j = i + 1; j < n; j++) {
				currentL = 1;
				/*
				 * Given two points: (a,b) and (c,d), the corresponding normal
				 * vector is (b-d,c-a) If another point (s,t) is in the same
				 * line uniquely defined by (a,b) and (c,d), then (s-a,t-b) dot
				 * (b-d,c-a) = 0
				 */
				x = points[i].y - points[j].y;
				y = points[j].x - points[i].x;

				/*
				 * If two points are the same, there is no need to check
				 * further, since a line has to be defined by exactly two
				 * distinct points.
				 */
				if (x == 0 && y == 0)
					overlap++;

				/*
				 * Well, it might be the case that duplicates are not
				 * consecutive, but as long as we can have a non-trivial normal
				 * vector, it won't matter.
				 */
				else {
					currentL++;

					/*
					 * Explaining (currentL+n-k>maxL): no further checking is
					 * necessary when there isn't enough left to make it surpass
					 * maxL.
					 */
					for (int k = j + 1; k < n && currentL + n - k > maxL; k++) {
						dx = points[k].x - points[i].x;
						dy = points[k].y - points[i].y;
						if (x * dx + y * dy == 0)
							currentL++;
					}
				}
				maxL = Math.max(currentL + overlap, maxL);
			}

			/*
			 * Explaining (upperB=n-maxL): it would be crystal clear as soon as
			 * you draw a table for combinations of case n>3.
			 */
			upperB = n - maxL;
			overlap = 0;
		}
		return maxL;
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
			System.out.println(new Solution_Learn().maxPoints(parr));
			sum += System.currentTimeMillis() - start;
		}
		System.out.println(sum);
	}
}
