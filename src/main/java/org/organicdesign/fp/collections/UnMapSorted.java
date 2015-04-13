// Copyright 2015-04-13 PlanBase Inc. & Glen Peterson
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package org.organicdesign.fp.collections;

import java.util.Map;
import java.util.SortedMap;

/** An unmodifiable SortedMap. */
public interface UnMapSorted<K,V> extends UnMap<K,V>, SortedMap<K,V> {
// public Comparator<? super K>	comparator()

    /**
     * Returns a view of the mappings contained in this map.  The set should actually contain UnMap.Entry items, but
     * that return signature is illegal in Java, so you'll just have to remember. */
    @Override UnSet<Map.Entry<K,V>> entrySet();

// public  K	firstKey()

    /** {@inheritDoc} */
    @Override public UnMapSorted<K,V> headMap(K toKey);

    /** Returns a view of the keys contained in this map. */
    @Override UnSet<K> keySet();

// public  K	lastKey()

    /** {@inheritDoc} */
    @Override public UnMapSorted<K,V> subMap(K fromKey, K toKey);

    /** {@inheritDoc} */
    @Override public UnMapSorted<K,V> tailMap(K fromKey);

    /** {@inheritDoc} */
    @Override UnCollection<V> values();

// Methods inherited from interface java.util.Map
// clear, compute, computeIfAbsent, computeIfPresent, containsKey, containsValue, equals, forEach, get, getOrDefault, hashCode, isEmpty, merge, put, putAll, putIfAbsent, remove, remove, replace, replace, replaceAll, size

}
