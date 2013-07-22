package org.perfecthashmap;
import java.util.HashMap;
import java.util.Map;

import org.perfecthashmap.PerfectHashMap;

import com.google.caliper.Benchmark;
import com.google.caliper.runner.CaliperMain;

public class BenchmarkOfImmutablePerfectHashMap extends Benchmark  {

	private Map<Object, Object> hashMap;
	private Map<Object, Object> fastMap;
	private Object[] keyObjects;

	private final Object valueObject = new Object();

	@Override protected void setUp() {
		keyObjects = new Object[100];
		for (int i = 0; i < 100; ++i) {
			keyObjects[i] = new Object();
		}

		Map<Object, Object> tmpMap = new HashMap<Object, Object>();
		for (Object o: keyObjects) {
			tmpMap.put(o, valueObject);
		}

		fastMap = PerfectHashMap.newBuilder().addAll(tmpMap).build();

		hashMap = new HashMap<Object, Object>();
		for (int i = 0; i < 100; ++i) {
			hashMap.put(keyObjects[i], valueObject);
		}
	}

	public int timeHashMap(int reps) {
		int dummyCount = 0;
		for (int i = 0; i < reps; ++i) {
			for (Object o: keyObjects) {
				if (hashMap.containsKey(o)) ++dummyCount;
			}
		}
		return dummyCount;
	}

	public int timeImmutableMap(int reps) {
		int dummyCount = 0;
		for (int i = 0; i < reps; ++i) {
			for (Object o: keyObjects) {
				if (fastMap.containsKey(o)) ++dummyCount;
			}
		}
		return dummyCount;
	}

	public static void main(String[] args) {
		CaliperMain.main(BenchmarkOfImmutablePerfectHashMap.class, args);
	}
}
