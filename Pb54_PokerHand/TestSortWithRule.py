import unittest
from Card import Card
from Hand import Hand
from Hand import NullHand
from Ranking import RuleFactory


class TestSortWithStraightFlush(unittest.TestCase):
    
    def setUp(self):
        self.expectedHand = Hand([Card('6', 'H'), Card('5', 'H'), Card('4', 'H'), Card('3', 'H'), Card('2', 'H')])
        self.rule = RuleFactory().straightFlush()

    def testSortWithStraightFlush(self):
        hand = Hand([Card('4', 'H'), Card('3', 'H'), Card('2', 'H'), Card('5', 'H'), Card('6', 'H')])
        sortedHand = self.rule.sort(hand)
        self.assertEqual(0, sortedHand.__cmp__(self.expectedHand))
    
    def testSortWithStraightFlushNotMeet(self):
        hand = Hand([Card('4', 'H'), Card('3', 'H'), Card('2', 'H'), Card('5', 'S'), Card('6', 'H')])
        sortedHand = self.rule.sort(hand)
        self.assertTrue(sortedHand.__cmp__(self.expectedHand) < 0)
    
    def testSortWithStraightFlushNotMeetCompareWithNullHand(self):
        hand = Hand([Card('4', 'H'), Card('3', 'H'), Card('2', 'H'), Card('5', 'S'), Card('6', 'H')])
        sortedHand = self.rule.sort(hand)
        self.assertEqual(0, sortedHand.__cmp__(NullHand()))

class TestSortWithFourOfAKind(unittest.TestCase):
    def setUp(self):
        self.rule = RuleFactory().fourOfAKind()
        self.expectedHand = Hand([Card('2', 'H'), Card('2', 'C'), Card('2', 'H'),Card('2', 'S'),Card('9', 'D')])
    
    def testSortWithFourOfAKind(self):
        hand = Hand([Card('9', 'H'), Card('2', 'C'), Card('2', 'H'),Card('2', 'S'),Card('2', 'D')])
        sortedHand = self.rule.sort(hand)
        self.assertEqual(0, sortedHand.__cmp__(self.expectedHand))
    
    def testSortWithFourOfAKindNotMeet(self):
        hand = Hand([Card('9', 'H'), Card('2', 'C'), Card('3', 'H'),Card('2', 'S'),Card('2', 'D')])
        sortedHand = self.rule.sort(hand)
        self.assertTrue(sortedHand.__cmp__(self.expectedHand) < 0)

class TestSortWithFullHouse(unittest.TestCase):
    def setUp(self):
        self.rule = RuleFactory().fullHouse()
        self.expectedHand = Hand([Card('2', 'H'), Card('2', 'C'), Card('2', 'D'),Card('T', 'S'),Card('T', 'D')])
    
    def testSortWithFourOfAKind(self):
        hand = Hand([Card('T', 'D'), Card('2', 'C'), Card('2', 'H'),Card('T', 'S'),Card('2', 'D')])
        sortedHand = self.rule.sort(hand)
        self.assertEqual(0, sortedHand.__cmp__(self.expectedHand))
    
    def testSortWithFourOfAKindNotMeet(self):
        hand = Hand([Card('T', 'D'), Card('2', 'C'), Card('8', 'H'),Card('T', 'S'),Card('2', 'D')])
        sortedHand = self.rule.sort(hand)
        self.assertTrue(sortedHand.__cmp__(self.expectedHand) < 0)
        self.assertEqual(0, sortedHand.__cmp__(NullHand()))
