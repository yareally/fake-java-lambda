/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Wes Lanning
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

package helpers;
import java.util.ArrayList;
import java.util.List;

/**
 * Fake lambda interfaces and common lambda related
 * functions.
 *
 * @author Wes Lanning
 * @version 2013-08-01
 */
public class FakeLambda
{
    /**
     * Faking lambdas with interfaces.
     * How else would one do it on JDK 7 and before?
     *
     * For lambdas of two different types.
     *
     * @param <A> - Type A
     * @param <B> - Type B
     */
    public interface ƛƛ<A, B>
    {
        B apply(A a);
    }

    /**
     * Faking lambdas with interfaces.
     * How else would one do it on JDK 7 and before?
     *
     * For lambdas of only one type.
     *
     * @param <A> - Type A
     */
    public interface ƛ<A>
    {
        void apply(A a);
    }

    /**
     * Filter a collection of items based on a given function. Items that match "true"
     * for the given function are added to a list and that list is returned from this function.
     *
     * @param data - collection of items to filter based on the given function
     * @param predicate - the function to filter the items in the collection
     * @param <A> - the type for the collection/function. For simplicity, they have the same type
     *
     * @return a new list of items that meet the condition set in the function
     */
    public static <A> List<A> filter(Iterable<A> data, ƛƛ<A, Boolean> predicate)
    {
        List<A> result = new ArrayList<>();

        for (A a : data) {
            if (predicate.apply(a)) result.add(a);
        }
        return result;
    }

    /**
     * Loops over a collection and applies the given function to each item and then adds
     * it to a list. Returns the new list after the function has been applied to each item.
     *
     * @param data - collection of items to match against the function
     * @param funct - the function with a condition to check the items against
     * @param <A> - the type for the collection/function. For simplicity, they have the same type
     *
     * @return the list of items with the function applied to each.
     */
    public static <A> List<A> map(Iterable<A> data, ƛƛ<A, A> funct) {
        List<A> result = new ArrayList<>();

        for (A a : data) {
            result.add(funct.apply(a));
        }
        return result;
    }

    /**
     * Loops through a collection and applies the given function to each item.
     * Similar to map, except this does not return a list (think of it as mass applying a void function)
     *
     * @param data - the collection to loop over
     * @param funct - the function to apply to each item in the collection
     * @param <A> - the type for the collection. For simplicity, the function assumes the same type.
     */
    public static <A> void foreach(Iterable<A> data, ƛ<A> funct) {
        for (A a : data) {
            funct.apply(a);
        }
    }
}
