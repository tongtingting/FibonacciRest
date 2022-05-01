package de.robertz.fibonaccirest.controller;

import de.robertz.fibonaccirest.cache.CacheMap;
import de.robertz.fibonaccirest.math.FunctionsCalculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class FibonacciController {

    /**
     * This part was just for experimenting
     * Using the cache seems to be always slower. Empirically tested.
     */
    private static final boolean USE_CACHE = true;
    //a threadsafe chachemap since RestController in spring is multithreaded
    private static final Map<Long, Long> cache = Collections.synchronizedMap(new CacheMap<>(10));

    /******************************/

    //TODO add parameters to use FunctionsCalculator#calculateFibonacciIterative and calculateFibonacciMoivreBinet
    @GetMapping("/fibonacci/{nr}")
    public long handleFibonacci(@PathVariable int nr) {

        if (USE_CACHE) {
            Long f = cache.get((long) nr);

            if (f != null) {
                return f;
            }
        }

        long fib = FunctionsCalculator.calculateFibonacciMoivreBinet(nr);

        if (USE_CACHE) {
            cache.put((long) nr, fib);
        }

        return fib;
    }

}
