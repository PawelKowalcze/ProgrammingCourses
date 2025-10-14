import numpy as np

np.array([1, 2, 3]) # Initialize array

# 2D array
a = np.array([[1, 2, 3],
              [4, 5, 6]])
print(a.shape)

#Array dependencies
a = np.array([1, 2, 3, 4, 5, 6])
print(a)
print(a[0])
a[0] = 100
print(a)
print(a[:3])

b = a[3:]
print(b)

b[0] = 40
print(a)

#Multi-dimensional arrays
#2D array
a = np.array([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]])
print(a)
print(a[2, 3])
print(a.ndim)
print(a.shape)

print(len(a.shape) == a.ndim)
print(a.size)
print(a.dtype)

#Zeros, ones, empty, arange, linspace,

a = np.zeros((3, 4, 5))
print(a)

b = np.ones((2, 3))
print(b)

c = np.empty((4, 3)) # works faster than zeros and ones
print(c)

d = np.arange(10, 30, 5) # start, stop, step
print(d)

e = np.linspace(0, 2, 20) # start, stop, number of elements
print(e)

x = np.ones(2, dtype = np.int64)
print(x)

#Arrays

a = np.arange(60).reshape(2, 2, 3, 5)
print("Reshaped array: \n", a)
print(a.shape)
print(a.ndim)
print(a.dtype.name)
print(a.itemsize)
print(a.size)
type(a)
b = np.array([6, 7, 8])
print(b)
print(type(b))

#Basic operations
a = np.array([20, 30, 40, 50])
b = np.arange(4)
print(b)
c = a - b
print(c)
print(b**2)
print(10 * np.sin(a))
print(a < 35)

A = np.array([[1, 1],
              [0, 1]])
B = np.array([[2, 0],
              [3, 4]])
print(A * B)     # elementwise product
print(A @ B)     # matrix product
print(A.dot(B))  # another matrix product

b = np.arange(12).reshape(3, 4)
print(b)
print(b.sum(axis=0))     # sum of each column
print(b.min(axis=1))     # min of each row
print(b.cumsum(axis=1))  # cumulative sum along each row

#Indexing, slicing, iterating
a = np.arange(10)**3
print(a)
#array([  0,   1,   8,  27,  64, 125, 216, 343, 512, 729])
print(a[2])
#8
print(a[2:5])
# array([ 8, 27, 64])
# equivalent to a[0:6:2] = 1000;
# from start to position 6, exclusive, set every 2nd element to 1000
a[:6:2] = 1000
print(a)
# array([1000,    1, 1000,   27, 1000,  125,  216,  343,  512,  729])
print(a[::-1])  # reversed a
# array([ 729,  512,  343,  216,  125, 1000,   27, 1000,    1, 1000])
for i in a:
    print(i**(1 / 3.))


def f(x, y):
    return 10 * x + y

b = np.fromfunction(f, (5, 4), dtype=int)
print(b)
# array([[ 0,  1,  2,  3],
#        [10, 11, 12, 13],
#        [20, 21, 22, 23],
#        [30, 31, 32, 33],
#        [40, 41, 42, 43]])
print(b[2, 3])
# 23
print(b[0:5, 1])  # each row in the second column of b
# array([ 1, 11, 21, 31, 41])
print(b[:, 1])    # equivalent to the previous example
# array([ 1, 11, 21, 31, 41])
print(b[1:3, :])  # each column in the second and third row of b
# array([[10, 11, 12, 13],
#        [20, 21, 22, 23]])

# The dots (...) represent as many colons as needed to produce a complete indexing tuple. For example, if x is an array with 5 axes, then
#
# x[1, 2, ...] is equivalent to x[1, 2, :, :, :],
#
# x[..., 3] to x[:, :, :, :, 3] and
#
# x[4, ..., 5, :] to x[4, :, :, 5, :].

#Shape manipulation
a = np.array([[3., 7., 3., 4.],
       [1., 4., 2., 2.],
       [7., 2., 4., 9.]])
print(a.ravel())
print(a.reshape(6,2))
print(a.T)

# The reshape function returns its argument with a modified shape, whereas the ndarray.resize method modifies the array itself:
# If a dimension is given as -1 in a reshaping operation, the other dimensions are automatically calculated:
print(a.reshape(2, -1))


A = np.array([[1, 1],
              [0, 1]])
B = np.array([[2, 0],
              [3, 4]])

print(np.vstack((A, B)))
print(np.hstack((A, B)))

# Using hsplit, you can split an array along its horizontal axis, either by specifying the number of equally shaped arrays to return, or by specifying the columns after which the division should occur:
#
# a = np.floor(10 * rg.random((2, 12)))
# a
# array([[6., 7., 6., 9., 0., 5., 4., 0., 6., 8., 5., 2.],
#        [8., 5., 5., 7., 1., 8., 6., 7., 1., 8., 1., 0.]])
# # Split `a` into 3
# np.hsplit(a, 3)
# [array([[6., 7., 6., 9.],
#        [8., 5., 5., 7.]]), array([[0., 5., 4., 0.],
#        [1., 8., 6., 7.]]), array([[6., 8., 5., 2.],
#        [1., 8., 1., 0.]])]
# # Split `a` after the third and the fourth column
# np.hsplit(a, (3, 4))
# [array([[6., 7., 6.],
#        [8., 5., 5.]]), array([[9.],
#        [7.]]), array([[0., 5., 4., 0., 6., 8., 5., 2.],
#        [1., 8., 6., 7., 1., 8., 1., 0.]])]
# vsplit splits along the vertical axis, and array_split allows one to specify along which axis to split.

##Copies
a = np.arange(int(1e8))
b = a[:100].copy()
del a  # the memory of ``a`` can be released.


# Array Creation
# arange, array, copy, empty, empty_like, eye, fromfile, fromfunction, identity, linspace, logspace, mgrid, ogrid, ones, ones_like, r_, zeros, zeros_like
#
# Conversions
# ndarray.astype, atleast_1d, atleast_2d, atleast_3d, mat
#
# Manipulations
# array_split, column_stack, concatenate, diagonal, dsplit, dstack, hsplit, hstack, ndarray.item, newaxis, ravel, repeat, reshape, resize, squeeze, swapaxes, take, transpose, vsplit, vstack
#
# Questions
# all, any, nonzero, where
#
# Ordering
# argmax, argmin, argsort, max, min, ptp, searchsorted, sort
#
# Operations
# choose, compress, cumprod, cumsum, inner, ndarray.fill, imag, prod, put, putmask, real, sum
#
# Basic Statistics
# cov, mean, std, var
#
# Basic Linear Algebra
# cross, dot, outer, linalg.svd, vdot


# Indexing with arrays of indices
a = np.arange(12)**2  # the first 12 square numbers
i = np.array([1, 1, 3, 8, 5])  # an array of indices
print(a[i])  # the elements of `a` at the positions `i`
# array([ 1,  1,  9, 64, 25])

j = np.array([[3, 4], [9, 7]])  # a bidimensional array of indices
print(a[j])  # the same shape as `j`
# array([[ 9, 16],
#        [81, 49]])


a = np.arange(12).reshape(3, 4)
a
# array([[ 0,  1,  2,  3],
#        [ 4,  5,  6,  7],
#        [ 8,  9, 10, 11]])
i = np.array([[0, 1],  # indices for the first dim of `a`
              [1, 2]])
j = np.array([[2, 1],  # indices for the second dim
              [3, 3]])

a[i, j]  # i and j must have equal shape
# array([[ 2,  5],
#        [ 7, 11]])

a[i, 2]
# array([[ 2,  6],
#        [ 6, 10]])

a[:, j]
# array([[[ 2,  1],
#         [ 3,  3]],
#
#        [[ 6,  5],
#         [ 7,  7]],
#
#        [[10,  9],
#         [11, 11]]])


rng = np.random.default_rng()
rng.random()
rng.standard_normal(10)
rng.integers(low=0, high=10, size=5)