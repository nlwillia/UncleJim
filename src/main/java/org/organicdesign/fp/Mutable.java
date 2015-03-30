// Copyright 2014-02-15 PlanBase Inc. & Glen Peterson
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

package org.organicdesign.fp;

/**
 Java 8 requires that variables declared outside a lambda, but used inside a lambda must be <i>effectively</i> final
 and this class makes that possible for variables that are not (effectively) final.
 Java 7 and earlier require that they all be final.  Because these are often used where performance is critical,
 some primitive versions are available.
 */
public class Mutable {
    // Prevent instantiation
    private Mutable() { throw new UnsupportedOperationException("No instantiation"); }

    /** Wraps a primitive boolean to make it appear final when used inside a lambda. */
    public static class BooleanRef {
        private boolean b;
        private BooleanRef(boolean boo) { b = boo; }
        public static BooleanRef of(boolean boo) {
            return new BooleanRef(boo);
        }
        public boolean isTrue() { return b; }
        public void set(boolean boo) { b = boo; }
    }

    /** Wraps a primitive int to make it appear final when used inside a lambda. */
    public static class IntRef {
        private int i;
        private IntRef(int in) { i = in; }
        public static IntRef of(int in) { return new IntRef(in); }
        public int value() { return i; }
        public IntRef increment() { i++; return this; }
        public IntRef set(int x) { i = x; return this; }
    }

    /** Wraps a primitive long to make it appear final when used inside a lambda. */
    public static class LongRef {
        private long i;
        private LongRef(long in) { i = in; }
        public static LongRef of(long in) { return new LongRef(in); }
        public long value() { return i; }
        public LongRef increment() { i++; return this; }
        public LongRef set(long x) { i = x; return this; }
    }

    /** Wraps any object to make it appear final when used inside a lambda. */
    public static class ObjectRef<T> {
        private T t;
        private ObjectRef(T in) { t = in; }
        public static <T> ObjectRef<T> of(T obj) {
            return new ObjectRef<T>(obj);
        }
        public T value() { return t; }
        public ObjectRef<T> set(T x) { t = x; return this; }
    }
}
