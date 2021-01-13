# Euler's method

This program was a personal passion project written during my junior year of high school, in 2016, a month or two before the [Integrator](https://github.com/rossgk2/Integrator) project.

## What is Euler's method?

[Euler's method](https://en.wikipedia.org/wiki/Euler_method) can be read about elsewhere, but I will briefly describe it here. Suppose we are trying to determine the function f that satifies a differential equation of the form df/dx = g(x, y), where g is some other function, and where we also know that f(x0) = y0, for some particular x0 and y0. For example, we might have df/dx = x * f(x) and f(0) = 1. (More traditionally, this equation would be written as: dy/dx = x * y, y(0) = 1).

with the constraint- or *initial condition*- that f(x0) = y0 for some particular x0 and y0. Euler's method provides a means of computing 

<img src = "eulers_method.PNG">

