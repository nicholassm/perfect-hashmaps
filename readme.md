perfect-hashmap
===============

> A perfect hash function for a set S is a hash function that maps
> distinct elements in S to a set of integers, with no collisions.
>
> -- <cite>[Wikipedia][1]</cite>

The default `HashMap` implementation in Java is very well-written, fast, efficient and should be used by default in almost any application.

However, you know the difference between `System.nanoTime()` and `System.currentTimeMillis()`. You have already benchmarked and optimized the GC's behaviour, you have experimented with pinning the threads in your application to a fixed set of processors and measuring latency in milliseconds is simply too coarse for your domain.

*Still reading?*

You need the fastest possible hashmap implementation which is primarily used for read operations. You are probably writing a latency sensitive
financial application where milliseconds can be transformed into dollars.

PerfectHashmap is optimized for fast `get` and `contains` operations.
It is required that the set of keys is finite, known in advance and the hashcodes for the keys are collision free.
Typically, it's well suited for small, fixed lookup tables. But you should of course benchmark the performance in your usage scenario.

## Usage

The map is built with a builder object:

    Map<Integer, String> map = PerfectHashMap.newBuilder().add(1, "a").add(2, "b").build();

Then all the usual methods can be invoked except new keys cannot be inserted. However, existing keys can have the values updated:

    map.put(1, "c"); // Updates the value for the key 1.

    map.put(9, "d"); // Throws IllegalArgumentException.


## License

(The MIT License)

Copyright &copy; 2013 Nicholas Schultz-Møller

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
'Software'), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

[1]:http://en.wikipedia.org/wiki/Perfect_hash_function
