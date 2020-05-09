import unittest

from app import sum_search

class ObjectSearcherTest(unittest.TestCase):

    def test_of_tests(self):
        ans = 1 + 2
        self.assertEqual(3,ans)

    def test_sum_search(self):
        with open('sample.json', 'r') as json_file:
            actual = sum_search(json_file)
            self.assertEqual(6, actual)
