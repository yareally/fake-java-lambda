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

import java.util.List;

import static helpers.FakeLambda.*;

/**
 * Examples of how to use the Fake Lambdas
 *
 * @author Wes Lanning
 * @version 2013-08-11
 */
public class LambdaFunctions
{
    /**
     * Filters out items in a collection based on the conditional function
     * specified.
     *
     * This example filters out any items in a collection that are empty
     * @param data - the collection to apply the function to
     * @return the items in the list that match the given condition
     */
    public static List<String> filterData(List<String> data) {
        return filter(data, new FakeLambda.ƛƛ<String, Boolean>() {
            public Boolean apply(String elem) {
                return !elem.isEmpty();
            }
        });
    }

    /**
     * Example of using the map function to apply a
     * function to each item in a collection and return it
     * as a new list.
     *
     * This just formats each string in the collection based on the function
     * below and then creates a new list with the new format for each string.
     *
     * @param data - the collection to apply the function to
     * @return the newly reformatted list of strings
     */
    public static List<String> mapData(List<String> data) {
        return map(data, new FakeLambda.ƛƛ<String, String>() {
            public String apply(String elem) {
                return String.format("-- %s --", elem);
            }
        });
    }

    /**
     * Example of using foreach with a collection.
     * Applies the given function "format" to each item
     * in the collection.
     *
     * @param data - the collection to apply the function to.
     */
    public static void formatData(List<String> data) {
        foreach(data, new FakeLambda.ƛ<String>() {
            public void apply(String elem) {
                System.out.format("** %s **", elem);
            }
        });
    }
}
