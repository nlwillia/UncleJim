// Copyright 2015 PlanBase Inc. & Glen Peterson
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

import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;

/** An unmodifiable set */
public interface UnSet<E> extends UnCollection<E>, Set<E> {

    // ==================================================== Static ====================================================
    UnSet<Object> EMPTY = new UnSet<Object>() {
        @Override public boolean contains(Object o) { return false; }
        @Override public int size() { return 0; }
        @Override public boolean isEmpty() { return true; }
        @Override public UnIterator<Object> iterator() { return UnIterator.empty(); }
    };
    @SuppressWarnings("unchecked")
    static <T> UnSet<T> empty() { return (UnSet<T>) EMPTY; }

    // =================================================== Instance ===================================================

    /** Not allowed - this is supposed to be unmodifiable */
    @SuppressWarnings("deprecation")
    @Override @Deprecated default boolean add(E e) {
        throw new UnsupportedOperationException("Modification attempted");
    }
    /** Not allowed - this is supposed to be unmodifiable */
    @SuppressWarnings("deprecation")
    @Override @Deprecated default boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Modification attempted");
    }
    /** Not allowed - this is supposed to be unmodifiable */
    @SuppressWarnings("deprecation")
    @Override @Deprecated default void clear() {
        throw new UnsupportedOperationException("Modification attempted");
    }

    /**
     Returns true if the set contains the given item.  This is the defining method of a set.
     Sets have to override this because the default implementation in UnCollection is O(n) whereas a sorted set
     should be O(log n) or O(1).
     */
    @Override boolean contains(Object o);
    /** {@inheritDoc} */
    @Override default boolean containsAll(Collection<?> c) { return UnCollection.containsAll(this, c); }
// boolean	equals(Object o)
// int	hashCode()

    /**
     This is a convenience method inherited from Collection that returns true if size() == 0 (if this set contains no
     elements).
     */
    @Override default boolean isEmpty() { return size() == 0; }

    /**
     Iterates over contents with no guarantees about their ordering.
     {@inheritDoc}
     */
    @Override UnIterator<E> iterator();

    /** Not allowed - this is supposed to be unmodifiable */
    @SuppressWarnings("deprecation")
    @Override @Deprecated default boolean remove(Object o) {
        throw new UnsupportedOperationException("Modification attempted");
    }
    /** Not allowed - this is supposed to be unmodifiable */
    @SuppressWarnings("deprecation")
    @Override @Deprecated default boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Modification attempted");
    }
    /** Not allowed - this is supposed to be unmodifiable */
    @SuppressWarnings("deprecation")
    @Override @Deprecated default boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Modification attempted");
    }

//  int size(); // This is limiting for sets, but not so much that it has to be deprecated.
// default Spliterator<E>	spliterator()

    /**
     * This method goes against Josh Bloch's Item 25: "Prefer Lists to Arrays", but is provided for backwards
     * compatibility in some performance-critical situations.  If you really need an array, consider using the somewhat
     * type-safe version of this method instead, but read the caveats first.
     * {@inheritDoc}
     */
    @Override default Object[] toArray() { return UnCollection.toArray(this); }

    /**
     * This method goes against Josh Bloch's Item 25: "Prefer Lists to Arrays", but is provided for backwards
     * compatibility in some performance-critical situations.  If you need to create an array (you almost always do)
     * then the best way to use this method is:
     *
     * <code>MyThing[] things = col.toArray(new MyThing[coll.size()]);</code>
     *
     * Calling this method any other way causes unnecessary work to be done - an extra memory allocation and potential
     * garbage collection if the passed array is too small, extra effort to fill the end of the array with nulls if it
     * is too large.
     *
     * {@inheritDoc}
     */
    @Override default <T> T[] toArray(T[] as) { return UnCollection.toArray(this, as); }

// Methods inherited from interface java.util.Collection
// parallelStream, removeIf, stream
    /** Not allowed - this is supposed to be unmodifiable */
    @SuppressWarnings("deprecation")
    @Override @Deprecated default boolean removeIf(Predicate<? super E> filter) {
        throw new UnsupportedOperationException("Modification attempted");
    }
// Methods inherited from interface java.lang.Iterable
// forEach
}
