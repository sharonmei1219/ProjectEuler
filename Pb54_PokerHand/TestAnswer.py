from Card import Card
from Hand import Hand
from TestHandBuilder import HandsBuilder
import unittest
from PokerHand import PokerHand
from Ranking import CardsWithSameValue
from Ranking import RuleFactory

class CardTest(unittest.TestCase):

    def setUp(self):
        rules = RuleFactory()
        self.Straight = rules.straight()
        self.Flush = rules.flush()
        self.StraightFlush = rules.straightFlush()
        self.HightCards = rules.highCards()
        self.onePair = rules.onePair()
        self.twoPairs = rules.twoPairs()
        self.threeOfAKind = rules.threeOfAKind()
        self.fullHouse = rules.fullHouse()
        self.fourOfAKind = rules.fourOfAKind()

    def tearDown(self):
        pass

    def testCardCreation(self):
        card1 = Card('T', 'D')
        card2 = Card('T', 'D')
        self.assertTrue(card1.equals(card2))
    
    def testCardWithSameValue(self):
        card1 = Card('T', 'D')
        card2 = Card('T', 'H')
        self.assertTrue(card1.__cmp__(card2) == 0)
    
    def testCardWithSameSuit(self):
        card1 = Card('T', 'D')
        card2 = Card('2', 'D')
        self.assertTrue(card1.sameSuitWith(card2))
    
    def testCardCompare(self):
        card1 = Card('T', 'D')
        card2 = Card('2', 'S')
        self.assertTrue(card1.__cmp__(card2) > 0)
    
    def testHandGroupSameValue(self):
        hand = Hand([Card('T', 'H'), Card('4','S'), Card('T', 'D')])
        groupedCards = hand.groupCards(CardsWithSameValue())
        self.assertEqual(2, len(groupedCards))
        self.assertEqual(2, len(groupedCards[0]))
        self.assertEqual(1, len(groupedCards[1]))
    
    def testOnePairRule(self):
        hand = Hand([Card('5', 'D'), Card('4', 'S'), Card('7', 'H'), Card('4','C'), Card('2', 'H')])
        expectedHand = Hand([Card('4', 'S'), Card('4','C'), Card('7', 'H'), Card('5', 'D'), Card('2', 'H')])
        onePairRule = RuleFactory().onePair()
        self.assertEqual(0, onePairRule.sort(hand).__cmp__(expectedHand))
    
    def testTwoPairsRule(self):
        hand = Hand([Card('T', 'S'), Card('7', 'D'), Card('4', 'S'), Card('7', 'H'), Card('4','C')])
        expectedHand = Hand([Card('7', 'D'), Card('7', 'H'), Card('4', 'S'), Card('4','C'), Card('T', 'S')])
        twoPairsRule = self.twoPairs
        self.assertEqual(0, twoPairsRule.sort(hand).__cmp__(expectedHand))
    
    def testHighCard(self):
        hand = Hand([Card('2', 'D'), Card('3', 'H'), Card('T', 'D'), Card('A','H'), Card('7','S')])
        expectedHand = Hand([Card('A','H'), Card('T', 'D'), Card('7','S'), Card('3', 'H'), Card('2', 'D')])
        highCards = RuleFactory().highCards()
        self.assertEqual(0, highCards.sort(hand).__cmp__(expectedHand))
    
    def testFullHouse(self):
        hand = Hand([Card('7', 'D'), Card('7', 'S'), Card('8', 'H'), Card('8', 'C'), Card('8', 'D')])
        expectedHand = Hand([Card('8', 'H'), Card('8', 'C'), Card('8', 'D'), Card('7', 'D'), Card('7', 'S')])
        self.assertEqual(0, self.fullHouse.sort(hand).__cmp__(expectedHand))
    
    def testStraight(self):
        hand = Hand([Card('T', 'S'), Card('J', 'H'), Card('7', 'D'), Card('8', 'S'), Card('9', 'H')])
        expectedHand = Hand([Card('J', 'H'), Card('T', 'S'), Card('9', 'H'), Card('8', 'S'), Card('7', 'D')])
        straightRule = RuleFactory().straight()
        self.assertEqual(0, straightRule.sort(hand).__cmp__(expectedHand))
    
    def testSameSuit(self):
        hand = Hand([Card('3', 'D'), Card('4', 'D'), Card('T', 'D'), Card('Q', 'D'), Card('J', 'D')])
        expectedHand = Hand([Card('Q', 'D'), Card('J', 'D'), Card('T', 'D'), Card('4', 'D'), Card('3', 'D')])
        flush = RuleFactory().flush()
        self.assertEqual(0, flush.sort(hand).__cmp__(expectedHand))
    
    def testStraighFlushCmp(self):
        hand1 = HandsBuilder().straightFlush('T', 'D')
        hand2 = HandsBuilder().straightFlush('9', 'H')
        self.assertTrue(PokerHand().compareHand(hand1, hand2) > 0)
    
    def testStraightFlushCmpToFourOfAKind(self):
        hand1 = HandsBuilder().straightFlush('3', 'S')
        hand2 = HandsBuilder().FourOfAKind('T')
        self.assertTrue(PokerHand().compareHand(hand1, hand2) > 0)
    
    def testFourOfAKindCompare(self):
        hand1 = HandsBuilder().FourOfAKind('5')
        hand2 = HandsBuilder().FourOfAKind('3')
        self.assertTrue(PokerHand().compareHand(hand1, hand2) > 0)
    
    def testFourOfAKindCmpToFullHouse(self):
        hand1 = HandsBuilder().FourOfAKind('5')
        hand2 = HandsBuilder().FullHouse('9', 'A')
        self.assertTrue(PokerHand().compareHand(hand1, hand2) > 0)
    
    def testFullHouseCompare(self):
        hand1 = HandsBuilder().FullHouse('J', '2')
        hand2 = HandsBuilder().FullHouse('T', '9')
        self.assertTrue((PokerHand().compareHand(hand1, hand2) > 0))
    
    def testFullHouseOverFlush(self):
        hand1 = HandsBuilder().FullHouse('2', '3')
        hand2 = HandsBuilder().Flush('2', '4', '5', '7', 'A', 'D')
        self.assertTrue((PokerHand().compareHand(hand1, hand2) > 0))

    def testFlushCompare(self):
        hand1 = HandsBuilder().Flush('A', 'T', '9', '4', '2', 'H')
        hand2 = HandsBuilder().Flush('A', 'T', '9', '3', '2', 'S')
        self.assertTrue((PokerHand().compareHand(hand1, hand2) > 0))
    
    def testFlushOverStraight(self):
        hand1 = HandsBuilder().Flush('6', '5', '9', '3', '2', 'S')
        hand2 = HandsBuilder().Straight('9')
        self.assertTrue((PokerHand().compareHand(hand1, hand2) > 0))
    
    def testStraightCompare(self):
        hand1 = HandsBuilder().Straight('4')
        hand2 = HandsBuilder().Straight('2')
        self.assertTrue((PokerHand().compareHand(hand1, hand2) > 0))
    
    def testStraightOver3OfAKind(self):
        hand1 = HandsBuilder().Straight('2')
        hand2 = HandsBuilder().ThreeOfAKind('T','Q','A')
        self.assertTrue((PokerHand().compareHand(hand1, hand2) > 0))
    
    def test3OfAKindCompare(self):
        hand1 = HandsBuilder().ThreeOfAKind('4','2','5')
        hand2 = HandsBuilder().ThreeOfAKind('3','Q','A')
        self.assertTrue((PokerHand().compareHand(hand1, hand2) > 0))
    
    def test3OfAKindOver2Pairs(self):
        hand1 = HandsBuilder().ThreeOfAKind('4','2','5')
        hand2 = HandsBuilder().TwoPairs('3','Q','A')
        self.assertTrue((PokerHand().compareHand(hand1, hand2) > 0))
    
    def test2PairsCompare(self):
        hand1 = HandsBuilder().TwoPairs('3','6','A')
        hand2 = HandsBuilder().TwoPairs('3','6','T')
        self.assertTrue((PokerHand().compareHand(hand1, hand2) > 0))
    
    def test2PairsOver1Pair(self):
        hand1 = HandsBuilder().TwoPairs('3', '6', '4')
        hand2 = HandsBuilder().OnePair('A', 'Q', 'K', 'T')
        self.assertTrue((PokerHand().compareHand(hand1, hand2) > 0))
    
    def test1PairCompare(self):
        hand1 = HandsBuilder().OnePair('A', 'Q', 'K', 'J')
        hand2 = HandsBuilder().OnePair('A', 'Q', 'K', 'T')
        self.assertTrue((PokerHand().compareHand(hand1, hand2) > 0))
    
    def test1PairOverHighCards(self):
        hand1 = HandsBuilder().OnePair('2', 'K', 'T', 'J')
        hand2 = HandsBuilder().HighCards('A', 'K', 'Q', 'J', '9')
        self.assertTrue((PokerHand().compareHand(hand1, hand2) > 0))
    
    def testCase1FromFile(self):
        hand1 = Hand([Card('8', 'C'), Card('T', 'S'), Card('K', 'C'), Card('9', 'H'), Card('4', 'S')])
        hand2 = Hand([Card('7', 'D'), Card('2', 'S'), Card('5', 'D'), Card('3', 'S'), Card('A', 'C')])
        self.assertFalse((PokerHand().compareHand(hand1, hand2) > 0))
    
    
    def GetAnswerPE054(self):
        count = 0
        pokerHand = PokerHand()
        pokerInputFile = open('d:\poker.txt', 'r')
        play = pokerInputFile.readline()
        playIndex = 0
        while play is not '':
            playIndex += 1
            cardsInPlay = play.split(' ')
            cards1 = []
            cards2 = []
            for index in range(5):
                cards1.append(Card(cardsInPlay[index][0], cardsInPlay[index][1]))
                hand1 = Hand(cards1)
            for index in range(5, 10):
                cards2.append(Card(cardsInPlay[index][0], cardsInPlay[index][1]))
                hand2 = Hand(cards2)
            if(pokerHand.compareHand(hand1, hand2) > 0):
                count = count + 1
            play = pokerInputFile.readline()
        
        print "the answer is " + str(count)
    
    def testJieCheng(self):
        print "10! = ", reduce(lambda x, y: x * y, range(1, 10))
            
