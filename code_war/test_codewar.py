from unittest import TestCase
from codewar import *

class TestGetUnsortedPairs(TestCase):
    sample = [1,5,2,2,2,5,5,4]
    k = 3
    def test_that_get_unsorted_pairs_exists(self):
        get_unsorted_pairs(sample, k)

    def test_that_get_unsorted_pairs_return_correct_value(self):
        actual = get_unsorted_pairs(sample, k)
        self.assert
