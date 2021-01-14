# Euler's method

This program was a personal passion project written during my junior year of high school, in 2016, a month or two before the [Integrator](https://github.com/rossgk2/Integrator) project.

## What is Euler's method?

[Euler's method](https://en.wikipedia.org/wiki/Euler_method) can be read about elsewhere, but I will briefly describe it here. Suppose we are trying to determine the function y that satifies a differential equation of the form dy/dx = g(x, y), where g is some other function, and where we also know that y(x0) = y0, for some particular x0 and y0. For example, we might have dy/dx = x * y(x) and y(0) = 1.

The idea of Euler's method is to use the derivative of y and the initial condition y(x0) = y0 (we know both of these things by assumption) to guess at what the value of y is for an arbitrary input, say x. For the sake of simplicity, assume that x > x0; assume x is "to the right of x0". One "starts" the approximation at the input x0 (we start here because we are given the constraint f(x0) = y0). To estimate y(x), we choose a step size of Delta, and increment from the input point x0 to the input point x1 = x0 + Delta. We then estimate f(x1) as f(x1) ~= y1, where y1 = f(x0) + Delta * df/dx|\_{x = x0} = y0 + Delta * g(x0, f). What we have done here is estimate the value of f at x1 by using the known value of f at x0, travel the short horizontal distance of Delta along the line tangent to f at x0, and measure the height of this tangent line after that short horizontal distance has been traversed. We keep repeating this process (jump to the ith input point, xi, and approximate f(xi) as f(xi) ~= yi, where yi = y\_{i - 1} + (Delta x) * g(x\_{i - 1}, y) until we have reached xn. We can make sure that xn is x, the input point at which we want to approximate y, by construction.

## Implementation and example

In 


Since the solution to the diff

<img src = "eulers_method.PNG">


